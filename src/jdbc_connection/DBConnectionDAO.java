package jdbc_connection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

public class DBConnectionDAO {
	private Connection connection; // db connection 연결 개체
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/mona_db_test";
	private static int lastElementIndex = -1;

	public DBConnectionDAO() {
		System.out.println("시스템 시작");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("DB 로딩 성공");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 로딩 실패");
			e.printStackTrace();
		}
	}

	// coffee 테이블에 값 넣기
	public void insertQueryInTable(String coffee_name, float price) throws SQLException {
		String sql = "insert into coffee values(?,?,?)"; // id, name, price
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, 6); // the second number has to be updated.
			pstmt.setString(2, coffee_name);
			pstmt.setFloat(3, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("데이터삽입 성공.");
		}
		try {
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("데이터삽입 실패.");
			e.printStackTrace();
		} finally {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		}
	}

	// id를 통해 단 하나의 아이템만 찾아옴
	public void selectOneTuple(int id) throws SQLException {
		String sql = "select * from coffee where coffee_id = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet resultSet = pstmt.executeQuery(); // set을 돌면서 id값의 내용을 출력.
			if (resultSet.next()) {
				System.out.println("id: " + resultSet.getInt("coffee_id"));
				System.out.println("coffee name: " + resultSet.getString("coffee_name"));
				System.out.println("price: " + resultSet.getDouble("price"));
			}
		} catch (SQLException e) {
			System.out.println("select 오류발생.");
			e.printStackTrace();

		} finally {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		}
	}

	// return item info as String.
	public String printItemInfoToSaveAsFile(int id) throws SQLException {
		String sql = "select * from coffee where coffee_id = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				String text = resultSet.getString("coffee_name") + " " + resultSet.getDouble("price");
				System.out.println(text);
				return text;
			}
		} catch (SQLException e) {
			System.out.println("select 오류발생");
			e.printStackTrace();
		} finally {
			if (pstmt != null && pstmt.isClosed()) {
				pstmt.close();
			}
		}
		return null;

	}

	// show all elements
	public void selectAll() {
		String sql = "select * from coffee";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery(sql);

			// 1. find out num of columns
			ResultSetMetaData md = resultSet.getMetaData();
			int column = md.getColumnCount();
			System.out.println("컬럼 수 : " + column);
			// 2. find out num of rows
			// resultSet.last();
			// int row = resultSet.getRow();
			// resultSet.beforeFirst();

			// for (int i = 1; i <= 2; i++) {
			// selectOneTuple(i);
			// }

		} catch (SQLException e) {
			System.out.println("selectAll 오류발생.");
			e.printStackTrace();
		}
	}

	// show all elements from table
	public void selectAllElements() throws SQLException {
		findLastElementIndex();

		if (lastElementIndex != -1) {
			for (int i = 1; i <= lastElementIndex; i++) {
				selectOneTuple(i);
			}
		} else
			System.out.println("selectAll index out of exception.");
	}

	// save all items as txt file
	public void saveAllElementsAsFile() throws SQLException, IOException {
		findLastElementIndex();
		FileWriter fw = null;
		File file = new File("C:/Users/Soohyun/Desktop/coffee_menu.txt");
		if (!file.exists())
			file.createNewFile();

		try {
			fw = new FileWriter(file);
			if (lastElementIndex != -1) {
				for (int i = 1; i <= lastElementIndex; i++) {
					String text = printItemInfoToSaveAsFile(i);
					fw.write(text + "\n");
				}
			} else
				System.out.println("selectAll index out of exception.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fw.close();

	}

	// find numOfRows
	public void findLastElementIndex() {
		String sql = "select count(*) from coffee";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			int rowCnt = 0;

			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				rowCnt = resultSet.getInt(1);
				lastElementIndex = rowCnt;
			}
		} catch (SQLException e) {
			System.out.println("index error.");
			e.printStackTrace();
		}
	}

	public void updateTable(int id, String new_name, float new_price) throws SQLException {
		String spl = "update coffee set coffee_name = ?, price = ? where coffee_id = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(spl);
			pstmt.setString(1, new_name);
			pstmt.setFloat(2, new_price);
			pstmt.setInt(3, id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("수정된 id: " + id);
				System.out.println("데이터 업데이트 성공");
			}
		} catch (SQLException e) {
			System.out.println("update 오류발생.");
			e.printStackTrace();
		} finally {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		}
	}
}
