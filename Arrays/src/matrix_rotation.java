import java.util.Arrays;


//i have a logic like :
//        for i =0 to n
//temp = top[i]
//top[i] = left[i]
//left[i] = bottom[i]
//bottom[i] = right[i]
//right[i] = temp;

public class matrix_rotation {
    public static void main(String[] args) {
        matrix_rotation main = new matrix_rotation();
        int[][] matrix = {{1,2,3} , {4,5,6}, {7,8,9}};
        main.rotateMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public boolean rotateMatrix (int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;

        for(int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n-1-layer;

            for(int i=first; i<last; i++) {
                int offset = i -first;
                int top = matrix[first][i];

                // move left element to top
                matrix[first][i] = matrix[last-offset][first];

                // moving bottom element to left
                matrix[last-offset][first] = matrix[last][last-offset];

                // moving right element to bottom
                matrix[last][last-offset] = matrix[i][last];

                // move top element to right
                matrix[i][last] = top;
            }
        }
        return true;
    }
}
