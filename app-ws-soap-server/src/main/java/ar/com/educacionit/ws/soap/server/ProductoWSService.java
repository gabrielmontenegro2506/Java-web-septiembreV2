package ar.com.educacionit.ws.soap.server;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.com.educacionit.app.domain.Producto;

@WebService
public interface ProductoWSService {

	@WebMethod
	public List<Producto> findProductos();
}
