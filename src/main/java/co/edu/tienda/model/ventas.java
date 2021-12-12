package co.edu.tienda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Ventas")
public class ventas {
	@Id
	private String id;
	private String cedula;
	
	private String codigo;
	private String detalle;
	private double iva;
	private double total;
	private double valor;
	public ventas() {
		
	}
	public ventas(String cedula, String codigo, String detalle, double iva, double total, double valor) {
		super();
		this.cedula = cedula;
		this.codigo = codigo;
		this.detalle = detalle;
		this.iva = iva;
		this.total = total;
		this.valor = valor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "ventas [id=" + id + ", cedula=" + cedula + ", codigo=" + codigo + ", detalle=" + detalle + ", iva="
				+ iva + ", total=" + total + ", valor=" + valor + "]";
	}
	
}