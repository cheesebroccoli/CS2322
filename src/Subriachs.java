public class Subriachs {
    int[] subriachs = {1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15};
    public void main()
    {
//        System.out.println(allFourCombos());
//        System.out.println(allThreeCombos());
    }
    int allFourCombos()
    {
        int counter = 0;
        for(int i = 0; i<subriachs.length; i++)
        {
            for(int j = 0; j<subriachs.length; j++)
            {
                for(int k = 0; k<subriachs.length; k++)
                {
                    for(int l = 0; l<subriachs.length; l++)
                    {
                        if(subriachs[i]+subriachs[j]+subriachs[k]+subriachs[l] == 33 && i!=j && i!=k && i!=l && j!=k && j!=l && k!=l)
                        {
                            System.out.println(subriachs[i]+" " + subriachs[j]+" "+ subriachs[k]+" " +subriachs[l]);
                            counter++;
                        }
                    }

                }
            }
        }
        return counter;

    }
    int allThreeCombos()
    {
        int counter = 0;
        for(int i = 0; i<subriachs.length; i++)
        {
            for(int j = 0; j<subriachs.length; j++)
            {
                for(int k = 0; k<subriachs.length; k++)
                {

                        if(subriachs[i]+subriachs[j]+subriachs[k] == 33 && i!=j && i!=k && j!=k)
                        {
                            System.out.println(subriachs[i]+" " + subriachs[j]+" "+ subriachs[k]);
                            counter++;
                        }


                }
            }
        }
        return counter;
    }
}
