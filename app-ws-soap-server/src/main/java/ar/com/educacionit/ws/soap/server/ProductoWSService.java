package ar.com.educacionit.ws.soap.server;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.com.educacionit.app.domain.Producto;
import ar.com.educacionit.ws.soap.service.impl.CreateProductoDto;

@WebService
public interface ProductoWSService {

	@WebMethod
	public List<Producto> findProductos();

	@WebMethod
	public Producto createProducto(CreateProductoDto productoRequest) throws WSSoapExeption;
}
