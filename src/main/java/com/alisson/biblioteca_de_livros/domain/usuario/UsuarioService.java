package com.alisson.biblioteca_de_livros.domain.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));
    }
}
