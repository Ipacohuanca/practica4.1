
package com.tecnologiasEmergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConeccionBaseDeDatos {
    //creamos la conexion
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_calificaciones";
    static String usuario = "root";
    static String password = "";
    
    //variable inicializada en null
    //importar su libreria import java.sql.Connection;
   protected Connection conn = null;
    
    //creamos el metodo constructor
    public ConeccionBaseDeDatos ()
    {
        //usamos un try catch para las exepciones
        try {
            //le pasamos el driver
                Class.forName(driver);
                //inicializamos la conexion pasamos los parametros
                conn = DriverManager.getConnection(url, usuario, password);
                //verificamos si la conexion es valida
                if (conn != null) {
                    //en caso de verdad ejecuta el siguiente codigo
                    System.out.println("-----------conexion exitosa---------------");
            }
                //en otro caso atrapamos las exepciones (en caso de no tener el driver se usa el sgte codigo)
        } catch (ClassNotFoundException e) {
            //mostramos el sgte codigo y adjuntamos el mensaje (e.xxxxxxxxxx)
            System.out.println("!!!!!!!!!!!! error en el driver !!!!!!!!!!!!" + e.getMessage());
        }
        //para una exepcion tipo sql 
        //importamos su libreria import java.sql.SQLException;
        catch(SQLException e){
            //mostramos el sgte mensaje
            System.out.println("!!!! tienes un error tipo sql !!!!!!!!"+ e.getMessage() );
        }
    }
    // creamos un metodo para conectarse
    public Connection conectar()
    {
        //devolvemos el valolr de la conexion
        return conn;
    }
    //creamos un metodo para desconectar
    public void desconectar()
    {
        //encerramos en un try catch por que solo nos desconectara
        try {
                conn.close();
                
        } 
        //lo unico que podria fallar es SQL por eso tendremos una exepcion solo para ese tipo de error
        catch (SQLException e) {
            //mostramos el error de la exepcion 
            System.out.println("!!!!!!error al cerrar la base de datos !!!!!!!!" + e.getMessage()); 
        }
    }
}
