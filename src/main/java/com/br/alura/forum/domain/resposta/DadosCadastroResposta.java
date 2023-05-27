package com.br.alura.forum.domain.resposta;

import java.time.LocalDateTime;

import com.br.alura.forum.domain.curso.Curso;
import com.br.alura.forum.domain.topico.StatusTopico;
import com.br.alura.forum.domain.topico.Topico;
import com.br.alura.forum.domain.usuario.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroResposta(
		@NotBlank
		String mensagem,
		@NotNull
		Long topico,
		@NotNull
		Long autor,
		@NotNull
		Boolean solucao) {
}
