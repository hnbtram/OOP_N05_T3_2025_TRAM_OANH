package com.example.internetcafe.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InternetCafeDB {

    private static final String DB_URL = "jdbc:mysql://your-aiven-host:port/internet_cafe_db";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    /**
     * Lấy kết nối đến database quán nét
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
    }

    /**
     * Lấy danh sách máy tính trong quán
     */
    public List<Computer> getAllComputers() throws SQLException {
        List<Computer> computers = new ArrayList<>();
        
        String sql = "SELECT computer_id, name, status, hourly_rate FROM computers WHERE is_active = true";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Computer computer = new Computer(
                    rs.getInt("computer_id"),
                    rs.getString("name"),
                    rs.getString("status"),
                    rs.getDouble("hourly_rate")
                );
                computers.add(computer);
            }
        }
        return computers;
    }

    /**
     * Thêm giao dịch mới vào database
     */
    public boolean addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (computer_id, customer_id, start_time, duration, total_amount) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, transaction.getComputerId());
            stmt.setInt(2, transaction.getCustomerId());
            stmt.setTimestamp(3, Timestamp.valueOf(transaction.getStartTime()));
            stmt.setInt(4, transaction.getDurationMinutes());
            stmt.setDouble(5, transaction.getTotalAmount());
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        transaction.setTransactionId(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Lấy thông tin khách hàng
     */
    public Customer getCustomerById(int customerId) throws SQLException {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, customerId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("membership_points")
                    );
                }
            }
        }
        return null;
    }

    /**
     * Cập nhật trạng thái máy tính
     */
    public boolean updateComputerStatus(int computerId, String status) throws SQLException {
        String sql = "UPDATE computers SET status = ? WHERE computer_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, status);
            stmt.setInt(2, computerId);
            
            return stmt.executeUpdate() > 0;
        }
    }
}