package presto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Disciplina;
import presto.View.View;
import presto.model.Autorizacao;
import presto.model.Cliente;
import presto.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@RequestMapping(value = "/getAll")
	@JsonView(View.Cliente.class)
	public ResponseEntity<Collection<Cliente>> getAll() {
		return new ResponseEntity<Collection<Cliente>>(clienteService.getAll(), HttpStatus.OK);
}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/getClienteLogado/", produces="application/json", method = RequestMethod.GET)
	@JsonView(View.Alternative.class)
	public ResponseEntity <Cliente> findById(){
		UserDetails aut  = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        Cliente cliente = clienteService.findByEmail(aut.getUsername());
        System.out.println(cliente.getId());
        return new ResponseEntity<Cliente>(cliente, HttpStatus.BAD_REQUEST) ;

	}

	
	@RequestMapping(value= "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes ="application/json")
	public ResponseEntity<Cliente> save (@RequestBody Cliente cliente) {
		cliente = clienteService.save(cliente);
		if (cliente != null) return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.BAD_REQUEST);
	}
	
}
