package com.company;

import java.sql.*;

public class DBConnection {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String user;
    private String password;
    private String url;

    DBConnection(){}

    void readFromDB() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sockets");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * from Sockets");
            System.out.print("Successful query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int close(){
        return 0;
    }

    public int open(){
        return 0;
    }
}
