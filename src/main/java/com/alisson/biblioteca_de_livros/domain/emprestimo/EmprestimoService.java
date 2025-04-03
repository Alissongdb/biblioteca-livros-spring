package com.alisson.biblioteca_de_livros.domain.emprestimo;

import com.alisson.biblioteca_de_livros.domain.livro.Livro;
import com.alisson.biblioteca_de_livros.domain.livro.LivroRepository;
import com.alisson.biblioteca_de_livros.domain.usuario.Usuario;
import com.alisson.biblioteca_de_livros.domain.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;

    public Emprestimo criarEmprestimo(Long usuarioId, Long livroId, LocalDate dataDevolucao) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (emprestimoRepository.existsByLivroAndDataDevolucaoIsNull(livro)) {
            throw new RuntimeException("O livro já está emprestado e não foi devolvido ainda!");
        }

        if (dataDevolucao.isBefore(LocalDate.now())) {
            throw new RuntimeException("A data de devolução deve ser no futuro");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(dataDevolucao);

        return emprestimoRepository.save(emprestimo);
    }
}
