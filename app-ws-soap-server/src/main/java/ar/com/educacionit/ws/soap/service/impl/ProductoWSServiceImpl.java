package ar.com.educacionit.ws.soap.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import ar.com.educacionit.app.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.ws.soap.server.ProductoWSService;

@WebService(endpointInterface = "ar.com.educacionit.ws.soap.server.ProductoWSService")
public class ProductoWSServiceImpl implements ProductoWSService {

	private ProductoService productoService;
	
	public ProductoWSServiceImpl() {
		productoService = new ProductoServiceImpl();
	}
	
	@Override
	public List<Producto> findProductos() {
		
		List<Producto> productos;
		try {
			productos = this.productoService.findProductos();
		} catch (ServiceException e) {
			e.printStackTrace();
			productos = new ArrayList<Producto>();
		}
		
		return productos;
	}

}
