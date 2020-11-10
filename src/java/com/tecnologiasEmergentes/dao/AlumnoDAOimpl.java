package com.tecnologiasEmergentes.dao;
//clase importada

import com.tecnologiasEmergentes.modelo.Alumno;
//clase importada
import com.tecnologiasEmergentes.utiles.ConeccionBaseDeDatos;
//libreria importada
import java.sql.PreparedStatement;
//libreria importada
import java.sql.ResultSet;
//libreria importada
import java.util.ArrayList;
//element importado
import java.util.List;

//esta es una clase normal impletamos la interface y importamos conexion de la base de datos
public class AlumnoDAOimpl extends ConeccionBaseDeDatos implements AlumnoDAO {

    @Override
    public void insertar(Alumno alumno) throws Exception {
//insertamos un dato
        try {
            //llamamos al metodo conectar
            this.conectar();
            //preparamos una cadena sql hacemos la consulta
            String sql = "INSERT into estudiantes (nombre,apellidoPaterno,apellidoMaterno,correo) value (?,?,?,?) ";
            //utilizamos la libreia y isertamos 
            //la conexioin debe ser publica
            //importamos la libreria import java.sql.PreparedStatement;
            PreparedStatement variable = this.conn.prepareStatement(sql);
            //pasamos los parametros (posicion  valor)
            variable.setString(1, alumno.getNombre());
            variable.setString(2, alumno.getApellidoPaterno());
            variable.setString(3, alumno.getApellidoPaterno());
            variable.setString(4, alumno.getCorreo());
            //ejecutamos la consulta y permita cambios 
            variable.executeUpdate();
        } catch (Exception e) {
            //lanzamos una excepcion
            throw e;
        } //adicionaremos finally en caso de que finalize
        finally {
            //simplimente nos desconectamos
            this.desconectar();
        }
    }

    @Override
    public void actualizar(Alumno alumno) throws Exception {
//insertamos un dato
        try {
            //llamamos al metodo conectar
            this.conectar();
            //preparamos una cadena sql hacemos la consulta
            String sql = "UPDATE estudiantes set nombre=?,apellidoPaterno=?,apellidoMaterno=?,correo=?  where id=? ";
            //utilizamos la libreia y isertamos 
            //la conexioin debe ser publica
            //importamos la libreria import java.sql.PreparedStatement;
            PreparedStatement variable = this.conn.prepareStatement(sql);
            //pasamos los parametros (posicion  valor)
            variable.setString(1, alumno.getNombre());
            variable.setString(2, alumno.getApellidoPaterno());
            variable.setString(3, alumno.getApellidoMaterno());
            variable.setString(4, alumno.getCorreo());
            variable.setInt(5, alumno.getId());
            //ejecutamos la consulta y permita cambios 
            variable.executeUpdate();
        } catch (Exception e) {
            //lanzamos una excepcion
            throw e;
        } //adicionaremos finally en caso de que finalize
        finally {
            //simplimente nos desconectamos
            this.desconectar();
        }
    }

    @Override
    public void borrar(int id) throws Exception {
//insertamos un dato
        try {
            //llamamos al metodo conectar
            this.conectar();
            //preparamos una cadena sql hacemos la consulta
            String sql = "delete from estudiantes where id = ?";
            //utilizamos la libreia y isertamos 
            //la conexioin debe ser publica
            //importamos la libreria import java.sql.PreparedStatement;
            PreparedStatement variable = this.conn.prepareStatement(sql);
            //pasamos los parametros (posicion  valor)
            variable.setInt(1, id);
            //ejecutamos la consulta y permita cambios actualizamos
            variable.executeUpdate();
            
        } catch (Exception e) {
            //lanzamos una excepcion
            throw e;
        } //adicionaremos finally en caso de que finalize
        finally {
            //simplimente nos desconectamos
            this.desconectar();
        }
    }
//metodo proporcionamos un id nos devuelve un registro completo del id

    @Override
    public Alumno BuscaElementoPorId(int id) throws Exception {
        //creamos un objeto 
        Alumno ob = new Alumno();
        //creamos un trycatch 
        try {
            //llamamos al metodo conectar
            this.conectar();
            //preparamos una cadena sql hacemos la consulta
            String sql = "select * from estudiantes where id = ? ";
            //utilizamos la libreia y insertamos 
            //la conexioin debe ser publica
            //importamos la libreria import java.sql.PreparedStatement;
            PreparedStatement variable = this.conn.prepareStatement(sql);
            //pasamos los parametros (posicion  valor)
            variable.setInt(1, id);
            //ejecutamos la consulta y importamos resulset
            //importamos import java.sql.ResultSet;
            ResultSet resSul = variable.executeQuery();

            //verificamos que tenga registros en este caso resSul.next() verificara que por lo menos hay un registro
            if (resSul.next()) {
                //con la consulta sacamos un registro y lo ponemos en resSul este asu vez en el objeto ob
                ob.setId(resSul.getInt("id"));
                ob.setNombre(resSul.getString("nombre"));
                ob.setApellidoPaterno(resSul.getString("apellidoPaterno"));
                ob.setApellidoMaterno(resSul.getString("apellidoMaterno"));
                ob.setCorreo(resSul.getString("correo"));
            }

        } catch (Exception e) {
            //lanzamos una excepcion
            throw e;
        } //adicionaremos finally en caso de que finalize
        finally {
            //simplimente nos desconectamos
            this.desconectar();
        }
        return ob;
    }

    @Override
    public List<Alumno> TodosLosRegistros() throws Exception {
        //creamos una variable que empieza en null
        List<Alumno> lista = null;

        try {
            //llamamos al metodo conectar a la base de datos
            this.conectar();

            //preparamos una cadena sql hacemos la consulta
            String sql = "select * from estudiantes ";

            //importamos la libreria import java.sql.PreparedStatement;
            PreparedStatement variable = this.conn.prepareStatement(sql);

            //ejecutamos la consulta y importamos resulset
            ResultSet resSul = variable.executeQuery();

            //mostrar un conjunto de registros
            //importamos la libreria import java.util.ArrayList;
            lista = new ArrayList<Alumno>();
            //bucle que nos permita trabajar con el resultado
            //si aun tiene registros
            while (resSul.next()) {
                //creamos un objeto 
                Alumno ob = new Alumno();
                //obtener un registro
                //con la consulta sacamos un registro y lo ponemos en resSul este asu vez en el objeto ob
                ob.setId(resSul.getInt("id"));
                ob.setNombre(resSul.getString("nombre"));
                ob.setApellidoPaterno(resSul.getString("apellidoPaterno"));
                ob.setApellidoMaterno(resSul.getString("apellidoMaterno"));
                ob.setCorreo(resSul.getString("correo"));
                //adicionamos a la colecion o grupo de registros
                lista.add(ob);
            }

        } catch (Exception e) {
            //lanzamos una excepcion
            throw e;
        } //adicionaremos finally en caso de que finalize
        finally {
            //simplimente nos desconectamos
            this.desconectar();
        }
        return lista;
    }

}
