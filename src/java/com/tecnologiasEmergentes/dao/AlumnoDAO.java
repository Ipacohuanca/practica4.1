
package com.tecnologiasEmergentes.dao;

import com.tecnologiasEmergentes.modelo.Alumno;

import java.util.List;

//esto es una interface
public interface AlumnoDAO {
    //creamos los metodos que tendra esta interfaz (pasamos el objeto   llamamos) lanzara una exepcion en caso de error 
    public void insertar(Alumno alumno) throws Exception;
    public void actualizar(Alumno alumno) throws Exception;
    //importamos la libreria import com.tecnologiasEmergentes.modelo.Alumno;
    //le pasamos el valor de un id tambien tendra una exepcion en caso de error
    public void borrar(int id)throws Exception;
    //este metodo buscara un metodo mediante el id, en este caso devuelve un objeto de tipo Alumno, con exepcion tambien
    public Alumno BuscaElementoPorId(int id) throws Exception;
    //este metodo devuelve un grupo de datos(coleccion de alumnos en este caso),con exepcion tambien
    public List<Alumno> TodosLosRegistros() throws Exception;
    //importamos la libreria import java.util.List;
}
