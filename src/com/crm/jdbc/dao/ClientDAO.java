package com.crm.jdbc.dao;

import com.crm.jdbc.db.DBConnection;
import com.crm.jdbc.exception.DatabaseException;
import com.crm.jdbc.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public void insert(Client client) {
        String sql = "INSERT INTO client (name, email) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao inserir cliente", e);
        }
    }

    public List<Client> findAll() {
        List<Client> clientes = new ArrayList<>();
        String sql = "SELECT id, name, email FROM client";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                clientes.add(new Client(id, name, email));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao buscar todos os clientes", e);
        }

        return clientes;
    }

    public Client findById(int id) {
        String sql = "SELECT id, name, email FROM client WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao buscar cliente por ID", e);
        }

        return null;
    }

    public void updateEmail(int id, String newEmail) {
        String sql = "UPDATE client SET email = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newEmail);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao atualizar email do cliente", e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM client WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao deletar cliente", e);
        }
    }
}
