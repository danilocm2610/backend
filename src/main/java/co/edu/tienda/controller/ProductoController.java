package co.edu.tienda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.tienda.model.Producto;
import co.edu.tienda.repository.ProductoRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductoController {
	@Autowired
	ProductoRepository producresp;
	
	@GetMapping("/productos")
	  public ResponseEntity<List<Producto>> getAllProductos(@RequestParam(required = false) String nombre) {
		  try {
			    List<Producto> Productoss = new ArrayList<Producto>();

			    if (nombre == null)
			    	producresp.findAll().forEach(Productoss::add);
			    else
			    	producresp.findByNombre(nombre).forEach(Productoss::add);

			    if (Productoss.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(Productoss, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	 @PostMapping("/productos")
	  public ResponseEntity<Producto> createProductos(@RequestBody Producto productoss) {
		  try {
			    Producto _producto = producresp.save(new Producto(productoss.getNombre(), productoss.getPrecio(), productoss.getPeso()));
			    return new ResponseEntity<>(_producto, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
}
