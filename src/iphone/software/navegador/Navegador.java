package iphone.software.navegador;
import java.util.Scanner;
import java.io.PrintStream;

/**
 * A mold to a internet browser.
 */
public interface Navegador {
	public void iniciar(Scanner stdin, PrintStream stdout);

	public void pesquisar(String prompt);

	public void entrarNoSite(String pesquisa, int site);
}
