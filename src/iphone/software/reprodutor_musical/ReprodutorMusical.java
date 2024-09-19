package iphone.software.reprodutor_musical;

public interface ReprodutorMusical {
	public void iniciar();

	public void reproduzir(int indice);

	public void parar();

	public void verTodasAsMusicas();

	public void informacoes(int indice);

	public String getNome();
}
