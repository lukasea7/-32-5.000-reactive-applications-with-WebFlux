package br.com.lukasprojetos.codechella.service;

import br.com.lukasprojetos.codechella.repositories.EventoRepository;
import br.com.lukasprojetos.codechella.dto.EventoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventoService {
    @Autowired
    private EventoRepository repositorio;

    public Flux<EventoDto> obterTodos(){
        return repositorio.findAll()
                .map(EventoDto::toDto);


    }

    public Mono<EventoDto> obterPorId(Long id) {
        return repositorio.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(EventoDto::toDto);
    }
}

