package com.br.alura.forum.domain.topico;


import org.springframework.data.jpa.repository.JpaRepository;

import com.br.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
