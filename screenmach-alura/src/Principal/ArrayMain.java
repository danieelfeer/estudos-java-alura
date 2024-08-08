package Principal;

import br.com.alura.screenmach.modelos.Filme;
import br.com.alura.screenmach.modelos.Serie;
import br.com.alura.screenmach.modelos.Titulo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArrayMain {
    public static void main(String[] args) {
        Filme toyStory = new Filme("Toy Story", 2005);
        Filme lalaLand = new Filme("La la Land", 2014);
        Serie peakBlinders = new Serie("Peak Blinders", 2011);

        ArrayList<Titulo> lista = new ArrayList<>();

        lista.add(toyStory);
        lista.add(lalaLand);
        lista.add(peakBlinders);

        System.out.println("Tamanho da Lista " + lista.size());
        System.out.println("Primeiro filme " + lista.getFirst().getNome());

        for( Titulo item: lista){
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtistas = new ArrayList<>();

        buscaPorArtistas.add("Adam Sandler");
        buscaPorArtistas.add("Ryan Gosling");
        buscaPorArtistas.add("Big Joel");
        System.out.println(buscaPorArtistas);

        Collections.sort(buscaPorArtistas);
        System.out.println("Em ordem alfabética");
        System.out.println(buscaPorArtistas);

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenado por ano:");
        System.out.println(lista);
    }
}
