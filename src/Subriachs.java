import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sources:
 * https://stackoverflow.com/questions/5162254/all-possible-combinations-of-an-array
 * https://www.geeksforgeeks.org/dsa/iterative-approach-to-print-all-combinations-of-an-array/
 * https://www.geeksforgeeks.org/dsa/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 * https://hmkcode.com/calculate-find-all-possible-combinations-of-an-array-using-java/
 * https://www.geeksforgeeks.org/dsa/all-unique-combinations-whose-sum-equals-to-k/
 */

public class Subriachs {
    int[] subriachs = {1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15};

    public void main() {
        ArrayList<Integer> total = new ArrayList<Integer>();
//        System.out.println(allFourCombos());
//        System.out.println(allThreeCombos());
//        System.out.println(all33(33));
        int count = 0;
        for (int i = 132; i >= 0; i--) {
            System.out.println(all33(i));
            count += all33(i);
        }
        System.out.println("count: " + count);
    }

    int allFourCombos() {
        int counter = 0;
        for (int i = 0; i < subriachs.length; i++) {
            for (int j = i + 1; j < subriachs.length; j++) {
                for (int k = j + 1; k < subriachs.length; k++) {
                    for (int l = k + 1; l < subriachs.length; l++) {
                        if (subriachs[i] + subriachs[j] + subriachs[k] + subriachs[l] == 33) {
                            // System.out.println(subriachs[i]+" " + subriachs[j]+" "+ subriachs[k]+" " +subriachs[l]);
                            counter++;
                        }
                    }

                }
            }
        }
        return counter;

    }

    int allThreeCombos() //there is no 2 because no two numbers add up to 3
    {
        int counter = 0;
        for (int i = 0; i < subriachs.length; i++) {
            for (int j = 0; j < subriachs.length; j++) {
                for (int k = 0; k < subriachs.length; k++) {

                    if (subriachs[i] + subriachs[j] + subriachs[k] == 33 && i != j && i != k && j != k) {
                        System.out.println(subriachs[i] + " " + subriachs[j] + " " + subriachs[k]);
                        counter++;
                    }


                }
            }
        }
        return counter;

    }

    int all33(int thirtythree) {
        int[] solution = new int[thirtythree + 1];
        solution[0] = 1;

        for (int i : subriachs) {
            for (int j = thirtythree; j >= i; j--) {
                solution[j] += solution[j - i];
            }
        }
        return solution[thirtythree];
    }
}