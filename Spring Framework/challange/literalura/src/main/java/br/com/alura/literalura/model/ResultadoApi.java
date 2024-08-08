package br.com.alura.literalura.model;

import java.util.List;

public class ResultadoApi {
    private int count;
    private String next;
    private String previous;
    private List<DadosLivro> results;

    // Getters e Setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<DadosLivro> getResults() {
        return results;
    }

    public void setResults(List<DadosLivro> results) {
        this.results = results;
    }
}
