package padroescomportamentais.observer;

import java.util.Observable;

public class Livro extends Observable {

    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public boolean emprestar() {
        if (!this.disponivel) {
            return false;
        }
        this.disponivel = false;
        return true;
    }

    public void devolver() {
        if (!this.disponivel) {
            this.disponivel = true;
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public String toString() {
        return "Livro{" +
            "titulo='" + titulo + '\'' +
            ", autor='" + autor + '\'' +
            '}';
    }
}
