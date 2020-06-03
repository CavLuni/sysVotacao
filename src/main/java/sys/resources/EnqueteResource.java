package sys.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sys.domain.Enquete;
import sys.services.EnqueteService;

@RestController
@RequestMapping(value="/enquetes")
public class EnqueteResource {
	
	@Autowired
	private EnqueteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Iterable<String> titulo) {
		Enquete obj = service.buscar(titulo);
		return ResponseEntity.ok().body(obj);
	}
}
