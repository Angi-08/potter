import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import proyecto.modelo.Nombres;

/**
 *
 * @author ANGI
 */
public class BaseDeDatos {
    private static Connection cnx = null;
    private static String b;
    //public static ArrayList<Nombres> listaNombres=new ArrayList<>();


    public static Connection obtener() throws SQLException, ClassNotFoundException {
       
        try {
            if (cnx == null) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    cnx = DriverManager.getConnection("jdbc:mysql://localhost/" + "bdpotter", "root", "");
                } catch (SQLException ex) {
                    throw new SQLException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new ClassCastException(ex.getMessage());
                }
            }
            return cnx;
        } catch (SQLException e) {
            System.out.println("No existe");
            return null;
        }

    }
    
    public static void guardarNombre(Connection conexion, Nombres tarea) throws SQLException {
        try {
            PreparedStatement consulta;
            if (conexion != null) {
                consulta = conexion.prepareStatement("INSERT INTO personaje (_id,name) VALUES(?,?)"); 
                consulta.setString(1, tarea.getId());
                consulta.setString(2, tarea.getName());
                //consulta.setString(3, tarea.getRole());
                //consulta.setString(4, tarea.getHouse());
                //consulta.setString(5, tarea.getSchool());
               // consulta.setString(6, tarea.getV());
               /* consulta.setString(7, tarea.getMinistryOfMagic());
                consulta.setString(8, tarea.getOrderOfThePhoenix());
                consulta.setString(9, tarea.getDumbledoresArmy());
                consulta.setString(10, tarea.getDeathEater());
                consulta.setString(11, tarea.getBloodStatus());
                consulta.setString(12, tarea.getSpecies());
                consulta.setString(13, tarea.getBoggart());
                consulta.setString(14, tarea.getWand());
                consulta.setString(15, tarea.getPatronus());
                consulta.setString(16, tarea.getAnimagus());
                consulta.setString(17, tarea.getAlias());*/
                /*
                consulta.setString(18, tarea.getImdbID());                
                consulta.setString(19, tarea.getType());
                consulta.setString(20, tarea.getdVD());
                consulta.setString(21, tarea.getBoxOffice());
                consulta.setString(22, tarea.getProduction());
                consulta.setString(23, tarea.getWebsite());
                consulta.setString(24, tarea.getResponse());*/
                consulta.executeUpdate();
            }  
    }catch(Exception e){
        
    }
    }
}
