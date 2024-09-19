package iphone.software.navegador;
import iphone.dados.rede.Rede;
import java.util.ArrayList;

public class Safari implements Navegador {
	private Rede internete;
	private String ferramentaDeBusca;
	private ArrayList<String> resultados = new ArrayList<String>();
	
	public Safari(String nomeDaRede, String tipoDaRede, String ferramentaDeBusca) {
		nomeDaRede = nomeDaRede != null ? nomeDaRede: "FLASH_NET_8G!!!";
		tipoDaRede = tipoDaRede != null ? tipoDaRede: "WIFI";
		ferramentaDeBusca = ferramentaDeBusca != null ? ferramentaDeBusca: "Google";

		this.internete = new Rede(nomeDaRede, tipoDaRede);
		this.ferramentaDeBusca = ferramentaDeBusca;

		this.internete.conectar();
		this.resultados.add("%s - Mães solteiras a 2kms de você!");
		this.resultados.add("%s - Veja a opinião de Albert Einstein");
		this.resultados.add("%s - Ofertas 80% OFF!");
	}

	public void iniciar() {
		/** This method acts like the IU of Safari (generally). */
	}
	
	public void pesquisar(String prompt) {
		if (testarConexao()) {
			System.out.printf(" - %s -\n\npesuisa: %s\n\n%s", this.ferramentaDeBusca, prompt, retornarResultados(prompt));
		} else {
			if (internete.getConectada()) {
				System.out.println("Conexão fraca, reconectando...");
				this.internete.reconectar();
			} else {
				System.out.println("Rede desconectada, conectando...");
				this.internete.conectar();
			}
			pesquisar(prompt);
		}
	}

	private boolean testarConexao() {
		/** Return true in good connection, velocity greater than 60. */

		while (true) {
			double velocidade = internete.getVelocidadeDaConexao();
			if (velocidade == 0 || velocidade < 60) {
				return false;
			} return true;
		}
	}

	private String retornarResultados(String prompt) {
		/** Return the result of the search using the prompt. */

		return String.format(this.resultados.get(0), prompt) + String.format(this.resultados.get(1), prompt) + String.format(this.resultados.get(2), prompt);
	}

	// entrarNoSite(); came as a default method out of the Navegador interface.
}
