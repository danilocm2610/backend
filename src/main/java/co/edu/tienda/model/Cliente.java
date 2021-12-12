package co.edu.tienda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "db_clientes")

public class Cliente {
	@Id
	private String Cedula;
	
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Cliente(String cedula, String nombre, String direccion, String telefono, String correo) {
		super();
		Cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Cliente [Cedula=" + Cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", correo=" + correo + "]";
	}
	public Cliente() {
		
	}
	
}
