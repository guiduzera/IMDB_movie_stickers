package com.guilherme;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class StickerMaker {
    public void initializer(List<Map<String, String>> apiResponse, int position, String nomeArquivo, String text)
            throws MalformedURLException, IOException {
        for (Map<String, String> movie : apiResponse) {
            if (position == 0) {
                break;
            }
            String link = movie.get("image");
            InputStream parser = new URL(link).openStream();
            String nomeArquivoPng = nomeArquivo + ".png";
            makeSticker(parser, text, nomeArquivoPng);
            position--;
        }
    }

    public void makeSticker(InputStream path, String phrase, String arquivo) throws IOException {
        BufferedImage imagemOriginal = ImageIO.read(path);
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight() + 200;
        BufferedImage imageSticker = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);
        imageSticker.getGraphics().drawImage(imagemOriginal, 0, 0, null);
        Font textfont = new Font("Arial", Font.BOLD, 100);
        Graphics graphics = imageSticker.getGraphics();
        graphics.setFont(textfont);
        graphics.setColor(java.awt.Color.YELLOW);
        int centerWidthWithText = (largura - graphics.getFontMetrics().stringWidth(phrase)) / 2;
        int centerHeightWithText = altura - 60;
        graphics.drawString(phrase, centerWidthWithText, centerHeightWithText);
        File outPut = new File("src/main/resources/" + arquivo);
        if (!outPut.exists()) {
            outPut.mkdirs();
        }
        ImageIO.write(imageSticker, "png", outPut);
    }
}
