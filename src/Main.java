import renderer.*;
import shape.*;

public class Main {
    private static int passedCount = 0;
    private static final int TOTAL_CHECKS = 7;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Use --demo flag to run automated evaluation checks.");
        }
    }

    private static void runDemo() {
        Renderer vRenderer = new VectorRenderer();
        Renderer rRenderer = new RasterRenderer();
        Renderer aRenderer = new AsciiRenderer();

        // T1: A1 with I1
        Circle c1 = new Circle("SHAPE-C1", 2.0, vRenderer);
        checkEquals("T1", "Circle + VectorRenderer", "VECTOR circle radius=2", c1.execute());

        // T2: A1 with I2
        Circle c2 = new Circle("SHAPE-C1", 2.0, rRenderer);
        checkEquals("T2", "Circle + RasterRenderer", "RASTER circle pixels=20", c2.execute());

        // T3: A2 with I1
        Square s1 = new Square("SHAPE-S1", 3.0, vRenderer);
        checkEquals("T3", "Square + VectorRenderer", "VECTOR square side=3", s1.execute());

        // T4: A2 with I2
        Square s2 = new Square("SHAPE-S1", 3.0, rRenderer);
        checkEquals("T4", "Square + RasterRenderer", "RASTER square side=30", s2.execute());

        // T5: Runtime switch on single instance
        Circle switchCircle = new Circle("SHAPE-SW-1", 2.0, vRenderer);
        String beforeResult = switchCircle.execute();
        Circle refBefore = switchCircle;
        String idBefore = switchCircle.getId();
        double radiusBefore = switchCircle.getRadius();

        switchCircle.setImplementation(rRenderer);
        Circle refAfter = switchCircle;
        String afterResult = switchCircle.execute();

        boolean sameObject = (refBefore == refAfter);
        boolean stateUnchanged = idBefore.equals(switchCircle.getId()) && (radiusBefore == switchCircle.getRadius());
        boolean behaviorChanged = beforeResult.equals("VECTOR circle radius=2") && afterResult.equals("RASTER circle pixels=20");

        if (sameObject && stateUnchanged && behaviorChanged) {
            passedCount++;
            System.out.printf("T5 PASS sameObject=%b | stateUnchanged=%b%nbefore=%s | after=%s%n",
                    sameObject, stateUnchanged, beforeResult, afterResult);
        } else {
            System.out.printf("T5 FAIL sameObject=%b | stateUnchanged=%b%nbefore=%s | after=%s%n",
                    sameObject, stateUnchanged, beforeResult, afterResult);
        }

        // T6: A1 with I3 (AsciiRenderer)
        Circle c3 = new Circle("SHAPE-C1", 2.0, aRenderer);
        checkEquals("T6", "Circle + AsciiRenderer", "ASCII [O] circle r=2", c3.execute());

        // T7: A2 with I3 (AsciiRenderer)
        Square s3 = new Square("SHAPE-S1", 3.0, aRenderer);
        checkEquals("T7", "Square + AsciiRenderer", "ASCII [#] square s=3", s3.execute());

        System.out.printf("SUMMARY: %d/%d PASS%n", passedCount, TOTAL_CHECKS);
    }

    private static void checkEquals(String testId, String context, String expected, String actual) {
        if (expected.equals(actual)) {
            passedCount++;
            System.out.printf("%s PASS | %s | result=%s%n", testId, context, actual);
        } else {
            System.out.printf("%s FAIL | %s | expected='%s' but got='%s'%n", testId, context, expected, actual);
        }
    }
}