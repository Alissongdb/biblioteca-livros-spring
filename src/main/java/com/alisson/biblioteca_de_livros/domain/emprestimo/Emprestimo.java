package com.alisson.biblioteca_de_livros.domain.emprestimo;

import com.alisson.biblioteca_de_livros.domain.livro.Livro;
import com.alisson.biblioteca_de_livros.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "emprestimos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmprestimo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
