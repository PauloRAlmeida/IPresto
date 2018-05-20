package presto.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import presto.service.ClienteService;
import presto.service.ComentarioService;
import presto.service.EnderecoService;
import presto.service.MediaService;
import presto.service.PrestadorService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		MediaService medias = (MediaService)context.getBean("mediaService");
		ClienteService cs = (ClienteService)context.getBean("clienteService");
		EnderecoService es = (EnderecoService)context.getBean("enderecoService");
		ComentarioService coms = (ComentarioService)context.getBean("comentarioService");
		PrestadorService pres = (PrestadorService)context.getBean("prestadorService");

		
	}

}
