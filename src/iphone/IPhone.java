package iphone;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import iphone.software.navegador.SafariLite;
import iphone.software.sistema_telefonico.TelefoneLite;


public class IPhone {
	public static void main(String[] parametros) {
		SafariLite safariLite = new SafariLite(null, null, "Google");
		// Declaration of iTunesLite;
		TelefoneLite telefoneLite = new TelefoneLite("+55 (081) 9 1234-5678", "CLARO");
		Scanner stdin = new Scanner(System.in);
		PrintStream stdout = System.out;
		String input = new String();
		while (!(input.equals("d"))) {
			stdout.println(" IPhone funcionando, que app queres abrir?\n Digite 'd' para desligar o dispositivo.");
			stdout.print(" 1 - Safari Lite.\n 2 - ITunes Lite.\n 3 - Telefone Lite.\n ?>");
			input = stdin.nextLine().toLowerCase();
			try {
				switch (input) {
					case "1":
						safariLite.iniciar(stdin, stdout);
						stdout.print("Saindo...\n\n");
						TimeUnit.SECONDS.sleep(3);
						break;
					case "2":
						// iTunesLite.iniciar(stdin, stdout);
						stdout.print("Saindo...\n\n");
						TimeUnit.SECONDS.sleep(3);				break;
					case "3":
						telefoneLite.iniciar(stdin, stdout);
						stdout.print("Saindo...\n\n");
						TimeUnit.SECONDS.sleep(3);			break;
					case "d":
						stdout.print("Obrigado pela presença.");
						break;
					default:
						stdout.print("Valor não corresponde a aplicação alguma.");
				}
			} catch (InterruptedException excecao) {
				stdout.print("A Aplicação foi fechada inesperadamente.");
			}
		}
		stdin.close();
	}
}
