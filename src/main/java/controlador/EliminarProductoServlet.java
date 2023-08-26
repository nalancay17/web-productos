package controlador;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import modelo.PoolConexiones;
import modelo.ProductoDAO;
import modelo.ProductoDAOImpl;

/**
 * Servlet implementation class EliminarProductoServlet
 */
@WebServlet("/EliminarProductoServlet")
public class EliminarProductoServlet extends HttpServlet {

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String codigo = request.getParameter("codigo");
			productoDao.eliminar(codigo);
			response.sendRedirect(request.getContextPath() + "/ListaProductosServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
