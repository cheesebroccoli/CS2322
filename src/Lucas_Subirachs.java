public class Lucas_Subirachs {

    void main()
    {

        int n = 45;
        long startTimer = System.nanoTime();
        int top = lucas(n+1);
//        for(int i : numbers(n))
//        {
//            System.out.print(i + " ");
//        }
//
        long endTimer = System.nanoTime();
        long top_time = endTimer - startTimer;

        startTimer = System.nanoTime();
        int bottom = lucas(n);
        endTimer = System.nanoTime();
        long bottom_time = endTimer - startTimer;

        float goldenRatio = (float)top/(float)bottom;
        float goldenTime = (float)top_time/(float)bottom_time;
//        System.out.println(goldenRatio);
        System.out.println(goldenTime);
    }


    //the lucas numbers as a recursive function. Most notably, we are starting at index 0.
    //TODO: create a kickout if someone puts in a negative number

    //calculate lucas numbers
    int lucas(int n)
    {
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

    //prints out lucas numbers
    int[] numbers(int n)
    {
        int[] numbers = new int[n+1];
        for(int i = n; i>=0; i--)
        {
            numbers[i] = lucas(i);
        }
        return numbers;
    }

    long readySetGo(int n)
    {
        long startTimer = System.nanoTime();
        lucas(n);
        long endTimer = System.nanoTime();

        return endTimer - startTimer;
    }
}

