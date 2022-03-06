package jdbc_connection;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException, IOException {
		DBConnectionDAO db_connection = new DBConnectionDAO();
		//db_connection.insertQueryInTable();
		db_connection.updateTable(6, "Very Special Latte", 10);
		//db_connection.selectOneTuple(6);
		
		db_connection.saveAllElementsAsFile();
	}
}
 