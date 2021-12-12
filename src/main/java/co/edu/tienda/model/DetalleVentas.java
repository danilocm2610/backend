package co.edu.tienda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection= "DetalleVentas")
	public class DetalleVentas {
	
		@Id
		private int Cantidad_Producto;
		private int Codigo_Producto;
		private String Detalle_Venta;
		private double Valor_Total;
		private double Valor_Venta;
		private double Valor_Iva;
		
		
		
		public DetalleVentas() {
			
		}
		
		
		
		public DetalleVentas(int cantidad_Producto, int codigo_Producto, String detalle_Venta, double valor_Total,
				double valor_Venta, double valor_Iva) {
			super();
			Cantidad_Producto = cantidad_Producto;
			Codigo_Producto = codigo_Producto;
			Detalle_Venta = detalle_Venta;
			Valor_Total = valor_Total;
			Valor_Venta = valor_Venta;
			Valor_Iva = valor_Iva;
			
			
			
		}
		
		public int getCantidad_Producto() {
			return Cantidad_Producto;
		}



		public void setCantidad_Producto(int cantidad_Producto) {
			Cantidad_Producto = cantidad_Producto;
		}



		public int getCodigo_Producto() {
			return Codigo_Producto;
		}



		public void setCodigo_Producto(int codigo_Producto) {
			Codigo_Producto = codigo_Producto;
		}



		public String getDetalle_Venta() {
			return Detalle_Venta;
		}



		public void setDetalle_Venta(String detalle_Venta) {
			Detalle_Venta = detalle_Venta;
		}



		public double getValor_Total() {
			return Valor_Total;
		}



		public void setValor_Total(double valor_Total) {
			Valor_Total = valor_Total;
		}



		public double getValor_Venta() {
			return Valor_Venta;
		}



		public void setValor_Venta(double valor_Venta) {
			Valor_Venta = valor_Venta;
		}



		public double getValor_Iva() {
			return Valor_Iva;
		}



		public void setValor_Iva(double valor_Iva) {
			Valor_Iva = valor_Iva;
		}



		@Override
		public String toString() {
			return "DetalleVentas [Cantidad_Producto=" + Cantidad_Producto + ", Codigo_Producto=" + Codigo_Producto
					+ ", Detalle_Venta=" + Detalle_Venta + ", Valor_Total=" + Valor_Total + ", Valor_Venta="
					+ Valor_Venta + ", Valor_Iva=" + Valor_Iva + "]";
		}
		
		
		
}
