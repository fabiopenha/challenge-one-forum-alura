package com.br.alura.forum.domain.usuario;

import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.Usuario;

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
