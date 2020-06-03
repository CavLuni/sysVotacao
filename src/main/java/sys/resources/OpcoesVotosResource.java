package sys.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/OpcoesVotos")
public class OpcoesVotosResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public void listar() {
		
	}

}
