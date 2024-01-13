package br.com.ldnovaes.mod52rabbitmq.productor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ldnovaes.mod52rabbitmq.service.ServicoRabbit;

@RestController
@RequestMapping("/mensagens")
public class Productor {
	
	@Autowired
	private ServicoRabbit servico;
	
	@PostMapping
	private void enviaMensagem(@RequestBody String mensagem) {
		System.out.println("Enviando Mensagem: " + mensagem);
		this.servico.enviaMensagem(mensagem);
	}

}
