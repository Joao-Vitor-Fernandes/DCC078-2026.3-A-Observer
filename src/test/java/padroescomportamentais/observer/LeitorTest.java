package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeitorTest {

    @Test
    void deveNotificarUmLeitor() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis");
        Leitor leitor = new Leitor("Leitor 1");
        leitor.reservar(livro);
        livro.emprestar();
        livro.devolver();
        assertEquals("Leitor 1, livro reservado disponível: Livro{titulo='Dom Casmurro', autor='Machado de Assis'}", leitor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarLeitores() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis");
        Leitor leitor1 = new Leitor("Leitor 1");
        Leitor leitor2 = new Leitor("Leitor 2");
        leitor1.reservar(livro);
        leitor2.reservar(livro);
        livro.emprestar();
        livro.devolver();
        assertEquals("Leitor 1, livro reservado disponível: Livro{titulo='Dom Casmurro', autor='Machado de Assis'}", leitor1.getUltimaNotificacao());
        assertEquals("Leitor 2, livro reservado disponível: Livro{titulo='Dom Casmurro', autor='Machado de Assis'}", leitor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarLeitor() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis");
        Leitor leitor = new Leitor("Leitor 1");
        livro.emprestar();
        livro.devolver();
        assertEquals(null, leitor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarLeitorLivroA() {
        Livro livroA = new Livro("Dom Casmurro", "Machado de Assis");
        Livro livroB = new Livro("Vidas Secas", "Graciliano Ramos");
        Leitor leitor1 = new Leitor("Leitor 1");
        Leitor leitor2 = new Leitor("Leitor 2");
        leitor1.reservar(livroA);
        leitor2.reservar(livroB);
        livroA.emprestar();
        livroA.devolver();
        assertEquals("Leitor 1, livro reservado disponível: Livro{titulo='Dom Casmurro', autor='Machado de Assis'}", leitor1.getUltimaNotificacao());
        assertEquals(null, leitor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarLeitorSeLivroNaoFoiEmprestado() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis");
        Leitor leitor = new Leitor("Leitor 1");
        leitor.reservar(livro);
        livro.devolver();
        assertEquals(null, leitor.getUltimaNotificacao());
    }

    @Test
    void deveEmprestarLivroDisponivel() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis");
        assertTrue(livro.emprestar());
        assertFalse(livro.isDisponivel());
    }

    @Test
    void naoDeveEmprestarLivroJaEmprestado() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis");
        livro.emprestar();
        assertFalse(livro.emprestar());
        assertFalse(livro.isDisponivel());
    }
}
