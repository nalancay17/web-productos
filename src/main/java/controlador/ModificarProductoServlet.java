package controlador;

import java.io.IOException;
import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import modelo.PoolConexiones;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.ProductoDAOImpl;

/**
 * Servlet implementation class ModificarProductoServlet
 */
@WebServlet("/ModificarProductoServlet")
public class ModificarProductoServlet extends HttpServlet {

	@Resource(name = "jdbc/pool-producto")
	private DataSource poolDataSource;

	private ProductoDAO productoDao;
	private PoolConexiones pool;
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			pool = PoolConexiones.getInstancia();
			pool.setPool(poolDataSource);
			productoDao = new ProductoDAOImpl(pool);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String codigo = (String) request.getParameter("codigo");
			Producto p = productoDao.obtenerProducto(codigo);
			request.setAttribute("producto", p);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificarProducto.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			Producto p = obtenerProducto(request);
			productoDao.modificar(p);
			response.sendRedirect(request.getContextPath() + "/ListaProductosServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Producto obtenerProducto(HttpServletRequest request) {
		Producto p = new Producto();
		p.setCodigo(request.getParameter("codigo"));
		p.setNombre(request.getParameter("nombre"));
		p.setPrecio(Double.parseDouble(request.getParameter("precio")));
		p.setFecha(Date.valueOf(request.getParameter("fecha")));
		p.setPaisOrigen(request.getParameter("pais_origen"));
		return p;
	}

}
