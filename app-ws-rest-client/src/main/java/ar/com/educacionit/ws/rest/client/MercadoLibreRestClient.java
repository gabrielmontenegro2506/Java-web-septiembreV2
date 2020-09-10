package ar.com.educacionit.ws.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import ar.com.eduacionit.app.ws.meli.client.dto.cetegory.Categoria;

public class MercadoLibreRestClient {

	public static void main(String[] args) {
		
	
		//client
    	Client client = ClientBuilder.newClient(
    			new ClientConfig().register(LoggingFeature.class)
    			);
    	
    	//web target
    	WebTarget webTarget = client.target("https://api.mercadolibre.com/categories/MLA1071");
    	
    	//invocation
    	Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    	
    	//response
    	Response response = invocationBuilder.get();
    	
    	//analizar el resultado, estatus code
    	if(Status.OK.getStatusCode() == response.getStatus()) {
    		
    		//obtengo la lista de productos
    		Categoria categoria = response.readEntity(Categoria.class);
    		
    		System.out.println(categoria);
    		
    	}else {
    		System.err.println(response.getStatus());
    	}
	}
	
}
