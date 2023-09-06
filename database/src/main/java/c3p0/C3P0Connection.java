package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Connection {
    public static void main(String[] args) throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT" );
        cpds.setUser("root");
        cpds.setPassword("123456");
        cpds.setMaxPoolSize(5);
        cpds.setInitialPoolSize(3);
        cpds.setCheckoutTimeout(3000);

        //创建数据库连接池对象datasource
        for (int i = 1; i <=5 ; i++) {
            long begin =System.currentTimeMillis();
            try {
                Connection conn = cpds.getConnection();
                //conn.close();
            }catch (SQLException e){
                long end =System.currentTimeMillis();
                System.out.println("第"+i+"个连接失败，等待时间："+(end-begin)+"ms");
            }
            long end =System.currentTimeMillis();
            System.out.println("第"+i+"个连接所用时间"+(end-begin)+"ms");

        }

    }
}
