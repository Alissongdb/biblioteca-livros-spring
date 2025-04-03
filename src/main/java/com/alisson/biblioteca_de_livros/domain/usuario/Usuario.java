package com.alisson.biblioteca_de_livros.domain.usuario;

import com.alisson.biblioteca_de_livros.domain.emprestimo.Emprestimo;
import com.alisson.biblioteca_de_livros.domain.livro.Livro;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Email
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Livro> livros;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;
}
