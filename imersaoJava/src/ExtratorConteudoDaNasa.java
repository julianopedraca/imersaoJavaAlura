import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoDaNasa implements ExtratorDeConteudo{
    public List<conteudo> extraiConteudo(String json) {
        // extrair só os dados que interessam (titulo, poster, classificação) | parsear
        // os dados é a extração dos dados da api para o código | parsear o texto
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }
        
        return conteudos;
    }
}
