package modelo;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class PoolConexiones {

	private static PoolConexiones instancia;

	@Resource(name="jdbc/crud_productos")
	private DataSource poolConexiones;

	private PoolConexiones() {

	}

	public static synchronized PoolConexiones getInstancia() {
		if (instancia == null)
			instancia = new PoolConexiones();
		return instancia;
	}

	public Connection getConexion() throws Exception {
		try {
			return poolConexiones.getConnection();
		} catch(Exception e) {
			throw e;
		}
	}
}
