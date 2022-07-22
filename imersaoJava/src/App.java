import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // extrator IMDB
        // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies"; // conexão com a API
        // ExtratorDeConteudo extrator = new ExtatorConteudoIMDB();

        // extrator Nasa
        // String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; // conexão com a API
        // ExtratorDeConteudo extrator = new ExtratorConteudoDaNasa();

        // extrator api linguagens
        String url = "http://localhost:8080/linguagens"; // conexão com a API
        ExtratorDeConteudo extrator = new ExtatorConteudoIMDB();
        

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        System.out.println(json);

        List<conteudo> conteudos = extrator.extraiConteudo(json);

        var geradora = new GeradorDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "src/img/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
        // exibir e manipular os dados

    }
}
