package renderer;

public class AsciiRenderer implements Renderer {
    @Override
    public String renderCircle(double radius) {
        return "ASCII [O] circle r=" + (int) radius;
    }

    @Override
    public String renderSquare(double side) {
        return "ASCII [#] square s=" + (int) side;
    }
}