package presto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presto.model.Cliente;
import presto.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/getAll")
	public ResponseEntity<Collection<Cliente>> getAll() {
		return new ResponseEntity<Collection<Cliente>>(clienteService.getAll(), HttpStatus.OK);
}
	
	
	@RequestMapping(value= "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes ="application/json")
	public ResponseEntity<Cliente> save (@RequestBody Cliente cliente) {
		System.out.println(cliente.getAutorizacoes());
		cliente = clienteService.save(cliente);
		if (cliente != null) return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.BAD_REQUEST) ;
	}
	
}
