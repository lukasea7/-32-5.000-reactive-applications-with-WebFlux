package br.com.lukasprojetos.codechella.repositories;

import br.com.lukasprojetos.codechella.entities.Evento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {
}
