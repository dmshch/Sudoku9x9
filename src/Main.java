import java.util.HashSet;

public class Main {

    static final int sudokuArray[][] = new int[][] {
            {7, 1, 4, 8, 2, 5, 6, 3, 9},
            {8, 2, 5, 9, 3, 6, 7, 4, 1},
            {9, 3, 6, 1, 4, 7, 8, 5, 2},
            {5, 8, 2, 6, 9, 3, 4, 1, 7},
            {4, 7, 1, 5, 8, 2, 3, 9, 6},
            {6, 9, 3, 7, 1, 4, 5, 2, 8},
            {1, 4, 7, 2, 5, 8, 9, 6, 3},
            {2, 5, 8, 3, 6, 9, 1, 7, 4},
            {3, 6, 9, 4, 7, 1, 2, 8, 5},
    };

    static boolean flag = true;

    public static void main(String[] args){

        int[][] workArray = sudokuArray;

        // запуск проверки корректности решения
        flag = check(workArray);

        // проверки пройдены
        if (flag){
            System.out.println("корректно");
        } else {
            System.out.println("некорректно");
        }
    }

    // проверка на уникальность по строкам, столбцам и для внутренних квадратов 3х3
    public static boolean check(int[][] workArray){

        // по строкам
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++){
                int temp = workArray[i][j];
                for (int n=j+1; n<9; n++){
                    if (temp == workArray[i][n]) return false;
                }
            }
        }

        // по столбцам
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++){
                int temp = workArray[j][i];
                for (int n=j+1; n<9; n++){
                    if (temp == workArray[n][i]) return false;
                }
            }
        }

        // внутри квадратов 3х3
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
