package br.com.ldnovaes.mod52rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ldnovaes.mod52rabbitmq.configuration.ConfigurationRabbit;

@Component
public class ServicoRabbit {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void enviaMensagem(String mensagem) {
		this.rabbitTemplate.convertAndSend(ConfigurationRabbit.NOME_EXCHANGE, "ebac.rota.mensagem", mensagem);
	}

}
