package com.zl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn = null;

    /*
     * 一个取得连接的静态方法
     */
    public static Connection getConnection() {
        try {
            // 加载驱动
             Class.forName("oracle.jdbc.driver.OracleDriver");
            // 创建连接
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@127.0.0.1:1521:orcl", "SCOTT", "tiger");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
		System.out.println(DBConnection.getConnection().getClass());
	}
}
