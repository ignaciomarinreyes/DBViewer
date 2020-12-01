package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class RestDBLoader {

    public RestDBLoader() {

    }

    public ArrayList<String> read(String user, char[] pass) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://mozart.dis.ulpgc.es/DIU_BD?useSSL=true",
                user,
                String.valueOf(pass));
        /*
                "jdbc:mysql://mozart.dis.ulpgc.es/DIU_BD?useSSL=true",
                "estudiante-DIU",
                "DIU-aed56-noi");
         */
        DatabaseMetaData md = con.getMetaData();
        String[] types = {"TABLE"};
        ArrayList<String> tables = new ArrayList<>(); // basura
        ResultSet rs = md.getTables(null, null, "%", types);
        while (rs.next()) {
            String nombreTabla = rs.getString("TABLE_NAME");
            System.out.println("Tabla: " + nombreTabla);
            tables.add(nombreTabla); // basura
            ResultSet rs2 = md.getColumns(null, null, nombreTabla, null);
            while (rs2.next()) {
                String nombreCampo = rs2.getString("COLUMN_NAME");
                System.out.println(" Campo: " + nombreCampo);
            }
        }
        con.close();
        return tables; // basura
    }
}
