package modelo;

import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoDAOImpl implements ProductoDAO {

	private PoolConexiones pool;
	private static final String INSERT = "INSERT INTO producto (codigo, nombre, precio, fecha, pais_origen) VALUES (?,?,?,?,?";
	private static final String SELECT = "SELECT * FROM producto";

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
				Producto p = new Producto();
				p.setCodigo(rs.getString("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setFecha(rs.getDate("fecha"));
				p.setPaisOrigen(rs.getString("pais_origen"));

				productos.add(p);
			}
			st.close();
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		return productos;
	}

}
