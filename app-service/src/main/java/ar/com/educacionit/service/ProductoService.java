package ar.com.educacionit.service;

import java.util.List;

import ar.com.educacionit.app.domain.Producto;
import ar.com.educacionit.app.domain.TipoProducto;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ProductoService {

	public Producto getProducto(String codigo) throws ServiceException;

	public List<Producto> findProductos() throws ServiceException;

	public Producto createProducto(Producto producto) throws ServiceException;
	
	public Producto updateProducto(Producto producto) throws ServiceException;

	public Producto eliminarProducto(String codigoProducto) throws ServiceException;
	
	public List<TipoProducto> findTipoProductos() throws ServiceException;

	public List<Producto> findProductosByDescripcion(String desripcion) throws ServiceException;

	
}
