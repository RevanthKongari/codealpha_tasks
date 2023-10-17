import java.lang.Thread;
import java.util.Scanner;

public class GuessGame
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int rand,max = 100,min = 1,score=0;
        int i = 5,j =5,point = 0,k = 3;
        String User_name,password;
        int num = 0;
        while(k >= 1)
        {
        System.out.printf("PLAYER NAME : ");
        User_name = sc.nextLine();
        System.out.printf("PASSWORD    : ");
        password = sc.nextLine();
        if(User_name.equals("Revanth") && password.equals("Rams") )
        {
            System.out.println("***********GENERAL INSTRUCTION************");
            System.out.println(User_name+" GUESS THE NUMBER IN THE RANGE OF 1 TO 100 INCLUSIVELY.");
            System.out.println(User_name+" IF YOU ENTER OUT OF RANGE THE  GAME GETS CLOSE.");
            System.out.println("THE MAXIMUM AND MINIMUM POINTS ARE 0 AND 10.");
            System.out.println(" YOU WILL HAVE ONLY 5 CHANCES AND THE SCORE IS DISPLAYED ON SCREEN.");
            System.out.println("THE TOTAL POINTS OF 5 GUESSES GET DISPLAYED IF YOU COMPLETE 5 CHANCES");
            System.out.println("PLEASE WAIT UNTIL THE GAME STARTS.");


            System.out.println("*******************************************");
            try
            {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) 
            {

            }
            
            while(i > 0)
            {
                while(j > 0 )
                {
                    System.out.print("ENTER THE GUESSED NUMBER : ");
                    num = sc.nextInt();
                    if (num<0 || num>100)
                    {
                        System.out.println("The number entered by player is not in specified range.");
                        try{
                            Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {

                        }
                        System.exit(0);
                    }
                    if (num>0 & num<101)
                    {
                        j--;
                        break;
                    }
                    j--;

                }
                rand = (int)(Math.random()*(max - min+1)+min);
                System.out.println("GENERATED NUMBER : "+rand);
                if (num == rand)
                {
                    point = 10;
                    score +=10 ;    
                    System.out.println("AWARDED POINTS : "+point);
                }   
                else if (num > rand)
                {
                    if(num - rand <=10)
                    {
                    point = 5;
                    score += 5;
                    System.out.println("AWARDED POINTS: "+point);
                    }
                    else if(num - rand <=20 && num - rand >10){
                    point = 4;
                    score += 4;
                    System.out.println("AWARDED POINTS : "+point);
                    }
                    else if(num - rand <= 30 && num - rand >20){
                        point = 3;
                        score +=3;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    else if(num - rand <=40 && num - rand >30){
                        point = 2;
                        score+=2;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    else if(num - rand <=50 && num - rand >40) {
                        point = 1;
                        score += 1;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    else{
                        point = 0;
                        System.out.println("AWARDED POINTS : "+point);
                    }
            
                    System.out.println("Dear player your guess is greater than the generated number.Better luck for next time.");
                    try{
                        Thread.sleep(3000);
                    }
                    catch(InterruptedException e){
                        sc.close();
                    }
                }
                else
                {
                    if(rand - num <=10)
                    {
                        point = 5;
                        score += 5;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    else if(rand - num <=20 && rand - num>10){
                        point = 4;
                        score += 4;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    else if(rand - num <= 30 && rand - num >20){
                        point = 3;
                        score +=3;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    else if(rand - num<=40 && rand - num >30){
                        point = 2;
                        score+=2;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    else if(num - rand <=50 && num - rand >40)
                    {
                        point = 1;
                        score+=1;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    else
                    {
                        point = 0;
                        System.out.println("AWARDED POINTS : "+point);
                    }
                    System.out.println("REMAINING CHANCES: "+(i-1));
                    System.out.println("Dear player your guess is lesser than the generated number.Better luck for next time.");
                    try{
                        Thread.sleep(3000);
                    }
                    catch(InterruptedException e){
                        sc.close();
                    }

                }
                if(i == 1){
                    System.out.println("TOTAL POINTS OF ALL THREE GUESS : "+score);
                    break;
                }
                i--;

                System.out.println("***************************--**************************************");
                if(i==0){
                    System.out.println("*************************** THE END **************************************");

                }
            }

        }
        else{

            System.out.println("PLEASE ENTER VALID CREDENTIALS");
            System.out.println("YOU HAVE ONLY "+(k - 1) +" CHANCES");
            if(k == 1)
            {
                System.out.println("LOGIN IS ABORDED");
        
            }


        }
        k--;
    }
    }
}




