package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate anoNascimento;
    private LocalDate anoFalecimento;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(LocalDate anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public LocalDate getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(LocalDate anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
