import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    static final int sudokuArray[][] = new int[9][9];

    static boolean flag = true;

    static final int errorInLineAndColumn[][] = new int[][] {
            {7, 1, 4, 8, 2, 5, 6, 9, 3},
            {8, 2, 5, 9, 3, 6, 7, 1, 4},
            {9, 3, 6, 1, 4, 7, 8, 2, 5},
            {2, 5, 8, 3, 6, 9, 1, 4, 7},
            {1, 4, 7, 2, 5, 8, 9, 3, 6},
            {3, 6, 9, 4, 7, 1, 2, 5, 8},
            {5, 8, 2, 6, 9, 3, 4, 7, 1},
            {4, 7, 1, 5, 8, 2, 3, 6, 9}, // повторение 2-ки
            {6, 9, 3, 7, 1, 2, 5, 8, 2},
    };

    static final int rightSquare[][] = new int[][] {
            {7, 1, 4, 8, 2, 5, 6, 9, 3},
            {8, 2, 5, 9, 3, 6, 7, 1, 4},
            {9, 3, 6, 1, 4, 7, 8, 2, 5},
            {2, 5, 8, 3, 6, 9, 1, 4, 7},
            {1, 4, 7, 2, 5, 8, 9, 3, 6},
            {3, 6, 9, 4, 7, 1, 2, 5, 8},
            {5, 8, 2, 6, 9, 3, 4, 7, 1},
            {4, 7, 1, 5, 8, 2, 3, 6, 9},
            {6, 9, 3, 7, 1, 4, 5, 8, 2},
    };

    public static void main(String[] args){

        int[][] workArray = errorInLineAndColumn;


        // первая проверка на уникальность по строкам столбцам
        flag = checkInLineAndRow(workArray);

        // вторая проверка на уникальность во внутренних квадратах 3х3
        flag = checkInSquare(workArray);

        // проверки пройдены
        if (flag){
            System.out.println("корректно");
        } else {
            System.out.println("некорректно");
        }
    }

    public static boolean checkInLineAndRow(int[][] workArray){
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++){
                int temp = workArray[i][j];
                for (int n=j+1; n<9; n++){
                    if (temp == workArray[i][n]){
                        return false;
                    }
                }
            }
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++){
                int temp = workArray[j][i];
                for (int n=j+1; n<9; n++){
                    if (temp == workArray[n][i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static boolean checkInSquare(int[][] workArray){
        HashSet<Integer> forCheck = new HashSet<Integer>();
        for (int i=0; i<9; i+=3){
            for (int j=0;j<9; j+=3){
                forCheck.clear();
                for (int m=i;m<i+3;m++){
                    for (int n=j;n<j+3;n++){
                        if (!forCheck.add(workArray[m][n])) return false;
                    }
                }
            }
        }
        return true;
    }

}
