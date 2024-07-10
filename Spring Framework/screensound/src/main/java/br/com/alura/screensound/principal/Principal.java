package br.com.alura.screensound.principal;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.Musica;
import br.com.alura.screensound.model.TipoArtista;
import br.com.alura.screensound.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final ArtistaRepository repositorio;

    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu(){

        var opcao = -1;

        while(opcao != 0){

            var menu = """
                ******* ScreenSound *******
                1- Cadastrar Artista
                2- Cadastrar Música
                3- Listar Músicas
                4- Buscar músicas por artista
                
                0- Sair
                """;

            System.out.println(menu);

            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    private void cadastrarArtista() {
        var cadastrarNovoArtista = "S";

        while(cadastrarNovoArtista.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome do Artista: ");
            var nomeArtista = leitura.nextLine();
            System.out.println("Informe o tipo do Artista: (solo, dupla ou banda)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nomeArtista, tipoArtista);
            repositorio.save(artista);
            System.out.println("Deseja cadastrar mais artistas? (S/N)");
            cadastrarNovoArtista = leitura.nextLine();
        }
    }

    private void cadastrarMusica() {
        System.out.println("Cadastrar Musica de que artista?");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()){
            System.out.println("Informe o titulo da musica:");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado");
        }

    }

    private void listarMusicas() {
        List<Artista> listaMusicas = repositorio.findAll();
        listaMusicas.forEach(System.out::println);
    }

    private void buscarMusicaPorArtista() {
    }

}
