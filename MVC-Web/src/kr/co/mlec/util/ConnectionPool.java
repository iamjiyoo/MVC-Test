package kr.co.mlec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class ConnectionPool {
	private static final int INIT_COUNT = 5;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private static ArrayList<Connection> freeList = new ArrayList<>();
	private static ArrayList<Connection> usedList = new ArrayList<>();
	
	static {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			for(int i = 1; i <= INIT_COUNT; i++) {
				freeList.add(DriverManager.getConnection(URL, "hr", "hr"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����Ŭ ����̹� �ε�, ����Ŭ �����ͺ��̽��� ������ �� ���ᰴü ��ȯ
	 */
//	public Connection getConnection() {
//		Connection conn = null;
//		try {
//			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			String url      = "jdbc:oracle:thin:@localhost:1521:orcl";
//			String user     = "hr";
//			String password = "hr";
//			
//			conn = DriverManager.getConnection(url, user, password);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return conn;
//	}
	
	public static Connection getConnection() throws Exception {

		if(freeList.isEmpty()) {
			throw new Exception("�����ִ� Ŀ�ؼ��� �����ϴ�.");
		}
		
		Connection conn = freeList.remove(0);
		usedList.add(conn);
		
		System.out.println("������� Ŀ�ؼ� �� : " + usedList.size());
		System.out.println("����ִ� Ŀ�ؼ� �� : " + freeList.size());
		
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String user = "hr";
//		String password = "hr";
//
//		Connection conn = DriverManager.getConnection(url, user, password);
//
		return conn;
	}
	
	public static void close(Connection conn) {
		usedList.remove(usedList.indexOf(conn));
		freeList.add(conn);
	}
}








