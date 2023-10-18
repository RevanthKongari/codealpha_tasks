
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;  
  
//create ATMExample class to implement the ATM functionality  
public class ATMMachine 
{  
    //main method starts   
    public static void main(String args[] )  
    { 
        //declare and initialize balance, withdraw, and deposit  
        int balance = 100000,withdraw = 0, deposit = 0,pre_balance = 0; 
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
        Date date = new Date();
        while(true)
        {
            System.out.println("============================================================*WELCOME TO ATM*=================================================================");
            System.out.print("ENTER ATM CARD NO: ");
            int ATMNo = sc.nextInt();
            System.out.print("ENTER PIN NUMBER : ");
            int pin = sc.nextInt();
            if (ATMNo == 287598343 && pin == 2058)
            {while(true)
                {
            
                     
                    System.out.println("CHOOSE 1 TO WITHDRAW");  
                    System.out.println("CHOOSE 2 TO DEPOSIT");  
                    System.out.println("CHOOSE 3 TO CHECK BALANCE");  
                    System.out.println("CHOOSE 4 TO RECENT TRANSACTION RECEIPT");
                    System.out.println("CHOOSE 5  TO EXIT");  
                    System.out.print("Choose the operation you want to perform:");  
              
            //get choice from user  
                    int choice = sc.nextInt();  
                    switch(choice)
                    {  
                    case 1:  
                        pre_balance = balance;
                        System.out.print("Enter money to be withdrawn:");           
                        withdraw = sc.nextInt();  
                        if(balance >= withdraw)  
                        {  
            //remove the withdrawl amount from the total balance  
                            balance -= withdraw;  
                            System.out.println("Please collect your money"); 
                        }
                        else  
                        {  
            //show custom error message   
                            System.out.println("Insufficient Balance");  
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch(InterruptedException e)
                            {
                                
                            }
                        }  
                        System.out.println("DEAR CUSTOMER DO YOU WANT TRANSACTION RECEIPT: "); 
                        System.out.println("ENTER'Y' FOR YES AND 'N' FOR NO"); 
                        String choice1 = sc.next();
                        if(choice1.equals("Y")) 
                        {
                            System.out.println("===================*     BANK NAME     *=====================");
                            System.out.println("===================*TRANSACTION RECEIPT*=====================");
                            System.out.println(formatter.format(date));
                            System.out.println("BEFORE_DEBIT BAL:"+pre_balance);
                            System.out.println("DEBITED_AMOUNT: "+withdraw  );
                            System.out.println("======================================================*COMPLETED TRANSACTION*=================================================================");
                            break;
                        } 
                        else{
                            break;
                        }
                    case 2:  
                      
                        System.out.print("ENTER MONEY TO BE DEPOSITE:");  
                      
        //get deposite amount from the user  
                        deposit = sc.nextInt();  
                        int bal = balance;             
        //added the deposit amount to the total balanace  
                        balance = balance + deposit;  
                        System.out.println("YOUR MONEY HAS BEEN SUCCESSFULLY DEPOSITED");  
                        System.out.println("DEAR CUSTOMER DO YOU WANT TRANSACTION RECEIPT"); 
                        System.out.println("ENTER 'Y' FOR YES OR 'N' FOR NO");
                        String one2 = sc.next();
                        if (one2.equals("Y"))
                        {
                            System.out.println("===================*     BANK NAME     *=====================");
                            System.out.println("===================*TRANSACTION RECEIPT*=====================");
                            System.out.println(formatter.format(date));
                            System.out.println("BEFORE DEPOSIT:"+bal);
                            System.out.println("DEPOSITED AMOUNT : "+deposit);
                            System.out.println("ACCOUNT BALANCE : "+balance);
                            System.out.println("============================================================*COMPLETED TRANSACTION*=================================================================");
                            break;  
                        } 
                        else
                        {
                            break;
                        } 
              
   
                    case 3:  
        //displaying the total balance of the user  
                        System.out.println("ACCOUNT BALANCE : "+balance);  
                        System.out.println("DO YOU WANT ACC_BALANCE RECEIPT."); 
                        System.out.print("ENTER 'y' FOR YES AND 'N' FOR HOME PAGE");
                        String one = sc.next();
                        if (one.equals("Y"))
                        {
                            System.out.println("===================*     BANK NAME     *=====================");
                            System.out.println("===================*TRANSACTION RECEIPT*=====================");
                            System.out.println(formatter.format(date));
                            System.out.println("ACCOUNT BALANCE : "+balance);
                            System.out.println("============================================================*COMPLETED TRANSACTION*=================================================================");
                            break;
                        }
                        else
                        {
                            break;
                        } 
            
                    case 4:  
        //exit from the menu  
                        System.out.println("AMOUT " +pre_balance );
                        System.out.println("LAST  DEPOSITED AMOUNT : "+deposit); 
                        System.out.println("LAST WITHDRAWN AMOUNT :  "+withdraw); 
                        System.out.println("AVAILABLE BALANCE :    "+balance);
                    case 5:
                        break;
        
                    } 
                    break; 
                }
                
            }
    
            else if(pin == 2058)
            {
                System.out.println("PLEASE ENTER THE CORRECT ATM CARD NUMBER");
                System.out.println("----------**TRY FOR THE NEXT TIME**-----------");
            }
            else if(ATMNo == 287598343) 
            {
                System.out.println("PLEASE ENTER THE CORRECT PIN NUMBER");
                System.out.println("----------**TRY FOR THE NEXT TIME**-----------");
            }
            else
            {
                sc.close();
            }
        }
   }
}  
