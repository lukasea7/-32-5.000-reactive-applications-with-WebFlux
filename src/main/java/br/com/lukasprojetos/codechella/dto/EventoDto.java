package br.com.lukasprojetos.codechella.dto;

import br.com.lukasprojetos.codechella.entities.Evento;
import br.com.lukasprojetos.codechella.entities.TipoEvento;

import java.time.LocalDate;


public record EventoDto(Long id,
                        TipoEvento tipo,
                        String nome,
                        LocalDate data,
                        String descricao) {

    public static EventoDto toDto(Evento evento) {
        return new EventoDto(evento.getId(), evento.getTipo(), evento.getNome(),
                evento.getData(), evento.getDescricao());
    }

    public Evento toEntity() {
        Evento evento = new Evento();
        evento.setId(this.id);
        evento.setNome(this.nome);
        evento.setTipo(this.tipo);
        evento.setDate(this.data);
        evento.setDescricao(this.descricao);
        return  evento;
    }
}
