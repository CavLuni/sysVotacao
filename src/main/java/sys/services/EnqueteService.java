package sys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.domain.Enquete;
import sys.repositories.EnqueteRepository;

@Service
public class EnqueteService {
	
	@Autowired
	private EnqueteRepository repo;

	public Enquete buscar(Iterable<String> titulo) {
		Enquete obj = (Enquete) repo.findAllById(titulo);  
		return obj; 
	}
}
