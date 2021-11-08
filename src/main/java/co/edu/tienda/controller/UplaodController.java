
package co.edu.tienda.controller;
/*
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
*/
public class UplaodController {
	/*
	@Autowired
	productosdao productosdao;
	
	@PostMapping("/upload")
	public String uploadFile(Model model, MultipartFile file) throws Exception {
		try {
		 List <productos> productlist= new ArrayList<ProductoVO>();
		 List <String[]> datos=CSVHelper.csvToTutorials(file.getInputStream());
		 ProductoVO p;
		 for(String[] s: datos) {
			 StringTokenizer token = new StringTokenizer(s[0],";")
			String[] tok = new String[4];
			 int i=0;
			 while(token.hasMoreTokens()) {
				 tok[i]=token.nextToken();
				 i++;
			 }
			 p= new Productobo(Integer.parseInt(tok[0]),tok[1],Float.parseFloat(tok[3]));
			 productlist.add(p);
		 }
		 
		 InputStream inputstream = file.getInputStream();
		 
		 CsvParserSettings setting= new CsvParserSettings();
		 setting.setHeaderExtractionEnabled(true);
		 CsvParser parser =new CsvParser(setting);
		 List <Record> parseAllRecord= parser.parseAllRecords(inputstream);
		 
		 parseAllRecord.forEach(Record->{
			 productos productos= new productos();
			productos.setNombre(Record.getString("nombre"));
			productos.setNit(Record.getString("nit"));
			productos.setPrecio(Double.parseDouble(Record.getString("precio")));
			productos.setIvacompra(Double.parseDouble(Record.getString("ivacompra")));
			productos.setPrecio2(Double.parseDouble(Record.getString("precio2")));
			productlist.add(productos);
		 });
		 productosdao.saveAll(productlist);
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
		return "upload sucesfull!!!";
}
	
*/
}
