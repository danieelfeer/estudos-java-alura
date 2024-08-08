package br.com.alura.literalura.principal;

import br.com.alura.literalura.service.GutendexApi;
import br.com.alura.literalura.service.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {

    private final String ENDERECO_BASE = "https://gutendex.com/books/?";

    private Scanner leitura = new Scanner(System.in);
    private GutendexApi consumo = new GutendexApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu(){



        var opcao = -1;

            while (opcao != 0) {

                var menu = """
                        ************* Literalura *************
                                        
                        1- Buscar livro pelo título
                        2- Listar livros registrados
                        3- listar autores registrados
                        4- listar autores vivos em um determinado ano
                        5- listar livros em determinado idioma
                                        
                        0 - Sair
                        """;

                System.out.println(menu);
                opcao = leitura.nextInt();
                leitura.nextLine();

                switch (opcao){
                    case 1:
                        buscarLivroPorTitulo();
                        break;
                    case 2:
                        listarLivros();
                        break;
                    case 3:
                        listarAutores();
                        break;
                    case 4:
                        listarAutoresPorAno();
                        break;
                    default:
                        break;
                }

            }
    }

    private void buscarLivroPorTitulo() {
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO_BASE + "search=" + nomeLivro.replace(" ", "+"));
        System.out.println(json);

        var livro = conversor.obterLista(json, Dados.class);
        livro.stream().
                sorted(Comparator.comparing(Dados::autor))
                .forEach(System.out::println);

    }

    private void listarLivros() {
    }

    private void listarAutores() {
    }

    private void listarAutoresPorAno() {
    }
}
