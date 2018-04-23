package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
	    DBConnection connect = new DBConnection();
	    connect.readFromDB();
    }
}
