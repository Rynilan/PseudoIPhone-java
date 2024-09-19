package iphone.software.sistema_telefonico;
import iphone.dados.numero_telefonico.NumeroTelefonico;

public interface SistemaTelefonico {
	public void iniciar();

	public void fazerLigacao(NumeroTelefonico receptor);
}
