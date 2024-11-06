import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageBlackAndWhite2 {
    public static void main(String[] args) {
        try {
            File folder = new File("src\\image");  // 输入文件夹路径
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg"));

            for (File inputFile : files) {
                if (inputFile.isFile()) {
                    BufferedImage image = ImageIO.read(inputFile);
                    
                    for (int y = 0; y < image.getHeight(); y++) {
                        for (int x = 0; x < image.getWidth(); x++) {
                            int p = image.getRGB(x, y);
                            int a = (p >> 24) & 0xff;
                            int r = (p >> 16) & 0xff;
                            int g = (p >> 8) & 0xff;
                            int b = p & 0xff;

                            int avg = (int) (0.299 * r + 0.587 * g + 0.114 * b);
                            p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                            image.setRGB(x, y, p);
                        }
                    }
                    
                    File outputFolder = new File("blackwhite_images");
                    if (!outputFolder.exists()) {
                        outputFolder.mkdirs();
                    }
                    
                    File outputFile = new File(outputFolder, "bw_" + inputFile.getName());
                    ImageIO.write(image, "jpg", outputFile);
                    System.out.println("Processed " + inputFile.getName());
                }
            }
            System.out.println("All images processed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
