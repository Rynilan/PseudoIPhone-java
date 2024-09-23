package iphone.software.reprodutor_musical;
import iphone.dados.musica.Musica;

import java.io.PrintStream;
import java.util.Scanner;
import java.lang.NumberFormatException;

/** Class to work as the IPhone music player. */
public class ITunesLite implements ReprodutorMusical {

	/** The list of musics of the app. */
	private Musica[] musicas = {
		new Musica("All Star", "Smach Mouth", 128),
		new Musica("Halleluja", "Leonard Cohen", 279),
		new Musica("Velocidade da Luz", "Grupo Revelação", 226),
		new Musica("Se Você Quer Sorrir", "Patati e Patatá", 175),
		new Musica("Undertale", "Toby Fox", 382)
	};
	/** Ressemble the abilitie of this code to play musics
	 * Maybe someday I try to do it.
	 */
	private final boolean reproduz =  false;
	/** True if there's any music current playing. */
	private boolean tocando = false;
	/** 'll hold the music object that's currently being played. */
	private Musica musicaTocando;
	
	/** Should play the music. Now it show a message saying that
	 * something won't make the music to be played.
	 * @param obra the Music object to be played.
	 */
	public void reproduzir(Musica obra) {
		if (this.reproduz) {
			// Some code to play the music, method.
		} else {
			System.out.printf("Alguma coisa impede tocar a música %s.\n", obra.getTitulo());
		}
	}

	/** Should stop the music that would be current playing. */
	public void parar() {
		if (this.tocando) {
			System.out.printf("%s parada.\n", this.musicaTocando.getTitulo());
		} else {
			System.out.print("Não há música sendo tocada.");
		}
	}

	/** 'll list all the musics registered on the console. */
	public void verTodasAsMusicas() {
		for (int indice = 0; indice < this.musicas.length; indice++) {
			System.out.printf("%d - %s.\n", indice + 1, this.musicas[indice].getTitulo());
		}
	}

	/** Show all the info of the music formated on the console.
	 * @param obra the music object wich the iformation 'll be shown.
	 */
	public void informacoes(Musica obra) {
		System.out.printf(
			"Título: %s.\nAutor(a)(s): %s.\nDuracao: %s.",
			obra.getTitulo(),
			obra.getArtista(), 
			this.formatarTempo(obra.getDuracao())
		);
	}

	/** Format a given value of seconds in the format HH:MM:SS.
	 * @param segundos a double value ressembling time in seconds.
	 */
	private String formatarTempo(double segundos) {
		if (segundos / 3600 >= 0) {
			return String.format("%02.0f:%02.0f", segundos / 60, segundos % 60);
		}
		return String.format("%02.0f:%02.0f:%02.0f", segundos / 3600, (segundos / 60) % 60, segundos % 3600 % 60);
	}

	/** The "UI" of the ITunes. 
	 * @param stdin the standart input, a scanner object.
	 * @param stdout the standart output, literally the statement 'System.out'
	 */
	public void iniciar(Scanner stdin, PrintStream stdout) {
		String procede = "s";	
		stdout.print("\nBem vindo ao ITunes Lite.");
		do {
			stdout.print("O que desejas fazer?\n 1 - Ver Informação duma música.\n 2 - Tocar uma música.\n 3 - Parar a música que estiver tocando.\n ?>");
			int acao, indice = -1;
			try {
				acao = Integer.parseInt(stdin.nextLine());
				stdout.println("Indique sobre que música farás essa ação.\n");
				this.verTodasAsMusicas();
				stdout.print(" ?>");
				indice = Integer.parseInt(stdin.nextLine()) - 1;
				if (!(indice < this.musicas.length)) {
					stdout.println("Música fora do escopo.");
				} else {
					switch (acao) {
						case 1:
							this.informacoes(this.musicas[indice]);
							break;
						case 2:
							this.reproduzir(this.musicas[indice]);
							break;
						case 3:
							this.parar();
							break;
						default:
							stdout.println("Ação inserida não pertence ao escopo oferecido.");
							break;
					}
				}
			} catch (NumberFormatException excecao) {
				stdout.println("Valor inválido.");
			}
			stdout.print("\nManter se no app? 's' para sim, qualquer outro valor para não.\n ?>");
			procede = stdin.nextLine();
		} while (procede.equals("s"));
	}
}
