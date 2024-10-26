import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RestoreImage {

    public static void main(String[] args) {
        try {
            BufferedImage invertedImage = ImageIO.read(new File("C:\\Users\\fl\\Desktop\\java\\java_test\\test\\src\\image\\inverted_QQ图片20230419183033.jpg"));
            BufferedImage restoredImage = new BufferedImage(invertedImage.getWidth(), invertedImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < invertedImage.getWidth(); x++) {
                for (int y = 0; y < invertedImage.getHeight(); y++) {
                    int rgb = invertedImage.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;

                    int restoredR = 255 - r;
                    int restoredG = 255 - g;
                    int restoredB = 255 - b;

                    restoredImage.setRGB(x, y, (restoredR << 16) | (restoredG << 8) | restoredB);
                }
            }
            ImageIO.write(restoredImage, "jpg", new File("C:\\Users\\fl\\Desktop\\java\\java_test\\test\\src\\image\\inverted_QQ图片20230419183033.jpg"));
            System.out.println("图片恢复成功!");
        } catch (IOException e) {
            System.err.println("图片处理失败: " + e.getMessage());
        }
    }
}

