import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InvertImageBatch {

    public static void main(String[] args) {
        File folder = new File("C:\\Users\\fl\\Desktop\\java\\java_test\\test\\src\\image");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg"));

        if (files == null || files.length == 0) {
            System.out.println("文件夹中没有图片文件.");
            return;
        }

        for (File file : files) {
            try {
                // 读取原始图像
                BufferedImage originalImage = ImageIO.read(file);
                BufferedImage invertedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

                // 反转图像颜色
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

                // 保存反转后的图像
                String outputFileName = "inverted_" + file.getName();
                File outputFile = new File(folder, outputFileName);
                ImageIO.write(invertedImage, "jpg", outputFile);
                System.out.println("图片反显成功: " + outputFileName);

            } catch (IOException e) {
                System.err.println("处理图片失败: " + file.getName() + " - " + e.getMessage());
            }
        }
    }
}
