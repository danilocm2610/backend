package co.edu.tienda.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.tienda.model.Ventas;

public interface VentasRepository extends MongoRepository <Ventas, String> {

	List<Ventas> deleteByNombre(String nombre);
	List<Ventas> findByCedula(String cedula_Cliente);


}