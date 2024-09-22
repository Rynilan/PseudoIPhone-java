package iphone;
import java.io.PrintStream;
import java.util.Scanner;
import iphone.software.navegador.SafariLite;


public class IPhone {
	public static void main(String[] parametros) {
		SafariLite safariLite = new SafariLite(null, null, "Google");
		// Declaration of iTunesLite;
		// Declaration of telefoneLite.
		Scanner stdin = new Scanner(System.in);
		PrintStream stdout = System.out;
		String input = new String();
		while (input != "n") {
			stdout.print("\033[H\033[2");
			stdout.flush();
			stdout.println("IPhone funcionando, que app queres abrir?\n Digite 'd' para desligar o dispositivo.");
			stdout.print(" 1 - Safari Lite.\n 2 - ITunes Lite.\n 3 - Telefone Lite.\n ?>");
			input = stdin.nextLine();
			switch (input) {
				case "1":
					safariLite.iniciar(stdin, stdout);
					break;
				case "2":
					// iTunesLite.iniciar(stdin, stdout);
					break;
				case "3":
					// telefoneLite.iniciar(stdin, stdout);
					break;
				case "d":
					stdout.print("Obrigado pela presença.");
					break;
				default:
					stdout.print("Valor não corresponde a aplicação alguma.");
			}
		}
		stdin.close();
	}
}
