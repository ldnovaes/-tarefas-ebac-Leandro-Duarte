package br.com.ebac.produtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebac.service.ServiceEnvioMensagem;

@RestController
@RequestMapping("/eventos")
public class ProdutorController {
	
	@Autowired
	private ServiceEnvioMensagem service;
	
	@PostMapping
	public void enviaMensagem(@RequestBody String mensagem) {
		service.enviarMensagem(mensagem);
	}
}
