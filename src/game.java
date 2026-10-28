import java.util.Random;
import java.util.Scanner;

public class game
{
    void main() {
        int[] matches = {1,2,3,4,5}; //items to play; a better cs student as a better way of populating this array.
        //int[] matches = {3,7,5};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to Double Trouble! The goal of the game is to be the last person to take a match. The matches are in a triangular configuration");
        System.out.println("The first row having 1 match, the second having 2 so on up to " + matches.length + " rows");
        boolean playerTurn = false; //default first move -> grab 1.
        System.out.print("Would you like to go first (yes or no): "); //technically second player is better bc they start with an nim sum
        if(scanner.nextLine().toLowerCase().equals("yes")) 
        {
            playerTurn = true;
        }
        while(totalMatches(matches,0,matches.length-1)> 1) //while there is more than just one left. At one you are able to declare winner
        {
                boolean legal = false; //whether a player move is considered legal

            printMatches(matches); //number of matches from each row left. doesn't matter in what order

            /**
             * TODO: make it so it is removal by color rather than removal by row
             */
           while(playerTurn){
               int row = 0; //the row that they are pulling form
               int nom = row+1; // the number of stones the player is pulling from. based off that, we should get the color (1-2, co.1, 3,4, co.2, 5, co 3.)
                while(!legal) {

                    System.out.print("row: ");
                    row = scanner.nextInt()-1; //1 -> 0, 2-> 1 ...
                    if (row <= matches.length && row>-1) { //valid row number
                        legal = true;
                        break;
                    }
                    //if row does fit in color
                    System.out.println(row +1 + " is an invalid row");
                }
                legal = false; //reset this variable so it will also check for number of matches they are taking

                while(!legal) {
                    System.out.print("amount: ");
                    nom = scanner.nextInt();
                    if(nom<=matches[row] && nom >0)
                    {
                        legal = true;
                        break;
                    }

                    System.out.println(nom + " is an invalid amount within row "+ (row+1) + " because there is only " + matches[row]+ " left");
                }
               matches[row] -= nom; //removes stones
               legal = false; //resets it for next turn;
               //TODO: add it so it can rerun this if there is more beads within the color
               playerTurn = false; //goes to computer turn
           } // paren for player

                //end of player turn. Start of computer turn
            System.out.println("it's the computer's turn");
            while(!playerTurn)
            {
                int green = totalMatches(matches,0,1); //3
                int yellow = totalMatches(matches,2,3); //7
                int red = totalMatches(matches,4,4); //5
                int winCon = green^yellow^red;
//                System.out.println("green:" + green);
//                System.out.println("yellow: "+ yellow);
//                System.out.println("red: "+ red);
//                System.out.println(winCon);
                System.out.println("winCon: " + winCon);
                //TODO: implement this

//                if(winCon == 0)
//                {
//                    Random r= new Random();
//
//                }
//                else
//                {
                if((winCon) <= green)
                {
                    removeMatches(matches,winCon,0,1);
                    System.out.printf("The computer has removed %s from the first two rows \n",winCon);
                    //removeMatches(int[]m, int nom, int begin, int end)
                    //green -= yellow^red;
                    //  -> given that number remove starting from matches[begin] until it hits 0
                }
                else if((winCon) <= yellow)
                {
                    //yellow -= green^red
                    removeMatches(matches,(winCon),2,3);
                    System.out.printf("The computer has removed %s from the second two rows \n",(winCon));

                }
                else
                {
//                      red -= green ^ yellow
                    removeMatches(matches,(winCon),4,4);
                    System.out.printf("The computer has removed %s from the second two rows \n",(winCon));

                }
//                  if((winCon) <= green)
//                  {
//                      removeMatches(matches,winCon,0,1);
//                      System.out.printf("The computer has removed %s from the first two rows \n",winCon);
//                      //removeMatches(int[]m, int nom, int begin, int end)
//                    //green -= yellow^red;
//                  //  -> given that number remove starting from matches[begin] until it hits 0
//                  }
//                  else if((green^red) <= yellow)
//                  {
//                      //yellow -= green^red
//                      removeMatches(matches,(green^red),2,3);
//                      System.out.printf("The computer has removed %s from the second two rows \n",(green^red));
//
//                  }
//                  else
//                  {
////                      red -= green ^ yellow
//                      removeMatches(matches,(green^yellow),4,4);
//                      System.out.printf("The computer has removed %s from the second two rows \n",(green^yellow));
//
//                   }
                //}



                /**
                 * if(winCon != 0)
                 * {
                 *    you are winning. make sure you keep it like this. tweedle dee dweedle dum
                 * }
                 * else
                 * {
                 * do something random
                 * }
                 * the person in the notZero position can always force a zero, guaranteeing a win
                 * remove an amount so that the colors xored together != 0;
                 */

                playerTurn = true; //end of computer turn
            } //paren for computer
        }// paren for while the game is playing
        //last turn
        System.out.println("there are "+ totalMatches(matches,0, matches.length-1) + " left.");
//        String winner = (playerTurn) ? "You" : "The computer"; //if it's your turn whien there is one match, you win!
//        System.out.printf("%s won",winner);
    }
    void printMatches(int[]m) //prints number of matches in each row
    {
        System.out.println();
        for(int i : m)
        {
            System.out.println(i);
        }
        System.out.println();
    }
    //to find colors, add beginning row and end inclusive as an input (
    // total would be totaMatches(0, length), green would be totalMatches(0,1)
    int totalMatches(int[] matches, int begin, int end)
    {
        int i = 0;
        for(int x = begin; x<=end; x++)
        {
            i+=matches[x];
        }
        return i;
    }
    void removeMatches(int[]m, int nom, int begin, int end)
    {
        int i = nom;
        if(nom <1)
        {
            return;
        }
        for(int x = begin; x<=end; x++)
        {
             //y is the matches being removed in that row
            int y = java.lang.Math.max(i,m[x]);
            m[x] -= y;

            i -= y;
            if(i<1)
            {
                return;
            }

       }
        printMatches(m);

    }



}


