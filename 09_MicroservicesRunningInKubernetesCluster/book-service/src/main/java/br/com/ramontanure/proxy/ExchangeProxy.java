package br.com.ramontanure.proxy;

import br.com.ramontanure.dto.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

//@FeignClient(name = "exchange-service")
@FeignClient(name = "exchange-service", url = "{EXCHANGE_SERVICE_SERVICE_HOST:host.docker.internal}:8000")
// 🔗 Feign Client:
// Permite chamar outro microserviço como se fosse método Java
// Usa Eureka para descobrir o serviço automaticamente

public interface ExchangeProxy {

    @GetMapping(value = "/exchange-service/{amount}/{from}/{to}")
    // 📡 Define o endpoint do outro serviço

    public Exchange getExchange(
            @PathVariable Double amount,
            @PathVariable String from,
            @PathVariable String to);
}

//EXCHANGE_SERVICE_SERVICE_HOST