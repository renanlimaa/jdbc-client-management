import com.crm.jdbc.dao.ClientDAO;
import com.crm.jdbc.model.Client;

import java.sql.SQLException;

public static void main(String[] args) throws SQLException {

    Client client = new Client("Johnny Test", "johnnytest@gmail.com");

    ClientDAO dao = new ClientDAO();
    dao.insert(client);

    System.out.println("Client inserted sucessfully!");

}
