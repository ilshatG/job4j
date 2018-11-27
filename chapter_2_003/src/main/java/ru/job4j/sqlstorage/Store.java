package ru.job4j.sqlstorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Store {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgres://localhost:5432/products";
        String username = "postgres";
        String password = "519977";
        Connection conn = DriverManager.getConnection(url, username, password);


    }
}
