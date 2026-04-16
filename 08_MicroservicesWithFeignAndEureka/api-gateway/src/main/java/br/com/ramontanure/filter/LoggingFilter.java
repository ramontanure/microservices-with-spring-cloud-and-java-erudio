package br.com.ramontanure.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component // Filtro global do Gateway (executa para todas as requisições)
public class LoggingFilter implements GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 🔍 Loga o caminho da requisição que chegou no Gateway
        // Útil para debug e rastreamento das chamadas entre serviços
        logger.info("Request path -> {}", exchange.getRequest().getPath());

        // 🔁 Continua o fluxo para o serviço de destino
        return chain.filter(exchange);
    }
}