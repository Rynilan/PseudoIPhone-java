package iphone.dados.numero_telefonico;

public class NumeroTelefonico {
	/** Class to hold the info about pseudo phone numbers. */
	private int numero;
	private String operadora;
	private double sinal = 0;

	public NumeroTelefonico(int numero, String operadora) {
		this.numero = numero;
		this.operadora = operadora;
		this.sinal = Math.random() * 100;
	}

	public int getNumero() {
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
