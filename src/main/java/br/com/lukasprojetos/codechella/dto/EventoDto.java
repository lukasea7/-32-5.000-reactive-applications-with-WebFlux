package br.com.lukasprojetos.codechella.dto;

import br.com.lukasprojetos.codechella.entities.Evento;
import br.com.lukasprojetos.codechella.entities.TipoEvento;

import java.time.LocalDate;

public record EventoDto(Long id,TipoEvento tipo,
                        String name,
                        LocalDate date,
                        String descricao) {

    public static EventoDto toDto(Evento evento){
       return new EventoDto(evento.getId(), evento.getTipo(), evento.getNome(), evento.getDate(),
               evento.getDescricao());

    }
}
