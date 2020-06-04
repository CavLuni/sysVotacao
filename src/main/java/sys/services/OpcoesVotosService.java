package sys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;
import sys.domain.OpcoesVotos;
import sys.domain.DTO.OpcoesVotosDTO;
import sys.repositories.OpcoesVotosRepository;

@Service
public class OpcoesVotosService {
	
	@Autowired
	private OpcoesVotosRepository repo;
	
	public OpcoesVotos insert(OpcoesVotos obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public OpcoesVotos find(Integer id) throws ObjectNotFoundException {
		Optional<OpcoesVotos> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(    
				"Objeto não encontrado! Id: " + id + ", Tipo: " + OpcoesVotos.class.getName())); 
	}
	/*
	public OpcoesVotos findTitulo(String titulo) {
		OpcoesVotos obj = repo.findTitulo(titulo);  
		return obj;
	}*/
	
	public OpcoesVotos update(OpcoesVotos obj) throws ObjectNotFoundException {
		OpcoesVotos newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public OpcoesVotos fromDTO(OpcoesVotosDTO objDto) {
		return new OpcoesVotos(objDto.getId(),objDto.getOpcao(), objDto.getEnquete());
	}
	
	public void updateData(OpcoesVotos newObj, OpcoesVotos obj) {
		newObj.setOpcao(obj.getOpcao());
	}
	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir uma OpcoesVotos que possui votos!");
		}
	}
	public List<OpcoesVotos> findAll() {
		return repo.findAll();
	}
	
}
