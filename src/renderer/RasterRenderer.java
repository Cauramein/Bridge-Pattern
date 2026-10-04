package renderer;

public class RasterRenderer implements Renderer {
    @Override
    public String renderCircle(double radius) {
        return "RASTER circle pixels=" + (int) (radius * 10);
    }

    @Override
    public String renderSquare(double side) {
        return "RASTER square pixels=" + (int) (side * 10);
    }
}