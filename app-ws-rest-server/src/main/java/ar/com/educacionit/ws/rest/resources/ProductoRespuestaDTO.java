package ar.com.educacionit.ws.rest.resources;

public class ProductoRespuestaDTO {

	private String mensaje;
	
	private Integer codigoError;

	public ProductoRespuestaDTO(String mensaje, ProductoRestWSErrorEnum codigoErrorEnum) {
		super();
		this.mensaje = mensaje;
		this.codigoError = codigoErrorEnum.getCodigo();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}
}
