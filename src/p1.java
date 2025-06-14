import java.util.Scanner;
class max_numnber
{
    public static void main(String[]args)
    {
        int num1,num2;
        Scanner input= new Scanner(System.in);
        System.out.print("enter the number");
        int num=input.nextInt();
        System.out.print("enter the number");
        int n1=input.nextInt();
        int n2=input.nextInt();
        if (n1<n2)
        {
            System.out.println("maximum no.is"+n1);
        }
        else
            if(n2>n1) {
                System.out.println("maximum no. is" +n2);
            }
        else
            System.out.println("both are equal");





    }
}