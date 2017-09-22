package com.newlecture.webapp.entity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	String sql = "SELECT *FROM Notice";

	String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

	// JDBC ����̹� �ε�
	Class.forName("com.mysql.jdbc.Driver");
	// ���� / ����
	Connection con = DriverManager.getConnection(url, "sist", "cclass");
	// ����
	Statement st = con.createStatement();

	// ��� ��������
	ResultSet rs = st.executeQuery(sql);

	// Model
	List<Notice> list = new ArrayList<>();
	// ��� ����ϱ�
	while(rs.next())
	{
		Notice n = new Notice();
		n.setId(rs.getString("ID"));
		n.setTitle(rs.getString("TITLE"));
		// ..

		list.add(n);
	}
	rs.close();st.close();con.close();
	
	
	for(Notice n:list)
		System.out.println(n.getId());
	
	
	
	}
}
