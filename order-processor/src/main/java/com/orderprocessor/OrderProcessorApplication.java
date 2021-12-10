package com.orderprocessor;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
//@EnableBinding(OrderProcessor.class)
public class OrderProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessorApplication.class, args);
	}

	
    @Bean
    public Consumer<CustomerOrder> createdOrders() {
    	return  order -> { 
    		log.info("order received by processor: {}", order);
    	};
    }
}
