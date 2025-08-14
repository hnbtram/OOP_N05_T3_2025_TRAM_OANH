const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');

const app = express();
const port = 3000;

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root', // Thay đổi nếu cần
    password: '', // Thay đổi nếu cần
    database: 'quan_ly_quan_net'
});

connection.connect(err => {
    if (err) {
        console.error('Lỗi kết nối database: ' + err.stack);
        return;
    }
    console.log('Kết nối database thành công với id ' + connection.threadId);
});

app.use(cors());
app.use(express.json());

// API lấy danh sách máy tính
app.get('/api/computers', (req, res) => {
    connection.query('SELECT * FROM computers', (error, results) => {
        if (error) throw error;
        res.json(results);
    });
});

// API lấy danh sách dịch vụ
app.get('/api/services', (req, res) => {
    connection.query('SELECT * FROM services', (error, results) => {
        if (error) throw error;
        res.json(results);
    });
});

// API lấy danh sách khách hàng
app.get('/api/customers', (req, res) => {
    connection.query('SELECT * FROM customers', (error, results) => {
        if (error) throw error;
        res.json(results);
    });
});

// API thêm khách hàng mới
app.post('/api/customers', (req, res) => {
    const { id, name, phone } = req.body;
    connection.query('INSERT INTO customers (id, name, phone) VALUES (?, ?, ?)', [id, name, phone], (error, results) => {
        if (error) {
            console.error(error);
            return res.status(500).json({ success: false, message: 'Lỗi khi thêm khách hàng' });
        }
        res.status(201).json({ success: true, message: 'Thêm khách hàng thành công' });
    });
});

// API cập nhật khách hàng
app.put('/api/customers/:id', (req, res) => {
    const { id } = req.params;
    const { name, phone } = req.body;
    connection.query('UPDATE customers SET name = ?, phone = ? WHERE id = ?', [name, phone, id], (error, results) => {
        if (error) throw error;
        res.json({ success: true, message: 'Cập nhật khách hàng thành công' });
    });
});

// API xóa khách hàng
app.delete('/api/customers/:id', (req, res) => {
    const { id } = req.params;
    connection.query('DELETE FROM customers WHERE id = ?', [id], (error, results) => {
        if (error) throw error;
        res.json({ success: true, message: 'Xóa khách hàng thành công' });
    });
});

// API lưu giao dịch mới
app.post('/api/transactions', (req, res) => {
    const { customerId, computerId, startTime, endTime, totalAmount, serviceDetails } = req.body;
    const transactionId = `GD${Date.now()}`;
    const transactionSql = 'INSERT INTO transactions (id, customer_id, computer_id, start_time, end_time, total_amount) VALUES (?, ?, ?, ?, ?, ?)';
    const customerUpdateSql = 'UPDATE customers SET total_spent = total_spent + ? WHERE id = ?';
    
    connection.beginTransaction(err => {
        if (err) { throw err; }
        connection.query(transactionSql, [transactionId, customerId, computerId, startTime, endTime, totalAmount], (error, results) => {
            if (error) {
                return connection.rollback(() => { throw error; });
            }

            const transactionServicesSql = 'INSERT INTO transaction_services (transaction_id, service_id, quantity, price_at_time) VALUES ?';
            const serviceValues = serviceDetails.map(s => [transactionId, s.id, s.quantity, s.price]);
            
            if (serviceValues.length > 0) {
                connection.query(transactionServicesSql, [serviceValues], (error, results) => {
                    if (error) {
                        return connection.rollback(() => { throw error; });
                    }
                    connection.commit(err => {
                        if (err) {
                            return connection.rollback(() => { throw err; });
                        }
                        res.status(201).json({ success: true, message: 'Thanh toán thành công' });
                    });
                });
            } else {
                connection.commit(err => {
                    if (err) {
                        return connection.rollback(() => { throw err; });
                    }
                    res.status(201).json({ success: true, message: 'Thanh toán thành công' });
                });
            }
        });
    });
});


app.listen(port, () => {
    console.log(`Server đang chạy tại http://localhost:${port}`);
});