package com.crm.jdbc.db;

public class DBConfig {

    public static final String URL =
            "jdbc:mysql://localhost:3306/crm_db";

    public static final String USER = "root";

    public static final String PASSWORD =
            System.getenv("DB_PASSWORD");

}
