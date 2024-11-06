// import java.awt.image.BufferedImage;
// import java.io.File;
// import javax.imageio.ImageIO;

// public class ImageBlackAndwhite {

//     public static void main(String[] args) {
//         try {
//             File input = new File("input.jpg");
//             BufferedImage image = ImageIO.read(input);

//             for (int y = 0; y < image.getHeight(); y++) {
//                 for (int x = 0; x < image.getWidth(); x++) {
//                     int p = image.getRGB(x, y);

//                     int a = (p >> 24) & 0xff;
//                     int r = (p >> 16) & 0xff;
//                     int g = (p >> 8) & 0xff;
//                     int b = p & 0xff;

//                     int avg = (int) (0.299 * r + 0.587 * g + 0.114 * b);

//                     p = (a << 24) | (avg << 16) | (avg << 8) | avg;

//                     image.setRGB(x, y, p);
//                 }
//             }

//             File output = new File("output.jpg");
//             ImageIO.write(image, "jpg", output);

//             System.out.println("Image converted to black and white successfully.");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class ImageBlackAndwhite {
    public static void main(String[] args) {
        try {
            File input = new File("src\\image\\output\\inverted_inverted_up53.png");
            BufferedImage image = ImageIO.read(input);
            for (int y = 0;y<image.getHeight();y++) {
                for (int x= 0;x < image.getWidth();x++) {
                    int p = image.getRGB(x, y);

                    int a = (p>>24) & 0Xff;
                    int r = (p>>16) & 0Xff;
                    int g = (p>>8)  & 0Xff;
                    int b = p & 0xff;

                    // int avg = (int) (0.299 * r + 0.587 *g + 0.114 *b);
                    int avg = (int) (0.299 * r + 0.587 * g + 0.114 * b);
                    p = (a <<24 ) | (avg << 16) | (avg << 8) | avg;
                    image.setRGB(x, y, p);

                }

            }
            File output = new File("output.jpg");
            ImageIO.write(image, "jpg", output);
            System.out.println("Image sueccful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}