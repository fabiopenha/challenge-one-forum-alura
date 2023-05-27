package com.br.alura.forum.domain.usuario;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.alura.forum.domain.topico.Topico;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	@Query("SELECT u FROM Usuario u WHERE u.email LIKE %:search%")
	Page<Usuario> findByEmail(String search, Pageable paginacao);
	
	UserDetails findByEmail(String email);
}
