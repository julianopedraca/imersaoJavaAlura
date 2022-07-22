import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtatorConteudoIMDB implements ExtratorDeConteudo{
    public List<conteudo> extraiConteudo(String json) {

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            var conteudo = new conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }
        
        return conteudos;
    }
}