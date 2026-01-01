package com.crm.jdbc.application;

import com.crm.jdbc.dao.ClientDAO;
import com.crm.jdbc.model.Client;

public class Main {
    public static void main(String[] args) {

        ClientDAO dao = new ClientDAO();

        System.out.println("\n--- INSERT ---");
        Client client = new Client("Johnny Test", "johnnytest@gmail.com");
        dao.insert(client);
        System.out.println("Client inserted!");

        System.out.println("\n--- FIND ALL ---");
        dao.findAll().forEach(c ->
                System.out.println(c.getId() + " | " + c.getName() + " | " + c.getEmail())
        );

        System.out.println("\n--- FIND BY ID (1) ---");
        Client found = dao.findById(1);
        System.out.println(found != null ?
                found.getName() + " found!" :
                "No client found with this ID."
        );

        System.out.println("\n--- UPDATE EMAIL ---");
        dao.updateEmail(1, "johnny.updated@gmail.com");
        System.out.println("Email updated!");

        System.out.println("\n--- DELETE BY ID ---");
        dao.deleteById(1);
        System.out.println("Client deleted!");

        System.out.println("\nCRUD executed successfully!");
    }
}
