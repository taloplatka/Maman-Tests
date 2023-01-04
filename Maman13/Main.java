import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().test();
    }

    private void showIntroduction() {
        System.out.println("This class provides unit tests for Maman 13 and is provided AS IS");
        System.out.println("I don't guarantee this program will catch all bugs, exceptions and errors");
        System.out.println("I, the program author, don't take any responsibility for the grades you receive!!");
        System.out.println("Note that the program doesn't exit when an runtime error occurs, instead, it prints it to the console");
    }

    private void logTest(String testDescription) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Test: " + testDescription);
    }

    private void logSuccess() {
        System.out.println("Test Passed! 🔥🔥🔥");
    }

    private void logFailure(String reason) {

        System.out.println("Test Failed ⚠️⚠️⚠️ !!! Here is the reason: " + reason);
    }

    private void logError(Exception e) {
        System.out.println("An Error Occurred ⛔⛔⛔⛔!!!!!. Here is the error: " + e.getCause());
    }

    private <T> void assertEquals(T expected, T value) {
        if (value.equals(expected)) {
            logSuccess();
        } else {
            logFailure("Expected: " + expected + " Got: " + value);
        }
    }

    private void testAlternatingWithInput(String input, int expected) {
        logTest("Testing alternating method on the input " + input + " Expecting " + expected);

        try {
            assertEquals(expected, Ex13.alternating(input));
        }
        catch (Exception e) {
            logError(e);
        }
    }

    private void testWhatWithInput(int[] input, int expected) {
        StringBuilder inputString = new StringBuilder();

        for (int i : input) {
            inputString.append(i).append(" ");
        }

        logTest("Testing what method on the input " + inputString + " Expecting " + expected);

        try {
            assertEquals(expected, Ex13.what(input));
        }
        catch (Exception e) {
            logError(e);
        }
    }

    private void testIsWayWithInput(int[] input, boolean expected) {
        StringBuilder numbers = new StringBuilder();

        for (int i : input) {
            numbers.append(i).append(" ");
        }

        logTest("Testing isWay method on the array: " + numbers + " Expecting: " + expected);

        try {
            assertEquals(expected, Ex13.isWay(input));
        }
        catch (Exception e) {
            logError(e);
        }
    }

    private void testPrinceWithInput(int[][] input, int initRow, int initColumn, int expected) {
        StringBuilder matrixDisplay = new StringBuilder();

        for (int[] row : input) {
            for (int number : row) {
                matrixDisplay.append(number).append(" ");
            }
            matrixDisplay.append("\n");
        }

        logTest("Testing prince method with the input i = " + initRow + " & j = " + initColumn + " drm = \n" +
                matrixDisplay + "Expecting " + expected);

        try {
            assertEquals(expected, Ex13.prince(input, initRow, initColumn));
        }
        catch (Exception e) {
            logError(e);
        }
    }

    private void testIfPrinceChangesTheInputWithInput(int[][] input, int i, int j) {
        StringBuilder matrixDisplay = new StringBuilder();

        for (int[] row : input) {
            for (int number : row) {
                matrixDisplay.append(number).append(" ");
            }
            matrixDisplay.append("\n");
        }

        logTest("Testing if array stays the same after the execution of prince" +
                "i = " + i + " j = " + j + " drm = \n" + matrixDisplay);

        int[][] clone = input.clone();

        try {
            Ex13.prince(input, i, j);
        }
        catch (Exception e) {
            logError(e);
        }

        if (Arrays.deepEquals(input, clone)) {
            logSuccess();
        }
        else {
            logFailure("The prince method changed the input");
        }
    }

    private void testAlternating() {
        testAlternatingWithInput("00011011", 2);
        testAlternatingWithInput("0011", 1);
        testAlternatingWithInput("10", 0);
        testAlternatingWithInput("00101011", 1);
        testAlternatingWithInput("00100111", 2);
        testAlternatingWithInput("01010101", 0);
        testAlternatingWithInput("110000111100", 3);
        testAlternatingWithInput("01101010", 1);
    }

    private void testWhat() {
        testWhatWithInput(new int[]{2, 1, 2, 2, 2, 1, 2}, 7);
        testWhatWithInput(new int[]{1, 5, 1, 10}, 3);
        testWhatWithInput(new int[]{1}, 0);
        testWhatWithInput(new int[]{2}, 1);
        testWhatWithInput(new int[]{-1, -2, 10, -16}, 3);
    }

    private void testIsWay() {
        testIsWayWithInput(new int[]{1, 3, 4, 5, 1, 2}, true);
        testIsWayWithInput(new int[]{7, 4, 2, 5, 1, 9, 15, 5, 10}, true);
        testIsWayWithInput(new int[]{1, 1, 1, 1, 1, 1}, true);
        testIsWayWithInput(new int[]{2, 4, 1, 6, 4, 2, 4, 3, 5}, true);
        testIsWayWithInput(new int[]{1, 2, 3, 4, 5, 2, 1, 3, 1, 2}, true);
        testIsWayWithInput(new int[]{7, 3, 1, 2, 3, 10, 9, 3, 1}, false);
        testIsWayWithInput(new int[]{5, 1, 3}, false);
        testIsWayWithInput(new int[]{1, 2, 3, 4, 5, 6, 7}, false);
    }

    private void testPrince() {
        int[][] a = {
                {2, 6, 3, 1},
                {1, 2, -1, 1},
                {2, 4, 0, 10},
                {0, 3, 4, 5}
        };

        testPrinceWithInput(a, 0, 0, 4);
        testPrinceWithInput(a, 1, 2, 1);
        testPrinceWithInput(a, 3, 2, 5);
        testPrinceWithInput(a, 2, 3, -1);

        int[][] b = {
                {4, 2, 3},
                {5, 9, -1},
                {6, 7, 8}
        };

        testPrinceWithInput(b,0, 1, 3);
        testPrinceWithInput(b, 0, 0, 4);

        int[][] c = {
                {0, 1, 7, 5, 4},
                {1, -1, 1, 3, 3},
                {9, 0, 1, 4, 5},
                {5, 1, 10, 9, 4},
                {0, 0, 0, 0, 0}
        };

        testPrinceWithInput(c, 2, 4, 5);
        testPrinceWithInput(c, 4, 4, 7);
        testPrinceWithInput(c, 3, 2, -1);

    }

    private void testPrinceChangingMatrix() {
        int[][] a = {
                {2, 6, 3, 1},
                {1, 2, -1, 1},
                {2, 4, 0, 10},
                {0, 3, 4, 5}
        };

        testIfPrinceChangesTheInputWithInput(a, 0, 1);
        testIfPrinceChangesTheInputWithInput(a, 2, 3);

    }

    public void test() {
        showIntroduction();
        System.out.println();
        testAlternating();
        System.out.println("The program will now test isWay. It won't check if the array stays intact " +
                "when the method stops executing\n");
        testIsWay();
        testWhat();
        testPrince();
        testPrinceChangingMatrix();
    }
}
