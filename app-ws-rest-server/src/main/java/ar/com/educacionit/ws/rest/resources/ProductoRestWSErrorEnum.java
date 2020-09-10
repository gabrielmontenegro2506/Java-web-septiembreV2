package ar.com.educacionit.ws.rest.resources;

public enum ProductoRestWSErrorEnum {

	PRECIO_REQUERIDO(1),
	TIPO_PRODUCTO_REQUERIDO(2), 
	PRODUCTO_INEXISTENTE(3)
	;
	
	private Integer codigo;
	
	private ProductoRestWSErrorEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
}
