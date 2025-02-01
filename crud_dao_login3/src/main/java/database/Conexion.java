package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
https://www.youtube.com/watch?v=_rVws_gK4es
https://www.youtube.com/watch?v=DMcVhreS4v8
https://mvnrepository.com/
 */
public class Conexion {

    //Es el objeto que representa la conexión a la base de datos
    private static Connection conexion;
    //creamos una variable para crear una sola instancia
    private static Conexion instancia;

    //creamos las variables
    private static final String URL = "jdbc:mysql://localhost/academiavega";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public Conexion() {
    }

    //creamos el metodo para conectarnos a la base de datos
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al cerrar la conexion" + ex);
        }
        return conexion;
    }

    /**
     * Un Singleton es un patrón de diseño que garantiza que una clase tenga una
     * única instancia y proporciona un punto global de acceso a esa instancia.
     * En este caso, la clase Conexion implementa el patrón Singleton para
     * asegurarse de que solo exista una conexión activa a la base de datos.
     *
     * @return
     */
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

}
