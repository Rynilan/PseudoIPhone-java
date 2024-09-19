package iphone.software.navegador;

public interface Navegador {
	public void iniciar();

	public void pesquisar(String prompt);

	default void entrarNoSite() {
		System.out.print("          \n   404 - NOT FOUND   \n          ");
	}
}
