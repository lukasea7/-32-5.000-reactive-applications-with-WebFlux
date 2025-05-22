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
		EventoDto dto = new EventoDto(null, TipoEvento.SHOW, "Kiss",
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

}
