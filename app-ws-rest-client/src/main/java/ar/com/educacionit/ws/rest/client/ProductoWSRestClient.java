package ar.com.educacionit.ws.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import ar.com.educacionit.app.domain.Producto;

public class ProductoWSRestClient 
{
    public static void main( String[] args )
    {
        
    	//client
    	Client client = ClientBuilder.newClient(
    			new ClientConfig().register(LoggingFeature.class)
    			);
    	
    	//web target
    	WebTarget webTarget = client.target("http://localhost:8080/app-ws-rest-server/api/producto");
    	
    	//invocation
    	Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    	
    	//response
    	Response response = invocationBuilder.get();
    	
    	//analizar el resultado, estatus code
    	if(Status.OK.getStatusCode() == response.getStatus()) {
    		
    		//obtengo la lista de productos
    		GenericType<List<Producto>> productosType = new GenericType<List<Producto>>() {};
    		
    		List<Producto> productos = response.readEntity(productosType);
    		
    		for(Producto producto : productos ) {
    			System.out.println(producto);
    		}
    		
    	}else {
    		System.err.println(response.getStatus());
    	}
    }
}
