package br.com.lukasprojetos.codechella.service;

import br.com.lukasprojetos.codechella.repositories.EventoRepository;
import br.com.lukasprojetos.codechella.dto.EventoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EventoService {
    @Autowired
    private EventoRepository repositorio;

    public Flux<EventoDto> obterTodos(){
        return repositorio.findAll()
                .map(EventoDto::toDto);
    }
}
