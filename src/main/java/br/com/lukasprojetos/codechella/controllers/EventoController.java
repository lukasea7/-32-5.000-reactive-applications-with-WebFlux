package br.com.lukasprojetos.codechella.controllers;

import br.com.lukasprojetos.codechella.dto.EventoDto;
import br.com.lukasprojetos.codechella.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;


@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService servico;

    @GetMapping //(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterTodos() {
        return servico.obterTodos();
    }

    @GetMapping(value = "/categoria/{tipo}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterPorTipo(@PathVariable String tipo) {
        return Flux.from(servico.obterPorTipo(tipo))
                .delayElements(Duration.ofSeconds(4));

    }




    @GetMapping("/{id}")
    public Mono<EventoDto> obterPorId(@PathVariable Long id) {
        return servico.obterPorId(id);
    }

    @PostMapping
    public Mono<EventoDto> cadastrar(@RequestBody EventoDto dto) {
        return servico.cadastrar(dto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> excluir(@PathVariable Long id) {
        return servico.excluir(id);

    }

    @PutMapping("/{id}")
    public Mono<EventoDto> alterar(@PathVariable Long id, @RequestBody EventoDto dto){
        return servico.alterar(id, dto);
    }
}



