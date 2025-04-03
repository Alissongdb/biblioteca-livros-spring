package com.alisson.biblioteca_de_livros.domain.livro;

import com.alisson.biblioteca_de_livros.domain.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro adicionarLivros(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> buscarLivrosByCategoria(String nomeCategoria) {
        return livroRepository.findByCategoriaNome(nomeCategoria);
    }
}
