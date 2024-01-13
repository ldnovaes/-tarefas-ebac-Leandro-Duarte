package br.com.ebac.configuracao;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class Configuracao {

	@Value("${kafka.ebac.nome.topico}")
	private String nomeTopicoEbac;

	@Bean
	public NewTopic topicoEbac() {
		return TopicBuilder.name(nomeTopicoEbac).partitions(1).replicas(1).build();
	};

}
