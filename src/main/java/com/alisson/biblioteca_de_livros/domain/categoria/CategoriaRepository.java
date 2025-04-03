package com.alisson.biblioteca_de_livros.domain.categoria;

import com.alisson.biblioteca_de_livros.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
