package shape;

import renderer.Renderer;
import java.util.Objects;

public abstract class Shape {
    private final String id;
    protected Renderer renderer;

    protected Shape(String id, Renderer renderer) {
        this.id = Objects.requireNonNull(id, "ID cannot be null");
        this.renderer = Objects.requireNonNull(renderer, "Renderer cannot be null");
    }

    public String getId() {
        return id;
    }

    public void setImplementation(Renderer renderer) {
        this.renderer = Objects.requireNonNull(renderer, "Renderer cannot be null");
    }

    public abstract String execute();
}