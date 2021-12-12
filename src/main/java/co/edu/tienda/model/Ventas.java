package co.edu.tienda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Ventas")
public class Ventas {
	
	@Id
	private int Cedula_Cliente;
	private String Codigo_Venta;
	private String Detalle_Venta;
	private double Iva_Venta;
	private double Total_Venta;
	private double Valor_Venta;
	
	
	
	
public Ventas() {
	
}
	
public Ventas(int cedula_Cliente, String codigo_Venta, String detalle_Venta, double iva_Venta,
			double total_Venta, double valor_Venta) {
		super();
		Cedula_Cliente = cedula_Cliente;
		Codigo_Venta = codigo_Venta;
		Detalle_Venta = detalle_Venta;
		Iva_Venta = iva_Venta;
		Total_Venta = total_Venta;
		Valor_Venta = valor_Venta;
		
		
		
		
}
	public int getCedula_Cliente() {
	return Cedula_Cliente;
}
	

public void setCedula_Cliente(int cedula_Cliente) {
	Cedula_Cliente = cedula_Cliente;
}

public String getCodigo_Venta() {
	return Codigo_Venta;
}

public void setCodigo_Venta(String codigo_Venta) {
	Codigo_Venta = codigo_Venta;
}

public String getDetalle_Venta() {
	return Detalle_Venta;
}

public void setDetalle_Venta(String detalle_Venta) {
	Detalle_Venta = detalle_Venta;
}

public double getIva_Venta() {
	return Iva_Venta;
}

public void setIva_Venta(double iva_Venta) {
	Iva_Venta = iva_Venta;
}

public double getTotal_Venta() {
	return Total_Venta;
}

public void setTotal_Venta(double total_Venta) {
	Total_Venta = total_Venta;
}

public double getValor_Venta() {
	return Valor_Venta;
}

public void setValor_Venta(double valor_Venta) {
	Valor_Venta = valor_Venta;
}

	@Override
	public String toString() {
		return "Ventas [Cedula_Cliente=" + Cedula_Cliente + ", Codigo_Venta=" + Codigo_Venta + ", Detalle_Venta="
				+ Detalle_Venta + ", Iva_Venta=" + Iva_Venta + ", Total_Venta=" + Total_Venta + ", Valor_Venta="
				+ Valor_Venta + "]";
	}
	
	
	
	

}
