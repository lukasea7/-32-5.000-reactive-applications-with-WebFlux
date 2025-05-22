package br.com.lukasprojetos.codechella;

import br.com.lukasprojetos.codechella.dto.EventoDto;
import br.com.lukasprojetos.codechella.entities.TipoEvento;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CodechellaApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void cadastraNovoEvento() {
		EventoDto dto = new EventoDto(12l, TipoEvento.SHOW, "Kiss",
				LocalDate.parse("2025-01-01"),"Show da banda mais quente do mundo Kiss");

		webTestClient.post().uri("/eventos").bodyValue(dto)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(EventoDto.class)
				.value(response ->{
					assertNotNull(response.id());
					assertEquals(dto.tipo(),response.tipo());
					assertEquals(dto.nome(),response.nome());
					assertEquals(dto.data(),response.data());
					assertEquals(dto.descricao(),response.descricao());
				});
	}

	@Test
	void buscarEvento() {
		EventoDto dto = new EventoDto(13l, TipoEvento.SHOW, "The Weeknd",
				LocalDate.parse("2025-11-02"),"De volta ao Brasil, Bruno promete entregar o maior e melhor show de sua carreira na turnê This is Mars");

		webTestClient.get().uri("/eventos")
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBodyList(EventoDto.class)
				.value(response ->{
					EventoDto eventoResponse = response.get(12);
					assertEquals(dto.id(),eventoResponse.id());
					assertEquals(dto.tipo(),eventoResponse.tipo());
					assertEquals(dto.nome(),eventoResponse.nome());
					assertEquals(dto.data(),eventoResponse.data());
					assertEquals(dto.descricao(),eventoResponse.descricao());
				});
	}

}
