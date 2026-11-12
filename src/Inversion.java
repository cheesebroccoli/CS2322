import java.lang.classfile.instruction.ReturnInstruction;
import java.util.Arrays;

public class Inversion {

    /**
     * Let A[0..n − 1] be an array of real numbers (or any ordered set). A
     * pair (A[i], A[j]) is said to be an inversion if these numbers (elements) are out
     * of order, i.e., i < j but A[i] > A[j]. Note that this pair need not be adjacent.
     * The array/sequence (3, 2, 1) contains three inversions: (3,2), (2,1), and (3,1).
     */
    int count = 0;
    void main()
    {
        int[] arr = {5,2,6,7,1,3};
//        easyinversioncount();
        fastinversioncount(arr);
        System.out.println(count);
    }

    /**
     * Write a program with a na¨ıve O(n2) [sorting] algorithm that counts
     * the number of inversions in such an array A.
     * Call your program/project ‘easyinversioncount
     */
    //BubbleSort or InsertionSort
    void easyinversioncount(int[] arr)
    {
        int length = arr.length;
        for(int index = 0; index<length;index++)
        {

        }
    }

    /**
     * Write a program with a O(n log n) [sorting] algorithm that counts
     * the number of inversions in such an array A.
     * Call your program/project ‘fastinversioncount’
     */

    //MergeSort
    //an inversion is if i<j but arr[i]> arr[j}
    //does that mean if i>j but arr[i]<arr[j]?
    void fastinversioncount(int[]arr)
    {
//        for(int i:divide(arr))
//        {
//            System.out.print(i+ " ");
//        }
        divide(arr);
    }

    int[] divide(int[] arr)
    {
        if(arr.length<=1)
        {
            return arr;
        }
        int middleIndex = arr.length/2;
        int[] leftHalf = Arrays.copyOfRange(arr, 0, middleIndex);
        int[] rightHalf= Arrays.copyOfRange(arr, middleIndex, arr.length);
        int[] moreDividedLeft = divide(leftHalf);
        int[] moreDividedRight = divide(rightHalf);
        return merge(moreDividedLeft,moreDividedRight);
    }

    int[] merge(int[] leftArr, int[]rightArr)
    {
        int[] finalArray = new int[leftArr.length+rightArr.length];
        int finalIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex<leftArr.length && rightIndex<rightArr.length)
        {
            if(leftArr[leftIndex]<rightArr[rightIndex])
            {
                finalArray[finalIndex] = leftArr[leftIndex];
                leftIndex++;
            }
            else
            {
                finalArray[finalIndex] = rightArr[rightIndex];
                rightIndex++;

            }
            finalIndex++;

        }
        //once the sorting part runs out, put the rest into the final array
        while(leftIndex<leftArr.length)
        {
            finalArray[finalIndex] = leftArr[leftIndex];
            leftIndex++;
            count++;
        }
        while(rightIndex<rightArr.length)
        {
            finalArray[finalIndex] = rightArr[rightIndex];
            rightIndex++;
            count++;
        }
//        System.out.println(count);

        return finalArray;

    }

    /**
     * Divide
     * if(length<=1)
     *   return
     *  else
     *      divide by 2
     *      sort left
     *      sort right
     *      sortedLeft = divide(left)
     *      sortedRight = divide(right)
     *
     *      return merge(divide(left),divide(right))
     *
     * merge(left,right)
     *  final = []
     *  while leftIndex<left.length && rightIndex <right.length
     *      //it'll go through and find the smallest value
     *      //for example if it was [3 4 6] [1 2 5 7 9 11 15 17]
     *      i j
     *      3<1 -> add 1, increase j
     *      3<2 -> add 2, increase j
     *      3<5 -> add 3, increase i
     *      4<5 - add 4, increase i
     *      6<5 - add 5 increase j
     *      6<7 - add 6 increase i
     *            ^^^ correct
     *
     *      if(leftVal<rightVal)
     *      {
     *          final.add(leftVal)
     *          i++;
     *      }
     *      else
     *      {
     *          final.add(rightVal)
     *          j++
     *      }
     *
     *
     */

}

