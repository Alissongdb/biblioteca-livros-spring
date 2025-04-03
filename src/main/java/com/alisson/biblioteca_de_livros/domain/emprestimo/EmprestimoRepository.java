package com.alisson.biblioteca_de_livros.domain.emprestimo;

import com.alisson.biblioteca_de_livros.domain.livro.Livro;
import com.alisson.biblioteca_de_livros.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    boolean existsByLivroAndDataDevolucaoIsNull(Livro livro);
}
