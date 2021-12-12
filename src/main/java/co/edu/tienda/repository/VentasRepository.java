package co.edu.tienda.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.tienda.model.ventas;


public interface VentasRepository extends MongoRepository <ventas, String> {

	List<ventas> findByCedula(String Cedula_Cliente);
}