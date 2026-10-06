package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Leitor implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Leitor(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void reservar(Livro livro) {
        livro.addObserver(this);
    }

    public void update(Observable livro, Object arg1) {
        this.ultimaNotificacao = this.nome + ", livro reservado disponível: " + livro.toString();
    }
}
