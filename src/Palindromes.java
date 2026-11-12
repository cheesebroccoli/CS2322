import java.util.Scanner;
public class Palindromes
{
    void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("palindrome here: ");
        String s = scan.nextLine();

        palindrome(s,0,s.length()-1);
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9\\\s]","");
    }
    public static boolean palindrome(String s, int i, int j)
    {
        if(i>=j)
        {
            return true;
        }
        if(s.charAt(i) != s.charAt(j))
        {
            return false;
        }
        return palindrome(s, i+1, j-1);
    }
}
