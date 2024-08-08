package br.com.alura.screenmach.modelos.calculos;

import br.com.alura.screenmach.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    public void inclui(Titulo titulo){
        System.out.println("Adicionando duração em minutos de " +  titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
