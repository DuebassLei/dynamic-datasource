package com.iwhale.dynamic.util;

import java.sql.*;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2021/5/28 9:51
 *
 * JdbcUtil 工具类
 */
public class JDBCUtils {

    //---> 本机测试 <---
//    //用户名
//    private static String user = "iom";
//    //密码
//    private static String password = "root";
//    //jdbcUrl---->> jdbc:oracle:thin:@地址:端口号:实例名
//    private static String url = "jdbc:oracle:thin:@localhost:15211:helowin";


    //---> 测试库 10.174.242.24<---
    //用户名
    private static String user = "iom";
    //密码
    private static String password = "ynydpass";
    //jdbcUrl---->> jdbc:oracle:thin:@地址:端口号:实例名
    private static String url = "jdbc:oracle:thin:@10.174.242.24:1521:inastest";
    //oracle驱动
    private static String jdbc_driver = "oracle.jdbc.OracleDriver";
    // 静态块加载oracle数据库的驱动
    static {
        try {
            Class.forName(jdbc_driver);
        } catch (ClassNotFoundException e) {
            // TODO handle exception
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 创建连接
     *
     * @return
     * @throws SQLException 抛出异常，给要调用的地方处理
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 关闭连接(释放连接)
     *
     * @param res
     *            结果集
     * @param st
     *            用于执行静态 SQL 语句并返回它所生成结果的对象（PreparedStatement
     *            继承了Statement，PreparedStatement是预编译的更加的灵活）
     * @param conn
     *            连接
     */
    public static void free(ResultSet res, Statement st, Connection conn) {
        try {
            if (res != null) {
                res.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

    }
}
