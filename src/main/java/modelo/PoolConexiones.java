package modelo;

import java.sql.Connection;

import javax.sql.DataSource;

public class PoolConexiones {

	private static PoolConexiones instancia;
	private DataSource pool;

	private PoolConexiones() {

	}

	public static synchronized PoolConexiones getInstancia() {
		if (instancia == null)
			instancia = new PoolConexiones();
		return instancia;
	}

	public Connection getConexion() throws Exception {
		try {
			return pool.getConnection();
		} catch (Exception e) {
			throw e;
		}
	}

	public void setPool(DataSource pool) {
		this.pool = pool;
	}

}
