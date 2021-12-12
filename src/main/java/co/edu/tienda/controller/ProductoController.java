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


import co.edu.tienda.model.Producto;
import co.edu.tienda.repository.ProductoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")

public class ProductoController {

	@Autowired
	ProductoRepository productoRepo;
	
	@PostMapping("/productos")
	  public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		  try {
			    Producto _producto = productoRepo.save(new Producto(producto.getNombre(), producto.getPrecio(), producto.getPeso()));
			    return new ResponseEntity<>(_producto, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	 @GetMapping("/productos")
	  public ResponseEntity<List<Producto>> getAllProductos(@RequestParam(required = false) String nombre) {
		  try {
			    List<Producto> productos = new ArrayList<Producto>();

			    if (nombre == null)
			      productoRepo.findAll().forEach(productos::add);
			    else
			      productoRepo.findByNombre(nombre).forEach(productos::add);

			    if (productos.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(productos, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	 }
	 
	 @GetMapping("/productos/{nombre}")
	  public ResponseEntity<Producto> getProductoByNombre(@PathVariable("nombre") String nombre) {
		  Optional<Producto> productoData = productoRepo.findById(nombre);

		  if (productoData.isPresent()) {
		    return new ResponseEntity<>(productoData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	 
	  @PutMapping("/productos/{nombre}")
	  public ResponseEntity<Producto> updateProducto(@PathVariable("nombre") String nombre, Float precio, Float peso, @RequestBody Producto tienda) {
		  Optional<Producto> tiendaData = productoRepo.findById(nombre);

		  if (tiendaData.isPresent()) {
		    Producto _tienda = tiendaData.get();
		    _tienda.setNombre(tienda.getNombre());
		    _tienda.setPrecio(tienda.getPrecio());
		    _tienda.setPeso(tienda.getPeso());
		    return new ResponseEntity<>(productoRepo.save(_tienda), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	 
	  } 
	  
	  @DeleteMapping("/productos/{nombre}")
	  public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("nombre") String nombre) {
		  try {
			    productoRepo.deleteByNombre(nombre);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  
	  @DeleteMapping("/productos")
	  public ResponseEntity<HttpStatus> deleteAllProducto() {
		  try {
			    productoRepo.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
}
}
