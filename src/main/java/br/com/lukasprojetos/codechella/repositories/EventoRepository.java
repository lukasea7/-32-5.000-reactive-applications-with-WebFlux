package br.com.lukasprojetos.codechella.repositories;

import br.com.lukasprojetos.codechella.entities.Evento;
import br.com.lukasprojetos.codechella.entities.TipoEvento;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {


  Flux<Evento> findByTipo(TipoEvento tipoEvento);
  }
