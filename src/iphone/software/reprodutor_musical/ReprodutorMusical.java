package iphone.software.reprodutor_musical;
import iphone.dados.musica.Musica;
import java.io.PrintStream;
import java.util.Scanner;

public interface ReprodutorMusical {
	public void iniciar(Scanner stdin, PrintStream stdout);

	public void reproduzir(Musica obra);

	public void parar();

	public void verTodasAsMusicas();

	public void informacoes(Musica obra);
}
