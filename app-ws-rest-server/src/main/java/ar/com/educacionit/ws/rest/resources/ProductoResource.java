package ar.com.educacionit.ws.rest.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ar.com.educacionit.app.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

@Path("producto")
public class ProductoResource {

	private ProductoService productoService;
	
	public ProductoResource() {
		this.productoService = new ProductoServiceImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProductos() {
		try {
			List<Producto> productos = this.productoService.findProductos();
			return Response.ok(productos).build();
		} catch (ServiceException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
