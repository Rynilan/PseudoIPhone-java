package iphone.dados.numero_telefonico;

/** Class to hold the info about pseudo phone numbers. */
public class NumeroTelefonico {
	private String numero;
	private String operadora;
	private double sinal = 0;

	public NumeroTelefonico(String numero, String operadora) {
		this.numero = numero;
		this.operadora = operadora;
		this.sinal = Math.random() * 100;
	}

	public String getNumero() {
		return this.numero;
	}
	
	public String getOperadora() {
		return this.operadora;
	}

	public double getSinal() {
		return this.sinal;
	}

	public void pegarSinalDoutraTorre() {
		this.sinal = Math.random() * 100;
	}
}
