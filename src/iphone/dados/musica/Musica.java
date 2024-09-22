package iphone.dados.musica;

/**
 * Class to hold info about the pseudo music file. 
 */
public class Musica {

	/** The music 'name'. */
	private String titulo;
	/** The creator of the music. */
	private String artista;
	/** How much the music last for, in seconds. */
	private double duracao;

	public Musica(String titulo, String artista, double duracao) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracao = duracao;
	}
	
	/** @return the music title. */
	public String getTitulo() {
		return this.titulo;
	}

	/** @return the creator of the music. */
	public String getArtista() {
		return this.artista;
	}

	/** @return the music duration of the music, in seconds. */
	public double getDuracao() {
		return this.duracao;
	}
}
