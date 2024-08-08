package br.com.alura.screenmach.excecao;

public class ErroDeConversaoDeAnoExeception extends RuntimeException {
    private String mensagem;

    public ErroDeConversaoDeAnoExeception(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
