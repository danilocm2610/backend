package co.edu.tienda.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParserSettings;

import co.edu.tienda.model.Producto;
import co.edu.tienda.repository.ProductoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UploadController {
	@Autowired
	ProductoRepository productosRep;
	
	@PostMapping("/upload csv")
	public String uploadData(@RequestParam("file") MultipartFile file) throws Exception {
		try {
		 List <Producto> productlist= new ArrayList<>();
		 InputStream inputstream = file.getInputStream();
		 
		 CsvParserSettings setting= new CsvParserSettings();
		 setting.setHeaderExtractionEnabled(true);
		 CsvParser parser =new CsvParser(setting);
		 List <Record> parseAllRecord= parser.parseAllRecords(inputstream);
		 
		 parseAllRecord.forEach(Record->{
			Producto productos= new Producto();
			productos.setNombre(Record.getString("nombre"));
			productos.setPeso(Float.parseFloat(Record.getString("peso")));
			productos.setPrecio(Float.parseFloat(Record.getString("precio")));
			productlist.add(productos);
		 });
		 productosRep.saveAll(productlist);
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
		return "upload sucesfull!!!";
}
	
}