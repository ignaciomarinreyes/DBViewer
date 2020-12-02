package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import model.Table;

public class DBLoader {

    private Connection con;

    public DatabaseMetaData connect(String user, char[] pass) {
        DatabaseMetaData md = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://mozart.dis.ulpgc.es/DIU_BD?useSSL=true",
                    user,
                    String.valueOf(pass));
            md = con.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(DBLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return md;
    }

    public ArrayList<Table> read(DatabaseMetaData md) {
        ArrayList<Table> tables = new ArrayList<>();
        try {
            String[] types = {"TABLE"};
            ResultSet rs = md.getTables(null, null, "%", types);
            while (rs.next()) {
                String nombreTabla = rs.getString("TABLE_NAME");
                Table table = new Table(nombreTabla);
                ResultSet rs2 = md.getColumns(null, null, nombreTabla, null);
                while (rs2.next()) {
                    String nombreCampo = rs2.getString("COLUMN_NAME");
                    table.addField(nombreCampo);
                }
                tables.add(table);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tables;
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
