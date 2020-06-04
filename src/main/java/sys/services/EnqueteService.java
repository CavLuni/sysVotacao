package sys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;
import sys.domain.Enquete;
import sys.domain.DTO.EnqueteDTO;
import sys.repositories.EnqueteRepository;

@Service
public class EnqueteService {
	
	@Autowired
	private EnqueteRepository repo;
	
	public Enquete insert(Enquete obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Enquete find(Integer id) throws ObjectNotFoundException {
		Optional<Enquete> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(    
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Enquete.class.getName())); 
	}
	/*
	public Enquete findTitulo(String titulo) {
		Enquete obj = repo.findTitulo(titulo);  
		return obj;
	}*/
	
	public Enquete update(Enquete obj) throws ObjectNotFoundException {
		Enquete newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public Enquete fromDTO(EnqueteDTO objDto) {
		return new Enquete(objDto.getId(),objDto.getDataInicial(), objDto.getDataFinal(), objDto.getTitulo(), objDto.getEstado());
	}
	
	public void updateData(Enquete newObj, Enquete obj) {
		newObj.setTitulo(obj.getTitulo());
	}
	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir uma Enquete que possui votos!");
		}
	}
	public List<Enquete> findAll() {
		return repo.findAll();
	}
	
}
