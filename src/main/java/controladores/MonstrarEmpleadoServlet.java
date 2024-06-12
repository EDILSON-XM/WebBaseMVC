package controladores;

import java.io.IOException;
import java.util.ArrayList;

import dao.EmpleadoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Empleado;

/**
 * Servlet implementation class MonstrarEmpleadoServlet
 */
public class MonstrarEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonstrarEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		
		ArrayList<Empleado> lista = empleadoDAO.getListaEmpleados();
	
		// Enviando la lista de empleados a la página
		request.setAttribute("listaEmpleados", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
