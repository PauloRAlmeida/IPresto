package presto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presto.model.Endereco;
import presto.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService endService;
	
	@RequestMapping(value= "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes ="application/json")
	public ResponseEntity<String> save (@RequestBody Endereco endereco) {
		endereco = endService.save(endereco);
		if (endereco != null) return new ResponseEntity<String>(endereco.getId().toString(), HttpStatus.CREATED);
		
		return new ResponseEntity<String>("Não", HttpStatus.BAD_REQUEST) ;
	}
	
}
