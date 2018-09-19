/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LabingXEON
 */
import java.sql.*;
import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ejemplo {

    private Connection con;

    public Connection getConnection(String usr, String pass) {
        String url = "jdbc:mysql://localhost/test";
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, usr, pass);
            return con;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ejemplo bd = new ejemplo();
        Connection connection = bd.getConnection("root", "");
        if (connection != null) {
            System.out.println("conexion exitosa");
            try {
                Statement statement = connection.createStatement();
                /*
                String consulta = "insert into Depto(nom_depto) values('B')";
                int resultado = statement.executeUpdate(consulta);
                if (resultado == 1) {
                    System.out.println("Se inserto correctamente");
                }else{
                    System.out.println("Problema en insersion");
                }
                 */
 /*
                String consulta1 = "delete from Depto";
                int resultado1 = statement.executeUpdate(consulta1);
                if (resultado1 > 0) {
                    System.out.println("Se borro correctamente");
                }else{
                    System.out.println("Problema en borrar");
                }*/
 /*
                String consult = "select * from Depto";
                ResultSet rs = statement.executeQuery(consult);
                while (rs.next()) {                    
                    System.out.println(rs.getInt("id_depto"));
                    System.out.println(rs.getString("nom_depto"));
                }
                 */
 /*
                String consulta = "insert into Empleado(nombre,apellido, id_depto) values('Ana', 'Frank',11)";
                int resultado = statement.executeUpdate(consulta);
                if (resultado == 1) {
                    System.out.println("Se inserto correctamente");
                }else{
                    System.out.println("Problema en insersion");
                }
                 */
                String consulta = "select Empleado.nombre, Depto.nom_depto From Depto, Empleado where Depto.id_depto = Empleado.id_depto";
                ResultSet rs = statement.executeQuery(consulta);
                while (rs.next()) {
                    System.out.println(rs.getString("nombre"));
                    System.out.println(rs.getString("nom_depto"));
                }
            } catch (SQLException ex) {
                System.out.println("error en la insersion");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Problema en conexion");
        }
    }
}
