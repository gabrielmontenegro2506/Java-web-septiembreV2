package ar.com.educacionit.ws.soap.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import ar.com.educacionit.app.domain.Producto;
import ar.com.educacionit.app.domain.TipoProducto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.ws.soap.server.ProductoWSService;
import ar.com.educacionit.ws.soap.server.WSSoapExeption;

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

	@Override
	public Producto createProducto(CreateProductoDto productoRequest) throws WSSoapExeption {
		
		//conversion de CreateProducrtoDTO a Produto
		
		TipoProducto tipo = new TipoProducto();
		tipo.setId(productoRequest.getIdTipoProducto());
		
		Producto nuevoProducto = new Producto(productoRequest.getTitulo(), 
				productoRequest.getPrecio(), 
				productoRequest.getCodigo(), tipo);
			
		Producto productoCreado;
		try {
			productoCreado = this.productoService.createProducto(nuevoProducto);
		} catch (ServiceException e) {
			System.err.println(e);
			//LOG4J
			//LOGBACK
			//SLF4 ETC ETC
			productoCreado = null;
			throw new WSSoapExeption(e);
		}
		
		return productoCreado;
	}

}
