/**
 * 
 */
package br.com.ldnovaes.vendas.onlineconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.rpires.vendas.online.repository")
public class MongoConfig {

}
