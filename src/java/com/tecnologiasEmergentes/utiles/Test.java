
package com.tecnologiasEmergentes.utiles;

public class Test {
    //verificamos si se conecta a la base se de datos
    //creamos el main (principal) ejecutara el codigo
    public static void main (String[] args){
        //inicializamos una variable 
    ConeccionBaseDeDatos conexion = new ConeccionBaseDeDatos();
    
    //importamos el metodo conectar
    conexion.conectar();
    }
    // importante adicionar la libreria mySQL JDBC Driver 
}
