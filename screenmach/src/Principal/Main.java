package Principal;

import br.com.alura.screenmach.modelos.Episodio;
import br.com.alura.screenmach.modelos.Filme;
import br.com.alura.screenmach.modelos.Serie;
import br.com.alura.screenmach.modelos.Titulo;
import br.com.alura.screenmach.modelos.calculos.CalculadoraDeTempo;
import br.com.alura.screenmach.modelos.calculos.FitroRecomendacao;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Criando Objeto Filme toyStory
        Filme toyStory = new Filme("Toy Story", 2005);
        toyStory.setDuracaoEmMinutos(180);
        System.out.println("Duracao do filme: " + toyStory.getDuracaoEmMinutos());

        toyStory.exibeFichaTecnica();

        toyStory.avalia(10);
        toyStory.avalia(9);
        toyStory.avalia(8.5);

        System.out.println("Total de avaliações: " + toyStory.getTotalDeAvaliacoes());
        System.out.println(toyStory.pegaMedia());

        //Criando Objeto Serie peakBlinders
        Serie peakBlinders = new Serie("Peak Blinders", 2011);

        peakBlinders.exibeFichaTecnica();
        peakBlinders.setTemporadas(4);
        peakBlinders.getEpisodiosPorTemporada(8);
        peakBlinders.setMinutosPorEpisodio(50);

        System.out.println("Duração para maratonar Peak Blinders " + peakBlinders.getDuracaoEmMinutos());

        Filme lalaLand = new Filme("La La Land", 2014);
        lalaLand.setDuracaoEmMinutos(190);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(toyStory);
        calculadora.inclui(lalaLand);
        calculadora.inclui(peakBlinders);
        System.out.println(calculadora.getTempoTotal());

        FitroRecomendacao filtro = new FitroRecomendacao();
        filtro.filtra(toyStory);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(peakBlinders);
        episodio.setTotalVisualizacoes(30000);

        filtro.filtra(episodio);

    }
}
