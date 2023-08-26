package modelo;

import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoDAOImpl implements ProductoDAO {

	private PoolConexiones pool;
	private static final String INSERT = "INSERT INTO producto (codigo, nombre, precio, fecha, pais_origen) VALUES (?,?,?,?,?)";
	private static final String SELECT = "SELECT * FROM producto";
	private static final String SELECT_PRODUCTO = "SELECT * FROM producto WHERE codigo=?";
	private static final String UPDATE = "UPDATE producto SET nombre=?, precio=?, fecha=?, pais_origen=? WHERE codigo=?";
	private static final String DELETE = "DELETE FROM producto WHERE codigo=?";

	public ProductoDAOImpl(PoolConexiones pool) {
		this.pool = pool;
	}

	@Override
	public void registrar(Producto p) throws Exception {
		try {
			PreparedStatement st = pool.getConexion().prepareStatement(INSERT);
			st.setString(1, p.getCodigo());
			st.setString(2, p.getNombre());
			st.setDouble(3, p.getPrecio());
			st.setDate(4, (Date) p.getFecha());
			st.setString(5, p.getPaisOrigen());

			st.executeUpdate();
			st.getConnection().close();
			st.close();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Producto> listar() throws Exception {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		try {
			Statement st = pool.getConexion().createStatement();
			ResultSet rs = st.executeQuery(SELECT);

			while (rs.next()) {
				Producto p = obtenerProductoDelResultSet(rs);
				productos.add(p);
			}
			st.getConnection().close();
			st.close();
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return productos;
	}

	@Override
	public Producto obtenerProducto(String codigo) throws Exception {
		try {
			PreparedStatement st = pool.getConexion().prepareStatement(SELECT_PRODUCTO);
			st.setString(1, codigo);

			ResultSet rs = st.executeQuery();
			rs.next();
			Producto p = obtenerProductoDelResultSet(rs);

			st.getConnection().close();
			st.close();
			rs.close();
			return p;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void modificar(Producto p) throws Exception {
		try {
			PreparedStatement st = pool.getConexion().prepareStatement(UPDATE);
			st.setString(1, p.getNombre());
			st.setDouble(2, p.getPrecio());
			st.setDate(3, (Date) p.getFecha());
			st.setString(4, p.getPaisOrigen());
			st.setString(5, p.getCodigo());

			st.executeUpdate();
			st.getConnection().close();
			st.close();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void eliminar(String codigo) throws Exception {
		try {
			PreparedStatement st = pool.getConexion().prepareStatement(DELETE);
			st.setString(1, codigo);
			st.executeUpdate();
			st.getConnection().close();
			st.close();
		} catch (Exception e) {
			throw e;
		}
	}

	private Producto obtenerProductoDelResultSet(ResultSet rs) throws SQLException {
		Producto p = new Producto();
		p.setCodigo(rs.getString("codigo"));
		p.setNombre(rs.getString("nombre"));
		p.setPrecio(rs.getDouble("precio"));
		p.setFecha(rs.getDate("fecha"));
		p.setPaisOrigen(rs.getString("pais_origen"));
		return p;
	}

}
