package workflow.util.message_configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class MessageConfig {

    public static final String QUEUE = "workflow_data_queue";
    public static final String EXCHANGE = "workflow_data_exchange";
    public static final String ROUTING_KEY = "workflow_data_routing_key";

//    @Value( "${spring.rabbitmq.host}" )
//    String host;
//    @Value( "${spring.rabbitmq.username}" )
//    String username;
//    @Value( "${spring.rabbitmq.password}" )
//    String password;


    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    //message converter for json
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    //rabbit template
    @Bean
    public AmqpTemplate template() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(this.converter());
        return rabbitTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("electrify");
        connectionFactory.setHost("workflow-rabbit");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory myRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMaxConcurrentConsumers(5);
        ObjectMapper mapper =
            new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        factory.setMessageConverter(new Jackson2JsonMessageConverter(mapper));
        return factory;
    }
}
