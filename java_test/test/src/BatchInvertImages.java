import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BatchInvertImages {

    public static void main(String[] args) {
        String inputFolderPath = "C:\\Users\\fl\\Desktop\\java\\java_test\\test\\src\\image";
        String outputFolderPath = "C:\\Users\\fl\\Desktop\\java\\java_test\\test\\src\\image\\output";

        File inputFolder = new File(inputFolderPath);
        File outputFolder = new File(outputFolderPath);

        // 如果输出文件夹不存在，则创建
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }

        // 遍历输入文件夹中的所有文件
        File[] files = inputFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                // 检查是否为图片文件
                if (file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".png"))) {
                    try {
                        BufferedImage originalImage = ImageIO.read(file);
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

                        // 保存反转后的图片到输出文件夹
                        String outputFileName = "inverted_" + file.getName();
                        File outputFile = new File(outputFolder, outputFileName);
                        ImageIO.write(invertedImage, "jpg", outputFile);
                        System.out.println("图片反转成功: " + outputFileName);
                    } catch (IOException e) {
                        System.err.println("图片处理失败: " + file.getName() + " - " + e.getMessage());
                    }
                }
            }
        } else {
            System.err.println("输入文件夹不存在或没有文件.");
        }
    }
}


// 这是对文件夹进行操作

// 这是对文件夹进行操作，将文件夹里面的图片全部恢复