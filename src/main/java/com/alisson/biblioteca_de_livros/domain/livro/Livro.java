package com.alisson.biblioteca_de_livros.domain.livro;

import com.alisson.biblioteca_de_livros.domain.categoria.Categoria;
import com.alisson.biblioteca_de_livros.domain.emprestimo.Emprestimo;
import com.alisson.biblioteca_de_livros.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate anoPublicacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

}
