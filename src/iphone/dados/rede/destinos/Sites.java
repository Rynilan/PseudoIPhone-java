package iphone.dados.rede.destinos;

/**
 * Enum to hold the sites as result of the search on the browser (any).
 */
public enum Sites {
	CLICKBAIT1("Fofoca todo dia", "A verdade sobre %s finalmente vem à tona! Depois de anos de especulação, especialistas revelam informações que vão deixar você sem palavras. Não perca a chance de entender como %s pode afetar suas escolhas. Prepare-se para uma jornada reveladora que vai transformar sua perspectiva sobre %s!"),
	CLICKBAIT2("Bomba do Dia", "Você não vai acreditar no que descobriram sobre %s! Esse segredo surpreendente pode mudar a sua vida para sempre. Se você sempre se perguntou como %s pode impactar o seu dia a dia, continue lendo. As revelações a seguir são chocantes e vão fazer você repensar tudo o que sabe sobre %s!"),
	CLICKBAIT3("Um dia um fato", "Você sabia que %s esconde um mistério incrível? Descubra o que as pessoas estão dizendo sobre %s e como isso pode impactar sua vida. As informações que foram reveladas são tão surpreendentes que você vai querer compartilhar com todos. Não fique de fora e conheça a verdade sobre %s agora mesmo!"),
	CIENCIA1("Profº Zé Chaves", "O estudo recente sobre %s revela insights importantes sobre seu impacto na sociedade. A pesquisa utilizou métodos rigorosos para analisar dados e chegou a conclusões que podem transformar nossa compreensão de %s. Os resultados sugerem novas direções para investigações futuras e podem influenciar políticas públicas."),
	CIENCIA2("Especialista Maria Ofélia", "A pesquisa em torno de %s tem avançado significativamente nos últimos anos. Utilizando métodos científicos, os pesquisadores examinaram diversos fatores que influenciam %s. Esses estudos ajudam a esclarecer questões complexas e podem oferecer soluções inovadoras para os desafios associados a %s."),
	FAMOSOS("Opinião de Famosos", "Recentemente, %s se envolveu em uma polêmica que deixou muitos fãs divididos. Enquanto alguns apoiam suas decisões, outros questionam as verdadeiras intenções por trás de %s. Essa discussão acirrada só demonstra o poder que a figura de %s exerce na cultura contemporânea e a atenção que atrai em cada movimento."),
	WIKIPEDIA("WikiPedia", "%s é um termo que abrange diversas áreas de estudo e interesse. A importância de %s se reflete em sua presença na vida cotidiana e em várias disciplinas. Pesquisas sobre %s ajudam a compreender suas implicações e impacto na sociedade, além de contribuir para o avanço do conhecimento sobre o tema."),
	CHATGPT("Chat GPT lite minimum", "A partir do momento em que %s dança com as nuvens, podemos observar como %s se entrelaça nas conversas das estrelas. Quando %s sorri para a montanha, as flores cantam em harmonia, revelando segredos do universo. Assim, o ciclo continua, iluminando os caminhos de quem busca entender o mistério da vida."),
	YOUTUBE("YouTube", "");

	private final String titulo;
	private final String leroLeroPadrao = String.format(" - - - - - - - - - - -\n%12s\n - - - - - - - - - - -\n", " = 404 Not found :( = ");
	private final String leroLeroLegal;
	private final String endereco;

	private Sites(String titulo, String leroLero) {
		this.titulo = titulo;
		this.endereco = String.format("https://www.%s.com.br/", titulo.toLowerCase().replaceAll(" ", "_"));
		this.leroLeroLegal = String.format(" - %29s - \n\n%s", this.titulo, this.formatador(leroLero, 35));
	}
	
	private String formatador(String texto, int intervalo) {
		if (texto.length() <= intervalo) {
			return texto;
		}
		int inicio = 0;
		int fim = intervalo;
		String formatado = "";
		while (inicio < fim) {
			formatado += texto.substring(inicio, fim) + "\n";
			inicio = fim;
			fim = fim + intervalo < texto.length() ? fim + intervalo: texto.length();
		}
		return formatado;
	}

	public void abrirSite(String pesquisa) {
		if (this.titulo != "" && !(this.titulo == "YouTube")) {
			System.out.printf(this.leroLeroLegal, pesquisa, pesquisa, pesquisa);
		} else {
			System.out.printf(this.leroLeroPadrao);
		}
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getEndereco() {
		return this.endereco;
	}
}
