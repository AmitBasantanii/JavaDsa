package SingleDimensionArray;

public class SingleDimensionArray {
    int arr[] = null;
    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    // insertion of elements in the array
    public void insert (int location, int valueToBeInserted) {
        try {
            if(arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToBeInserted;
                System.out.println("Successfully Inserted");
            }
            else {
                System.out.println("This cell is already occupied");
            }
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid index to access array");
        }
    }

    // traversal of the array
    public void traverseArray() {
        try{
            for(int i=0; i<arr.length; i++) {
                System.out.print(arr[i] + "");
            }
        }
        catch (Exception exception) {
            System.out.println("Array no longer exists!");
        }
    }

    // search for the element in the array
    public void searchInArray(int valueToSearch) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == valueToSearch) {
                System.out.println("Value is found at Index : " + i);
                return;
            }
        }
        System.out.println(valueToSearch + "value is not found");
    }
}
