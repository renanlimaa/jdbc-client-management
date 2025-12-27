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

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.executeUpdate();
        }
    }

    public List<Client> findAll() throws SQLException {
        List<Client> clientes = new ArrayList<>();
        String sql = "SELECT id, name, email FROM client";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id"); // já pega o ID também
                String name = rs.getString("name");
                String email = rs.getString("email");

                Client client = new Client(id, name, email);
                clientes.add(client);
            }
        }

        return clientes;
    }

    public Client findById(int id) throws SQLException {
        String sql = "SELECT id, name, email FROM client WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int clientId = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                return new Client(clientId, name, email);
            }
        }

        return null;
    }

    public void updateEmail(int id, String newEmail) throws SQLException {
        String sql = "UPDATE client SET email = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newEmail);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
