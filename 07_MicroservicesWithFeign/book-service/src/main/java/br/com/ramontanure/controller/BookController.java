package br.com.ramontanure.controller;

import br.com.ramontanure.dto.Exchange;
import br.com.ramontanure.environment.InstanceInformationService;
import br.com.ramontanure.model.Book;
import br.com.ramontanure.proxy.ExchangeProxy;
import br.com.ramontanure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private BookRepository repository;

    @Autowired
    private ExchangeProxy proxy;

    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

        String port = informationService.retrieveServerPort();

        Book book = repository.findById(id).orElseThrow();

        Exchange exchange = proxy.getExchange(book.getPrice(), "USD", currency);



        book.setEnvironment(port + "FEIGN");
        book.setPrice(exchange.getConvertedValue());
        book.setCurrency(currency);
        //return new Book(1L, "Nigel Poulton", "Nigel Poulton", new Date(), 15.8, "BRL", port);

        return book;
    }

//    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
//
//        String port = informationService.retrieveServerPort();
//
//        Book book = repository.findById(id).orElseThrow();
//
//        HashMap<String, String> params = new HashMap<>();
//        params.put("amount", book.getPrice().toString());
//        params.put("from", "USD");
//        params.put("to", currency);
//
//        var response = new RestTemplate().getForEntity("http://localhost:8000/exchange-service/" + "{amount}/{from}/{to}", Exchange.class, params);
//
//        Exchange exchange = response.getBody();
//
//
//
//        book.setEnvironment(port);
//        book.setPrice(exchange.getConvertedValue());
//        book.setCurrency(currency);
//        //return new Book(1L, "Nigel Poulton", "Nigel Poulton", new Date(), 15.8, "BRL", port);
//
//        return book;
//    }

//
//    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
//
//        Book book = repository.findById(id).orElseThrow();
//        String port = informationService.retrieveServerPort();
//
//        book.setEnvironment(port);
//        book.setCurrency(currency);
//        //return new Book(1L, "Nigel Poulton", "Nigel Poulton", new Date(), 15.8, "BRL", port);
//
//        return book;
//    }

}
