//package br.com.ramontanure.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///*
// 🚪 Spring Cloud Gateway:
// API Gateway que funciona como ponto único de entrada da aplicação.
// Responsável por receber as requisições e encaminhar para os microserviços corretos,
// podendo também aplicar filtros como log, segurança e validações.
//*/
//
//@Configuration // Configuração do API Gateway (ponto de entrada dos microserviços)
//public class ApiGatewayConfiguration {
//
//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//
//        return builder.routes()
//
//                // 📚 Rota para o book-service
//                // Toda requisição que começa com /book-service/**
//                // é encaminhada para o serviço "book-service"
//                // "lb://" usa o Eureka para descobrir o serviço e o LoadBalancer para escolher a instância
//                .route(p -> p.path("/book-service/**")
//                        .uri("lb://book-service"))
//
//                // 💱 Rota para o exchange-service
//                // Mesmo conceito: o Gateway não usa URL fixa, resolve dinamicamente via Eureka
//                .route(p -> p.path("/exchange-service/**")
//                        .uri("lb://exchange-service"))
//
//                .build();
//    }
//}