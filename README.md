# Assignment 3: Bridge Design Pattern
- **Student:** Shyngys Zaikenov
- **Group:** SE-2523
- **Topic:** Option A (Drawing Hierarchy)
- **Repository URL:** https://github.com/Cauramein/assignment3-bridge
- **Base Commit Hash:** f09b9278d14c4e3859c0736ef993b642bd9561f1

## Role Map

| Role | Class / Interface | File Path |
| :--- | :--- | :--- |
| **Client** | `Main` | `src/Main.java` |
| **Abstraction** | `Shape` | `src/shape/Shape.java` |
| **Refined Abstraction 1 (A1)** | `Circle` | `src/shape/Circle.java` |
| **Refined Abstraction 2 (A2)** | `Square` | `src/shape/Square.java` |
| **Implementor** | `Renderer` | `src/renderer/Renderer.java` |
| **Concrete Implementor 1 (I1)** | `VectorRenderer` | `src/renderer/VectorRenderer.java` |
| **Concrete Implementor 2 (I2)** | `RasterRenderer` | `src/renderer/RasterRenderer.java` |
| **Concrete Implementor 3 (I3)** | `AsciiRenderer` | `src/renderer/AsciiRenderer.java` |

- **Bridge Reference Field:** `protected Renderer renderer;` in `src/shape/Shape.java`
- **Execute Method:** `public abstract String execute();` in `src/shape/Shape.java`
- **Switch Method:** `public void setImplementation(Renderer renderer)` in `src/shape/Shape.java`
- **Runtime Switch Check:** `Main.java` line demonstrating test `T5`

## Standard Build & Run Commands

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo