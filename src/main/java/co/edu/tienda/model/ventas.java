package co.edu.tienda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Ventas")
public class ventas {
	@Id
	private String Cedula;
	
	private String Codigo;
	private String Detalle;
	private double Iva;
	private double Total;
	private double Valor;
	public ventas(){
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	public double getIva() {
		return Iva;
	}
	public void setIva(double iva) {
		Iva = iva;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public ventas(String cedula, String codigo, String detalle, double iva, double total, double valor) {
		super();
		Cedula = cedula;
		Codigo = codigo;
		Detalle = detalle;
		Iva = iva;
		Total = total;
		Valor = valor;
	}
	@Override
	public String toString() {
		return "ventas [Cedula=" + Cedula + ", Codigo=" + Codigo + ", Detalle=" + Detalle + ", Iva=" + Iva + ", Total="
				+ Total + ", Valor=" + Valor + "]";
	}
	
	
}