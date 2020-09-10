package ar.com.educacionit.ws.rest.client.client;

import javax.ws.rs.core.Response;

import ar.com.educacionit.app.domain.Producto;

public class ProductoRestExecutor extends RestRequestExecutor<Producto> {

	public ProductoRestExecutor(String urlRestApi) {
		super(urlRestApi);
	}

	@Override
	protected Producto buildResponseDto(Response response) {
		return response.readEntity(Producto.class);
	}

}
