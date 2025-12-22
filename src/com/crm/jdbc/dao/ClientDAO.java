package com.crm.jdbc.dao;

import com.crm.jdbc.db.DBConnection;
import com.crm.jdbc.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Client> findAll() throws SQLException {

        List<Client> clientes = new ArrayList<>();

        String sql = "SELECT name, email FROM client";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");

                Client client = new Client(name, email);
                clientes.add(client);
            }
        }

        return clientes;
    }
}
