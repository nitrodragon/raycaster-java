import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Texture {
    int[] pixels;
    private String loc;
    final int SIZE;

    private Texture(String location, int size) {
        loc = location;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(new File(loc));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Texture wood = new Texture("res/w.png", 64);
    static Texture brick = new Texture("res/redbrick.png", 64);
    static Texture bluestone = new Texture("res/bluestone.png", 64);
    static Texture stone = new Texture("res/greystone.png", 64);
}
