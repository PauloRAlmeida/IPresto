package presto.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import presto.model.Cliente;
import presto.security.JwtUtils;
import presto.security.Login;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    
    @Autowired
    @Qualifier("authenticationManager")
   
    private AuthenticationManager auth;

    public void setAuth(AuthenticationManager auth) {
        this.auth = auth;
    }
    
    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente login(@RequestBody Login login, HttpServletResponse response) throws JsonProcessingException {
    	System.out.println(login.getPassword() + login.getUsername());
        Authentication credentials = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        Cliente cliente = (Cliente) auth.authenticate(credentials).getPrincipal();
        cliente.setSenha(null);
           response.setHeader("Token", JwtUtils.generateToken(cliente));
           return cliente;
    }
    

}
