package br.com.lukasprojetos.codechella.controllers;

import br.com.lukasprojetos.codechella.dto.EventoDto;
import br.com.lukasprojetos.codechella.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterTodos(){
        return service.obterTodos();
    }

}
