package com.chap_12_db;

import java.sql.*;

public class GatewayDAO {
    private Connection conn;

    public GatewayDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            String url_conn = "DB_URL";
            String user = "DB_USER";
            String password = "DB_PASSWORD";
            conn = DriverManager.getConnection(url_conn, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public String executeStatement(String sql) {
        try {
            sql = sql.trim().toLowerCase();
            StringBuilder table = new StringBuilder();
            conn = getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            table.append("<table>");
            table.append("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                table.append("<th>");
                table.append(metaData.getColumnName(i));
                table.append("</th>");
            }
            table.append("</tr>");

            while (rs.next()) {
                table.append("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    table.append("<td>");
                    table.append(rs.getString(i));
                    table.append("</td>");
                }
                table.append("</tr>");
            }
            table.append("</table>");
            return table.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
