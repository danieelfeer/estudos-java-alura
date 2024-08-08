package br.com.alura.literalura.model;


import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Idioma traducao;
    private String totalDownloads;

    @ManyToOne
    private Autor autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idioma getTraducao() {
        return traducao;
    }

    public void setTraducao(Idioma traducao) {
        this.traducao = traducao;
    }

    public String getTotalDownloads() {
        return totalDownloads;
    }

    public void setTotalDownloads(String totalDownloads) {
        this.totalDownloads = totalDownloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
