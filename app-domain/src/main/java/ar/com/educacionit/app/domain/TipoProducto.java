package ar.com.educacionit.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_producto")
public class TipoProducto {

	@Id
	private Long id;
	
	@Column(name = "descripcion")
	private String descripcion;

	//alt+shift+s
	public TipoProducto() {
		super();
	}

	public TipoProducto(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoProducto [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
}
