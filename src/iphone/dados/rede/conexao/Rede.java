package iphone.dados.rede.conexao;

public class Rede {
	/** Class to hold info of a pseudo connection with the internet. */
	private String nome;
	private String tipo;
	private double velocidadeDaConexao = 0;
	private boolean conectada = false;
	
	public Rede(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public double getVelocidadeDaConexao() {
		return this.velocidadeDaConexao;
	}

	public boolean getConectada() {
		return this.conectada;
	}

	public void conectar() {
		if (conectada) {
			System.out.printf("A rede %s já está conectada.\n", this.getNome());
		} else {
			this.conectada = true;
			this.velocidadeDaConexao = Math.random() * 100;
		}
	}

	public void reconectar() {

		if (!conectada) {
			System.out.printf("A rede %s não está conectada.", this.getNome());
		} else {
			this.velocidadeDaConexao = Math.random() * 100;
		}
	}

	public void desconectar() {
		if (conectada) {
			this.conectada = false;
			this.velocidadeDaConexao = 0;
		} else {
			System.out.printf("A rede %s n]ao está conectada.\n", this.getNome());
		}
	}
}
