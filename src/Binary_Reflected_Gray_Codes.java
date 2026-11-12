import java.util.ArrayList;

import static java.lang.Math.pow;

public class Binary_Reflected_Gray_Codes {

    void main()
    {
        int n = 5;
        for(int i: BRGCList(n))
        {
            System.out.print(i+ " ");
            personIsHere(i);
        }

    }
    void personIsHere(int n)
    {
        if(n == 0)
        {
            System.out.println("No one is within the circus ring");
        }
        else
        {
            if(n%2==1)
            {
                System.out.print("Axel ");
            }
            if((n/2)%2==1)
            {
                System.out.print("Bozo ");
            }
            if((n/4)%2==1)
            {
                System.out.print("Crunchy ");
            }
            if((n/8)%2==1)
            {
                System.out.print("Doofus ");
            }
            if((n/16)%2==1)
            {
                System.out.print("Enzo ");
            }

            System.out.println("is in the circus ring");
        }



    }

    int[] BRGCList(int n)
    {
        int[] fullList = new int[(int)pow(2,n)];
        for(int i = 0; i<=fullList.length-1; i++)
        {
            fullList[i] = BRGC(i);
        }
        return fullList;
    }
    /*
    This is a gray code to decimal converter. the index is the grey code, the value is the decimal equivalent
     */
    //for each number, left shift 1, xor 1 to the end.
    int BRGC(int n)
    {
        if(n == 0)
        {
            return 0;
        }
       else
        {
            return n^(n>>1);
        }
    }
}

/**NOTES FOR PT 1 (BGRC AND BGRC LIST)

//should print 2

//BRGC(3) below
//should be 000 001 011 010 |  110 111 101 100
// list is (2^n) long
//          0   1   3   2   |  6   7   5   4 <- binary to decimal
//          1   2   3   4   |  5   6   7   8 <- grey to decimal
        /*
        notice it's 000 001 011 010 then the MSB is 1, order is flipped and then added

//    BRGC(n)
////Generates recursively the binary reflected Gray code of order n
////Input: A positive integer n
////Output: A list of all bit strings of length n composing the Gray code
//if n = 1 make list L containing bit strings 0 and 1 in this order
//else generate list L1 of bit strings of size n − 1 by calling BRGC(n − 1)

//seperate function
//    copy list L1 to list L2 in reversed order
//L1 -> 00 01 11 10
//L2 -> 10 11 01 00
//    add 0 in front of each bit string in list L1
// L1- > 000 001 011 010
//    add 1 in front of each bit string in list L2
// L2 -> 110 111 101 110
//    append L2 to L1 to get list L
//return L ->000 001 011 010 | 110 111 101 110
 */

/**NOTES FOR PT 2
 * if(i%2 == 1)
 *   axel is here
 * if(i%3 == 0)
 *
 * Bit mask (val & mask) != 0 : place is at 1 (therefore person is here)
 * (x&n !=0)
 * {
 *     person is here
 * }
 * &2 -> axel
 * &4-> bozo
 * &8 -> crunch
 * &16 -> doofus
 * &32 ->enzo
 *
 */