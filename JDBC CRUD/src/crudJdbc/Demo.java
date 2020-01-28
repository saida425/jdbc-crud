package crudJdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Demo {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/crud", "root", "root");

		Statement st = con.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter your id :");

		int id = Integer.parseInt(br.readLine());

		System.out.println("Enter your name :");
		String name = br.readLine();

		System.out.println("Enter your address :");
		String address = br.readLine();

		st.execute("insert into person (id,name,address) " + "values (" + "\"" + id + "\"" + "," + "\"" + name + "\""
				+ "," + "\"" + address + "\"" + ")");

		System.out.println(name + " your record inserted");
		System.out.println("");

		String sql = "select * from person";

		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}

		st.close();
		con.close();
		
	}
}
