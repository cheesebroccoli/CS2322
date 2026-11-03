public class Lucas_Subirachs {
    long startTimer;
    long endTimer;

    /**TODO
     * Figure out how to get timers working
     *
     */
    void main()
    {
        int n = 60;

        float goldenRatio = (float)lucas(n+1)/(float)lucas(n);
        float silverRatio = (float)chenchen(n+1)/(float)chenchen(n);
        System.out.println(silverRatio);
        System.out.println(goldenRatio);
//        System.out.println(goldenTime);
//        for(int i : betterNumbers(n))
//        {
//            System.out.print(i + " ");
//        }
//
    }


    //the lucas numbers as a recursive function. Most notably, we are starting at index 0.
    //TODO: create a kickout if someone puts in a negative number

    //calculate lucas numbers
    int lucas(int n)
    {
        if(n <0)
        {
            return -1;
        }
        if(n == 0)
        {
            return 2;
        }
        else if(n == 1)
        {
            return 1;
        }
        else
        {
            return lucas(n - 1) + lucas(n - 2);
        }
    }

    //calculate the vastly superior Chen-Chen numbers
    //13 and 6 are my favorite numbers
    int chenchen(int n)
    {
        if(n <0)
        {
            return -1;
        }
        if(n == 0)
        {
            return 6;
        }
        else if(n == 1)
        {
            return 13;
        }
        else
        {
            return chenchen(n-1) + chenchen(n-2);
            //this is the relationship between 6 and 13 but I kept it as above because I wanted to illustrate that the starting numbers
            //does not make the golden ratio, it is the... ratio. From 1-39 at least.
           // return (2* chenchen(n - 1)) + 1;
        }
    }

    //prints out lucas numbers
    int[] numbers(int n)
    {
        int[] numbers = new int[n+1];
        for(int i = n; i>=0; i--)
        {
            startTimer = System.nanoTime();
            numbers[i] = lucas(i);
            endTimer = System.nanoTime();
            System.out.print(endTimer - startTimer + " ");
        }
        return numbers;
    }

    //prints out chen-chen numbers
    int[] betterNumbers(int n)
    {
        int[] numbers = new int[n+1];
        for(int i = n; i>=0; i--)
        {
            numbers[i] = chenchen(i);
        }
        return numbers;
    }

}

