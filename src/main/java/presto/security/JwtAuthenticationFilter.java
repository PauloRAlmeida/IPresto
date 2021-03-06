package presto.security;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import presto.model.Cliente;

public class JwtAuthenticationFilter extends GenericFilterBean{

	private String tokenHeader = "Authorization";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
				try {
			HttpServletRequest servletRequest = (HttpServletRequest) request;
			String authorization = servletRequest.getHeader(tokenHeader);
			if (authorization != null) {
                Cliente cliente = JwtUtils.parseToken(authorization.replaceAll("Bearer ", ""));
                Authentication credentials = new UsernamePasswordAuthenticationToken(cliente.getEmail(), cliente.getSenha(), cliente.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(credentials);
            }
            
			chain.doFilter(request, response);
        }
        catch(Throwable t) {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, t.getMessage());
        }
    }
	
}

