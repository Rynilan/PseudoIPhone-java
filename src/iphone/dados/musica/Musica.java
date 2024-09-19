package iphone.dados.musica;

public class Musica {
	/** Class to hold info about the pseudo music file. */

	private String titulo;
	private String artista;
	private double duracao;

	public Musica(String titulo, String artista, double duracao) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracao = duracao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getArtista() {
		return this.artista;
	}

	public double getDuracao() {
		return this.duracao;
	}
}
