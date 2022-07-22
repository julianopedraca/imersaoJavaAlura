import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivoString) throws IOException {
        // leitura da imagem
        // InputStream inputStream = new URL(
        // "https://m.media-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg")
        // .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // crianova imagem em memória com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 50;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);



        //// configurar a fonte e setar cor aleatoria para o texto
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();    
        
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        graphics.setColor(new Color(r, g, b));
        graphics.setFont(fonte);

        // array de string para frase
        ArrayList<String> texto = new ArrayList<String>(Arrays.asList(
            "TOPZERA",
            "JUBALINDO",
            "BATAATA"));

       

        // criar um numero aleatorio de 0 a 2
        int select = new Random().nextInt(3);

        // escrever uma mensagem na nova imagem
        graphics.drawString(texto.get(select), 0, novaAltura - 15);

        // copiar a imagem original para novo imagem (em memória)
        ImageIO.write(novaImagem, "png", new File(nomeArquivoString));
    }
}