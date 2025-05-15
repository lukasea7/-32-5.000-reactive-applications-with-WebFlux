package br.com.lukasprojetos.codechella;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {
}
