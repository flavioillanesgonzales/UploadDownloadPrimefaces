package dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {
        try {
            String driver = "oracle.jdbc.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521/XE";
            String user = "demo";
            String pwd = "@abc123@";

            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Error de conexion: "+e);
        }
        return cnx;
    }

    public static void main(String[] args) throws Exception {
        try {
            Conexion.conectar();
            if (Conexion.cnx != null) {
                System.out.println("Estoy Conectado");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void cerrar() throws Exception {
        if (cnx != null) {
            cnx.close();
            System.out.println("Cerrado");
        }
    }

}
