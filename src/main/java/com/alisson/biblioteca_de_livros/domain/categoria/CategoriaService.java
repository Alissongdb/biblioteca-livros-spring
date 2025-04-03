package com.alisson.biblioteca_de_livros.domain.categoria;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> buscarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarCategoriasById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com este ID: " + id));
    }
}
