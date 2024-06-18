package SingleDimensionArray;

public class Main {
    public static void main(String[] args) {
        SingleDimensionArray singleDimensionArray = new SingleDimensionArray(10);

        singleDimensionArray.insert(0,0);
        singleDimensionArray.insert(1, 10);
        singleDimensionArray.insert(2, 20);
        singleDimensionArray.insert(1, 30);
        singleDimensionArray.insert(12, 120);
    }
}
