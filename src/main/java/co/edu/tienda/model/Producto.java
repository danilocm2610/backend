package co.edu.tienda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producto")
public class Producto{
	
	 @Id
	  private String id;
	  private String nombre;
	  private float precio;
	  private float peso;
	  
	public Producto(String nombre, float precio, float peso) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.peso = peso;
	}

	public Producto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", peso=" + peso + "]";
	}
	
	
	
	  
}
