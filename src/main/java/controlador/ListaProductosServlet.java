package controlador;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ListaProductosServlet
 */
@WebServlet("/ListaProductosServlet")
public class ListaProductosServlet extends HttpServlet {

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
			request.setAttribute("productos", productoDao.listar());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
