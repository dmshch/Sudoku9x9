import java.util.Random;

public class Main {

    static final Integer m[][] = new Integer[9][9];

    public static void main(String[] args){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                m[i][j] = new Random().nextInt(10);
            }
        }

        for (int i = 0; i < 9; i++){
            System.out.println(" ");
            for (int j =0; j<9; j++){
                System.out.print(m[i][j] + " ");
            }
        }

    }
}
