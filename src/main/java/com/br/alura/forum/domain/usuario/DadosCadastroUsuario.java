package com.br.alura.forum.domain.usuario;

import com.br.alura.forum.domain.curso.Curso;
import com.br.alura.forum.domain.topico.StatusTopico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(
		@NotBlank
		String nome, 
		@NotBlank
		String email, 
		@NotBlank
		String senha
		) {

}
