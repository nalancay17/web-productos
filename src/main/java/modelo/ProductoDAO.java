package modelo;

import java.util.List;

public interface ProductoDAO {

	public void registrar(Producto p) throws Exception;

	public List<Producto> listar() throws Exception;

	public Producto obtenerProducto(String codigo) throws Exception;

	public void modificar(Producto p) throws Exception;

	public void eliminar(String codigo) throws Exception;

}
