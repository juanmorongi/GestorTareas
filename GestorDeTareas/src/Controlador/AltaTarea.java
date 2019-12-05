package Controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Tarea;

/**
 * Servlet implementation class AltaTarea
 */
@WebServlet("/AltaTarea")
public class AltaTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String descripcion = request.getParameter("desc");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		int importancia = Integer.parseInt(request.getParameter("prioridad"));
		int estado = 0;
		String fini = request.getParameter("ini");
		String fin = request.getParameter("fin");

		if(!id.equals("0")){
			Tarea t = new Tarea(Integer.parseInt(id),pid,nombre,descripcion,categoria,estado,fini,fin,importancia);
			t.actualizar();
		}else{
			Tarea t = new Tarea(pid,nombre,descripcion,categoria,estado,fini,fin,importancia);
			t.insertar();
		}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
