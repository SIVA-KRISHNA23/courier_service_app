//package com.example.courier.config;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.connection.SingleConnectionFactory;
//import org.springframework.jms.core.JmsTemplate;
//
//@Configuration
//public class MessagingConfig {
//
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory() {
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
//        factory.setBrokerURL("tcp://localhost:61616"); // Example broker URL
//        // Optionally set username and password if required
//        factory.setUserName("root");
//        factory.setPassword("sivakrishna143.");
//        return factory;
//    }
//
//    @Bean
//    public SingleConnectionFactory connectionFactory() {
//        SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory();
//        singleConnectionFactory.setTargetConnectionFactory(activeMQConnectionFactory()); // Setting the target connection factory
//        return singleConnectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
//        // Configure JmsTemplate if needed
//        return jmsTemplate;
//    }
//}
