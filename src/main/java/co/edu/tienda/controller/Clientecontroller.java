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

import co.edu.tienda.model.Cliente;
import co.edu.tienda.repository.ClienteRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class Clientecontroller {

	@Autowired
	ClienteRepository ClienteRepo;
	
	@PostMapping("/cliente")
	  public ResponseEntity<Cliente> createCliente(@RequestBody Cliente Clientecd) {
		  try {
			  Cliente _cliente = ClienteRepo.save(new Cliente(Clientecd.getCedula(), Clientecd.getNombre(), Clientecd.getDireccion(),Clientecd.getTelefono(),Clientecd.getCorreo()));
			    return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	/*
	 @GetMapping("/clientes")
	  public ResponseEntity<List<Cliente>> getAllClientes(@RequestParam(required = false) String Clientedcd) {
		  try {
			    List<Cliente> clientes = new ArrayList<Cliente>();

			    if (Clientedcd != null)
			      ClienteRepo.findAll().forEach(clientes::add);
			    else
			 // ClienteRepo.findByCedula(Clientedcd).forEach(clientes::add);
			    if (clientes.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(clientes, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	 }
	 
	 @GetMapping("/clientes/{Cedula}")
	  public ResponseEntity<Cliente> getClienteByCedula(@PathVariable("Cedula") String cedulacd) {
		  Optional<Cliente> ClienteData = ClienteRepo.findById(cedulacd);

		  if (ClienteData.isPresent()) {
		    return new ResponseEntity<>(ClienteData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	 
	  @PutMapping("/clientes/{Cedula}")
	  public ResponseEntity<Cliente> updateCliente(@PathVariable("Cedula") String Cedula, String nombre, String direccion,String telefono, String correo, @RequestBody Cliente Cliente) {
		  Optional<Cliente> tiendaData = ClienteRepo.findById(Cedula);

		  if (tiendaData.isPresent()) {
		    Cliente _tienda = tiendaData.get();
		    _tienda.setCedula(Cliente.getCedula());
		    _tienda.setNombre(Cliente.getNombre());
		    _tienda.setDireccion(Cliente.getDireccion());
		    _tienda.setTelefono(Cliente.getTelefono());
		    _tienda.setCorreo(Cliente.getCorreo());
		    
		    
		    return new ResponseEntity<>(ClienteRepo.save(_tienda), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	 
	  } 
	  
	  @DeleteMapping("/clientes/{nombre}")
	  public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("Cedula") String cedulacd) {
		  try {
			    ClienteRepo.deleteByCedula(cedulacd);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  
	  @DeleteMapping("/clientes")
	  public ResponseEntity<HttpStatus> deleteAllClientes() {
		  try {
			    ClienteRepo.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
}

*/
}

