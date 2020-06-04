package sys.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javassist.tools.rmi.ObjectNotFoundException;
import sys.domain.OpcoesVotos;
import sys.domain.DTO.OpcoesVotosDTO;
import sys.services.OpcoesVotosService;

@RestController
@RequestMapping(value="/opcoesvotos")
public class OpcoesVotosResource {
	
	@Autowired
	public OpcoesVotosService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<OpcoesVotos>> findAll() {
		List<OpcoesVotos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody OpcoesVotosDTO objDto) throws ObjectNotFoundException{
		OpcoesVotos obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody OpcoesVotosDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException {
		OpcoesVotos obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
