package ar.com.educacionit.ws.soap.main;

import javax.xml.ws.Endpoint;

import ar.com.educacionit.ws.soap.service.impl.ProductoWSServiceImpl;

public class ProductoWSSoapMain {

	public static void main(String[] args) {
		
		System.out.println("Publicando soap en el puerto 8080");
		
		Endpoint.publish("http://127.0.0.1:8080/", new ProductoWSServiceImpl());
		
		System.out.println("Se ha iniciado el ws en http://localhost:8080/?wsdl");
	}

}
