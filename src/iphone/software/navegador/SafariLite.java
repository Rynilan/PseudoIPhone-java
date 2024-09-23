package iphone.software.navegador;
import iphone.dados.rede.destinos.Sites;
import iphone.dados.rede.conexao.Rede;
import java.io.PrintStream;
import java.util.Scanner;

public class SafariLite implements Navegador {
	private Rede internete;
	private String ferramentaDeBusca;
	private final Sites[] RESULTADOS = Sites.values();
	
	public SafariLite(String nomeDaRede, String tipoDaRede, String ferramentaDeBusca) {
		nomeDaRede = nomeDaRede != null ? nomeDaRede: "FLASH_NET_8G!!!";
		tipoDaRede = tipoDaRede != null ? tipoDaRede: "WIFI";
		ferramentaDeBusca = ferramentaDeBusca != null ? ferramentaDeBusca: "Google";

		this.internete = new Rede(nomeDaRede, tipoDaRede);
		this.ferramentaDeBusca = ferramentaDeBusca;
	}

	public void pesquisar(String pesquisa) {
		if (testarConexao()) {
			System.out.printf("\n - %s -\n\npesuisa: %s\n\n%s", this.ferramentaDeBusca, pesquisa, this.retornarResultados(pesquisa));
		} else {
			if (internete.getConectada()) {
				System.out.println("Conexão fraca, reconectando...");
				this.internete.reconectar();
			} else {
				System.out.println("Rede desconectada, conectando...");
				this.internete.conectar();
			}
			pesquisar(pesquisa);
		}
	}

	/** Return true in good connection, velocity greater than 60. */
	private boolean testarConexao() {
		while (true) {
			double velocidade = internete.getVelocidadeDaConexao();
			if (velocidade == 0 || velocidade < 60) {
				return false;
			} return true;
		}
	}

	/** 
	 * Return the result of the search using the prompt.
	 * @param pesquisa represent the user search.
	 * @return a string with a title of evry site.
	 */
	private String retornarResultados(String pesquisa) {
		String endereco = "";
		for (int indice = 0; indice < RESULTADOS.length; indice++) {
			endereco += String.format(
				"%d - %s%s/\n",
				indice + 1,
				RESULTADOS[indice].getEndereco(),
				pesquisa.replaceAll(" ", "-").toLowerCase()
			);
		}
		return endereco;
	}

	public void entrarNoSite(String pesquisa, int site) {
		RESULTADOS[site].abrirSite(pesquisa);
	}

	/** This method acts like the IU of Safari (generally). */
	public void iniciar(Scanner stdin, PrintStream stdout) {
		String procede = "s";
		this.internete.conectar();
		do  {
			stdout.println("\n- Safari, pesquise e conheça -");
			stdout.print("\n ?>");
			String pesquisa = stdin.nextLine();
			pesquisar(pesquisa);
			stdout.print("Entrar em que site\n ?> ");
			int indice = -1;
			try {
				indice = Integer.parseInt(stdin.nextLine()) - 1;
			} catch (NumberFormatException exception) {
				stdout.print("Valor inválido.");
			}
			if (indice >= 0 && indice < RESULTADOS.length) {
				this.entrarNoSite(pesquisa, indice);
			} else if (indice == -1) {
				"".isEmpty();  // Do nothing.
			} else {
				stdout.printf("%d fora do escopo.", indice);
			}
			stdout.print("\nFazer outra pesquisa? 's' para sim, qualquer outro valor, não.\n ?>");
			procede = stdin.nextLine();
		} while (procede.equals("s"));
		this.internete.desconectar();
	}
}
