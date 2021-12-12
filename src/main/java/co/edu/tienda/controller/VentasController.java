package co.edu.tienda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.tienda.model.Ventas;
import co.edu.tienda.repository.VentasRepository;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/ventas")

public class VentasController {

	@Autowired
	VentasRepository ventasRepo;

	@PostMapping("/ventas")
	  public ResponseEntity<Ventas> createVentas(@RequestBody Ventas ventas) {
		  try {
			    Ventas _venta = ventasRepo.save(new Ventas(ventas.getCedula_Cliente(), ventas.getCodigo_Venta(), ventas.getDetalle_Venta(), ventas.getIva_Venta(),ventas.getTotal_Venta(), ventas.getValor_Venta()));
			    return new ResponseEntity<>(_venta, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	}
	
	@GetMapping("/getall")
	  public ResponseEntity<List<Ventas>> getAllVentas(@RequestParam(required = false) String codigo_Venta) {
		  try {
			    List<Ventas> Ventas = new ArrayList<>();

			    if (codigo_Venta == null)
			      ventasRepo.findAll().forEach(Ventas::add);
			    else
			      ventasRepo.findByCedula(codigo_Venta).forEach(Ventas::add);

			    if (Ventas.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(Ventas, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  } finally {
			}
	 }
	
	
	@GetMapping("/getby/{codigo_Venta}")
	  public ResponseEntity<Ventas> getVentasByCodigo(@PathVariable("Codigo_Venta") String Codigo_Venta) {
		  Optional<Ventas> ventasData = ventasRepo.findById(Codigo_Venta);

		  if (ventasData.isPresent()) {
		    return new ResponseEntity<>(ventasData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	
	@PutMapping("/update/{cedula_Cliente}")
	  public ResponseEntity<Ventas> updateVentas(@PathVariable("cedula_Cliente") int cedula_Cliente, String codigo_Venta, String detalle_Venta, double iva_Venta,
				double total_Venta, double valor_Venta) {
		  Optional<Ventas> ventaData = ventasRepo.findById(codigo_Venta);

		  if (ventaData.isPresent()) {
		    Ventas _venta = ventaData.get();
		    _venta.setCedula_Cliente(_venta.getCedula_Cliente());
		    _venta.setCodigo_Venta(_venta.getCodigo_Venta());
		    _venta.setDetalle_Venta(_venta.getDetalle_Venta());
		    _venta.setIva_Venta(_venta.getIva_Venta());
		    _venta.setTotal_Venta(_venta.getTotal_Venta());
		    _venta.setValor_Venta(_venta.getValor_Venta());
		    return new ResponseEntity<>(ventasRepo.save(_venta), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }

	  }

	  @DeleteMapping("/delete/{cedula_Cliente}")
	  public ResponseEntity<HttpStatus> deleteProveedor(@PathVariable("cedula_Cliente") String cedula_Cliente) {
		  try {
			    ventasRepo.deleteById(cedula_Cliente);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	
	  @DeleteMapping("/deleteall")
	  public ResponseEntity<HttpStatus> deleteAllVentas() {
		  try {
			    ventasRepo.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
}
}