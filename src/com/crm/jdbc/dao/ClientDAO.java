package com.crm.jdbc.dao;

import com.crm.jdbc.db.DBConnection;
import com.crm.jdbc.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO {

    public void insert(Client client) throws SQLException {

        String sql = "INSERT INTO client (name, email) VALUES (?, ?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.executeUpdate();
        }
    }
}
