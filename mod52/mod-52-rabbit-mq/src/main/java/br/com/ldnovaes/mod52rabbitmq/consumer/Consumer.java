package br.com.ldnovaes.mod52rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.ldnovaes.mod52rabbitmq.configuration.ConfigurationRabbit;

@Component
@RabbitListener(queues = ConfigurationRabbit.NOME_FILA)
public class Consumer {
	
	@RabbitHandler
	public void consumirMensagem(String mensagem) {
		System.out.println("Recebendo mensagem: " + mensagem);
	}

}
