package TwoDimensionalArray;

public class TwoDimensionalArray {
    int arr[][] = null;

    // constructor
    public TwoDimensionalArray(int numberOfRows , int numberOfColumns) {
        this.arr = new int[numberOfRows][numberOfColumns];
        for(int row = 0; row<arr.length; row++) {
            for(int col=0; col<arr[0].length; col++) {
                arr[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    // Inserting value in Array
    public void insertValueInTheArray(int row, int col, int value) {
        try {
            if(arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = value;
                System.out.println("The value is successfully inserted");
            }
            else {
                System.out.println("This cell is already occupied");
            }
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid index for 2D array");
        }
    }

    // Accessing cell value from the given array
    public void accessCell(int row, int col) {
        System.out.println("\n Accessing Row #" + row + ", Col #" + col);
        try {
            System.out.println("Cell value is :" + arr[row][col]);
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid index for 2D Array");
        }
    }

    // Traverse 2D Array
    public void traverse2DArray() {
        for (int row=0; row<arr.length; row++) {
            for(int col=0; col<arr[0].length; col++) {
                System.out.println(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Searching 2D Array
    public void searchingValues(int value) {
        for(int row=0; row<arr.length; row++) {
            for(int col=0; col<arr[0].length; col++) {
                if(arr[row][col] == value) {
                    System.out.println("Value is found at row : " + row + "Col : " + col);
                    return;
                }
            }
        }
        System.out.println("Value is not found");
    }

    // Deleting a value from the array
    public void deleteValueFromArray(int row, int col) {
        try {
            System.out.println("Successfully deleted : " + arr[row][col]);
            arr[row][col] = Integer.MIN_VALUE;
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("This index is not valid for the array");
        }
    }
}
