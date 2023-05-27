package com.br.alura.forum.domain.topico;

import com.br.alura.forum.domain.curso.Curso;
import com.br.alura.forum.domain.usuario.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
		@NotBlank
		String titulo, 
		@NotBlank
		String mensagem, 
		@NotNull
		StatusTopico status, 
		@NotNull
		Long autor,
		@NotNull
		Long curso) {

}
