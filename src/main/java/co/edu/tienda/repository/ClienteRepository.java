package co.edu.tienda.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.tienda.model.Cliente;
import co.edu.tienda.model.Producto;

public interface  ClienteRepository extends MongoRepository<Cliente, String>{
	List<Producto> findByCedula(String cedula);

	List<Producto> deleteByCedula(String cedula);
	

}
