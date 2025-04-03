package com.alisson.biblioteca_de_livros.domain.livro;

import com.alisson.biblioteca_de_livros.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByCategoriaNome(String nomeCategoria);
}
