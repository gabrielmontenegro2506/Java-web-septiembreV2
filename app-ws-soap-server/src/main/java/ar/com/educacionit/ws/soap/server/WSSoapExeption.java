package ar.com.educacionit.ws.soap.server;

import ar.com.educacionit.services.exceptions.ServiceException;

public class WSSoapExeption extends Exception {

	public WSSoapExeption(ServiceException e) {
		super(e);
	}

}
