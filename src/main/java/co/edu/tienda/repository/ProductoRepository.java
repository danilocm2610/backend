package co.edu.tienda.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.tienda.model.Producto;


public interface ProductoRepository extends MongoRepository<Producto, String>{
	
	List<Producto> findByNombre(String nombre);

	List<Producto> deleteByNombre(String nombre);
		
}


