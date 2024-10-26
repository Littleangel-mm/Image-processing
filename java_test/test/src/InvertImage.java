
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InvertImage {

    public static void main(String[] args) {
        try {
            BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\fl\\Desktop\\java\\java_test\\test\\src\\image\\up111.png"));
            BufferedImage invertedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < originalImage.getWidth(); x++) {
                for (int y = 0; y < originalImage.getHeight(); y++) {
                    int rgb = originalImage.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;

                    int invertedR = 255 - r;
                    int invertedG = 255 - g;
                    int invertedB = 255 - b;

                    invertedImage.setRGB(x, y, (invertedR << 16) | (invertedG << 8) | invertedB);
                }
            }
            ImageIO.write(invertedImage, "jpg", new File("C:\\Users\\fl\\Desktop\\java\\java_test\\test\\src\\image\\sese.jpg"));
            System.out.println("图片反显成功!");
        } catch (IOException e) {
            System.err.println("图片处理失败: " + e.getMessage());
        }
    }
}






