package com.tecnologiasEmergentes.controlador;

import com.tecnologiasEmergentes.dao.AlumnoDAO;
import com.tecnologiasEmergentes.dao.AlumnoDAOimpl;
import com.tecnologiasEmergentes.modelo.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Iniciar", urlPatterns = {"/Iniciar"})
public class Iniciar extends HttpServlet {

    //peticiones desde url
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//para hacer las operaciones necesitaremos del un objeto dao que permitira insertar,editar,eliminar
            //para gestionar en DAO
            //importamos librerias
            AlumnoDAO dao = new AlumnoDAOimpl();
            //dao nos dara el id para trabajar por lo cual creamos una variable local para guardarla
            //averiguar la peticion
            int id;
            //para gestionar registros creamos un objeto nos permite manipularlos datos 
            Alumno a = new Alumno();

            //trabajaremos con una variable determinamos que valor tiene
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            //trabajaremos con un swich
            switch (action) {

                //en caso que sea nuevo
                case "adicionar":
                    //usamos nuestro objeto
                    request.setAttribute("alumno", a);
                    //trasferimos control
                    request.getRequestDispatcher("formularioAlumno.jsp").forward(request, response);
                    response.sendRedirect("Iniciar");
                    break;

                //en caso que se tenga que editar
                case "aditar":
                    //averiguamos el id que nos envian
                    id = Integer.parseInt(request.getParameter("id"));
                    //sacamos en el objeto lo que tenemos almacenado en id
                    a = dao.BuscaElementoPorId(id);
                    //ponemos como atributo
                    request.setAttribute("alumno", a);
                    //trasferimos control
                    request.getRequestDispatcher("formularioAlumno.jsp").forward(request, response);
                    break;

                //en caso que se tenga que borrar
                case "borrar":
                    //averiguamos el id que nos envian
                    id = Integer.parseInt(request.getParameter("id"));
                    //llamare a el metodo borrar
                    dao.borrar(id);
                    //solo redirecionamos a la vista
                    response.sendRedirect("Iniciar");
                    break;

                //mostrar los registros
                default:
                    //preparamos para mostrar 
                    List<Alumno> lista = dao.TodosLosRegistros();
                    //enviamos a una vista muestre y procese (podemos llamar cualquier cosa  , lista )
                    request.setAttribute("alumnos", lista);
                    //mandamos a otro recurso transferimos el control
                    request.getRequestDispatcher("mostrar.jsp").forward(request, response);
                    break;

            }

        } catch (Exception e) {
            //mostramos un error 
            System.out.println("error" + e.getMessage());
        }
    }

    //peticiones desde formulario
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //importamos el objeto dao
        AlumnoDAO dao = new AlumnoDAOimpl();

        //recibimos los datos 
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String correo = request.getParameter("correo");

        //colocamos los datos en un objeto
        Alumno a = new Alumno();

        //colocamos valores
        a.setId(id);
        a.setNombre(nombre);
        a.setApellidoPaterno(correo);
        a.setApellidoPaterno(apellidoPaterno);
        a.setApellidoPaterno(apellidoMaterno);
        a.setCorreo(correo);

        //preguntar si es nuevo guardar objeto 
        if (id == 0) {
            //por nuevo insertamos en (a) los datos
            try {
                dao.insertar(a);
                //redirecionar 
                response.sendRedirect("Iniciar");
            } catch (Exception e) {
                System.out.println("error :" + e.getMessage());
            }

        } else {
            //para actualizar
            //por nuevo insertamos en (a) los datos
            
            try {
                dao.actualizar(a);
                //redirecionar 
                response.sendRedirect("Iniciar");
            } catch (Exception e) {
                System.out.println("error :" + e.getMessage());
            }
        }
    }
}
