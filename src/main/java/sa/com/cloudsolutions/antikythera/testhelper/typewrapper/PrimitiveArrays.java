package sa.com.cloudsolutions.antikythera.testhelper.typewrapper;

/**
 * Test fixture for primitive type and array resolution testing.
 * Used by TypeWrapper migration Phase 0 tests.
 *
 * Key test scenarios:
 * - Primitive fields (int, boolean, etc.)
 * - Primitive arrays (int[], boolean[])
 * - Multi-dimensional arrays (int[][], String[][][])
 * - Boxed type arrays (Integer[], Boolean[])
 * - Mixed primitive and object arrays
 */
public class PrimitiveArrays {

    // Primitive fields
    private int intField;
    private boolean booleanField;
    private byte byteField;
    private short shortField;
    private long longField;
    private float floatField;
    private double doubleField;
    private char charField;

    // Primitive arrays
    private int[] intArray;
    private boolean[] booleanArray;
    private byte[] byteArray;
    private short[] shortArray;
    private long[] longArray;
    private float[] floatArray;
    private double[] doubleArray;
    private char[] charArray;

    // Multi-dimensional primitive arrays
    private int[][] intMatrix;
    private int[][][] intCube;
    private double[][] doubleMatrix;
    private boolean[][] booleanMatrix;

    // Boxed type arrays
    private Integer[] integerArray;
    private Boolean[] booleanWrapperArray;
    private Long[] longWrapperArray;

    // Object arrays
    private String[] stringArray;
    private String[][] stringMatrix;
    private Object[] objectArray;

    // Methods with primitive parameters
    public int sumInts(int a, int b) {
        return a + b;
    }

    public boolean and(boolean a, boolean b) {
        return a && b;
    }

    // Methods with primitive array parameters
    public int sumArray(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public double[][] transposeMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0) return new double[0][0];
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // Method returning primitive array
    public int[] createRange(int start, int end) {
        int[] result = new int[end - start];
        for (int i = 0; i < result.length; i++) {
            result[i] = start + i;
        }
        return result;
    }

    // Varargs (which is internally an array)
    public int sumVarargs(int... numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public String joinStrings(String... strings) {
        return String.join(", ", strings);
    }

    // Getters and setters
    public int getIntField() { return intField; }
    public void setIntField(int intField) { this.intField = intField; }
    public boolean isBooleanField() { return booleanField; }
    public void setBooleanField(boolean booleanField) { this.booleanField = booleanField; }
    public int[] getIntArray() { return intArray; }
    public void setIntArray(int[] intArray) { this.intArray = intArray; }
    public int[][] getIntMatrix() { return intMatrix; }
    public void setIntMatrix(int[][] intMatrix) { this.intMatrix = intMatrix; }
    public String[] getStringArray() { return stringArray; }
    public void setStringArray(String[] stringArray) { this.stringArray = stringArray; }
}
