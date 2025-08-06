public class DBConnection {
    private static final String URL = "jdbc:mysql://host:port/quannet_db";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }
}