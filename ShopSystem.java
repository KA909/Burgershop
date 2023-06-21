import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class ShopSystem {


    static String[] customerNames = new String[10];

    static String[][] Q1 = {{"", "X"}, {"", "X"}};
    static String[][] Q2 = {{"", "X"}, {"", "X"}, {"", "X"}};
    static String[][] Q3 = {{"", "X"}, {"", "X"}, {"", "X"}, {"", "X"}, {"", "X"}};

    static int Burgercount = 50;

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void line() {
        System.out.print(" --------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void printQuecol(String[] tempQ1, String[] tempQ2, String[] tempQ3){
        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                System.out.print("   " + tempQ1[i] + "  " + tempQ2[i] + "  " + tempQ3[i]);
                System.out.println();
            } else if (i == 2) {
                System.out.print("      " + tempQ2[i] + "  " + tempQ3[i]);
                System.out.println();
            } else {
                System.out.print("         " + tempQ3[i]);
                System.out.println();

            }
        }

    }
    public static void viewAllQueues() {
        Scanner input = new Scanner(System.in);

        String[] tempQ1 = {Q1[0][1], Q1[1][1]};
        String[] tempQ2 = {Q2[0][1], Q2[1][1], Q2[2][1]};
        String[] tempQ3 = {Q3[0][1], Q3[1][1], Q3[2][1], Q3[3][1], Q3[4][1]};

        System.out.println("*****************");
        System.out.println("  * Cashiers *");
        System.out.println("*****************");

        printQuecol(tempQ1, tempQ2, tempQ3);

        System.out.print("Press any character to load the main menu... : ");
        input.next().charAt(0);

    }

    public static void viewAllEmptyQueues2() {
        Scanner input = new Scanner(System.in);

        System.out.println("*****************");
        System.out.println("*    Cashiers   *");
        System.out.println("*****************");

        String[] tempQ1 = {Q1[0][1], Q1[1][1]};
        String[] tempQ2 = {Q2[0][1], Q2[1][1], Q2[2][1]};
        String[] tempQ3 = {Q3[0][1], Q3[1][1], Q3[2][1], Q3[3][1], Q3[4][1]};

        for(String m: tempQ1){
            if(m == "0"){
                for(int i=0; i<tempQ1.length; i++){
                    tempQ1[i] = " ";
                }
            }
        }
        for(String m: tempQ2){
            if(m == "0"){
                for(int i=0; i<tempQ2.length; i++){
                    tempQ2[i] = " ";
                }
            }
        }
        for(String m: tempQ3){
            if(m == "0"){
                for(int i=0; i<tempQ3.length; i++){
                    tempQ3[i] = " ";
                }
            }
        }
        printQuecol(tempQ1, tempQ2, tempQ3);
        System.out.print("Press any character to load the main menu... : ");
        input.next().charAt(0);

    }

    public static void removeServedcustomerLogic(String[][] newArray, int len) {

        if (len == 2) {
            if (Q1[0][1] == "0") {
                Q1[0][0] = Q1[1][0];
                Q1[0][1] = Q1[1][1];
                Q1[1][0] = "";
                Q1[1][1] = "X";
                System.out.println("Customer has been served..");
                Burgercount -= 5;
            } else {
                System.out.println("No customer is in the que to serve");
            }

        } else if (len == 3) {
            if (Q2[0][1] == "0"){
                for(int i=0; i<2; i++){
                    Q2[i][0] = Q2[i+1][0];
                    Q2[i][1] = Q2[i+1][1];

                    if(i==2){
                        Q3[i+1][0] = "";
                        Q3[i+1][1] = "X";
                    }
                }
                System.out.println("Customer has been served..");
                Burgercount -= 5;
            }
            else {
                System.out.println("No customer is in the que to serve");
            }

        } else if (len == 5) {
            if (Q3[0][1] == "0"){
                for(int i=0; i<4; i++){
                    Q3[i][0] = Q3[i+1][0];
                    Q3[i][1] = Q3[i+1][1];

                    if(i==3){
                        Q3[i+1][0] = "";
                        Q3[i+1][1] = "X";

                    }
                }
                System.out.println("Customer has been served..");
                Burgercount -= 5;
            }
            else {
                System.out.println("No customer is in the que to serve");
            }
            }
        }

    public static void removeServedcustomer(){
        Scanner input = new Scanner(System.in);
        line();
        System.out.println("\t\t\t\t\t\t  REMOVE SERVED CUSTOMER \t\t\t\t\t       ");
        line();
        System.out.println();

        outer:while (true) {
            System.out.print("Enter Que number you want serve first>>");
            int servedCustomerque = input.nextInt();

            if (servedCustomerque == 1)
                removeServedcustomerLogic(Q1, Q1.length);
            else if (servedCustomerque == 2)
                removeServedcustomerLogic(Q2, Q2.length);
            else if (servedCustomerque == 3)
                removeServedcustomerLogic(Q3, Q3.length);
            else {
                System.out.println("Invalid input.");
                continue;
            }
            if(Burgercount <= 10){
                System.out.println("WARNING: Stock is reaching out of the limit.Remaining burger count: " + Burgercount);
            }

            while (true) {
                System.out.print("Do you want to add Serve another Customer (Y/N) : ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    continue outer;
                } else if (ch == 'N' || ch == 'n') {
                    clearConsole();
                    return;
                } else {
                    System.out.println("\tInvalid Input...  \n");
                    continue;

                }
            }
        }
    }

    public static int removeCustomerLogic(String[][] removeArray,int removelen,int position){


        if (removelen == 2) {
            if (Q1[0][1] == "0" & position == 1) {
                Q1[0][0] = Q1[1][0];
                Q1[0][1] = Q1[1][1];
                Q1[1][0] = "";
                Q1[1][1] = "X";
                System.out.println("Customer has been removed..");

            } else if (Q1[1][1] == "0" & position == 2) {
                Q1[1][0] = "";
                Q1[1][1] = "X";
                System.out.println("Customer has been removed..");

            } else {
                System.out.println("There is no cutomer in that position.");
                return 0;
            }

        } else if (removelen == 3) {
            if (Q2[0][1] == "0" & position == 1) {
                Q2[0][0] = Q2[1][0];
                Q2[0][1] = Q2[1][1];
                Q2[1][0] = Q2[2][0];
                Q2[1][1] = Q2[2][1];
                Q2[2][0] = "";
                Q2[2][1] = "X";
                System.out.println("Customer has been removed..");
            } else if (Q2[1][1] == "0" & position == 2) {
                Q2[1][0] = Q2[2][0];
                Q2[1][1] = Q2[2][1];
                Q2[2][0] = "";
                Q2[2][1] = "X";
                System.out.println("Customer has been removed");
            } else if (Q2[2][1] == "0" & position == 3) {
                Q2[2][0] = "";
                Q2[2][1] = "X";
                System.out.println("Customer has been removed");
            } else {
                System.out.println("There is no cutomer in that position.");
                return 0;
            }
        } else if (removelen == 5) {
            if (Q3[0][1] == "0" & position == 1) {
                Q3[0][0] = Q3[1][0];
                Q3[0][1] = Q3[1][1];
                Q3[1][0] = Q3[2][0];
                Q3[1][1] = Q3[2][1];
                Q3[2][0] = Q3[3][0];
                Q3[2][1] = Q3[3][1];
                Q3[3][0] = Q3[4][0];
                Q3[3][1] = Q3[4][1];
                Q3[4][0] = "";
                Q3[4][1] = "X";
                System.out.println("Customer has been removed");
            } else if (Q3[1][1] == "0" & position == 2) {
                Q3[1][0] = Q3[2][0];
                Q3[1][1] = Q3[2][1];
                Q3[2][0] = Q3[3][0];
                Q3[2][1] = Q3[3][1];
                Q3[3][0] = Q3[4][0];
                Q3[3][1] = Q3[4][1];
                Q3[4][0] = "";
                Q3[4][1] = "X";
                System.out.println("Customer has been removed");
            } else if (Q3[2][1] == "0" & position == 3) {
                Q3[2][0] = Q3[3][0];
                Q3[2][1] = Q3[3][1];
                Q3[3][0] = Q3[4][0];
                Q3[3][1] = Q3[4][1];
                Q3[4][0] = "";
                Q3[4][1] = "X";
                System.out.println("Customer has been removed");
            } else if (Q3[3][1] == "0" & position == 4) {
                Q3[3][0] = Q3[4][0];
                Q3[3][1] = Q3[4][1];
                Q3[4][0] = "";
                Q3[4][1] = "X";
                System.out.println("Customer has been removed");
            } else if (Q3[4][1] == "0" & position == 5) {
                Q3[4][0] = "";
                Q3[4][1] = "X";
                System.out.println("Customer has been removed");
            } else {
                System.out.println("There is no cutomer in that position.");
                return 0;
            }
        }
    return 5;
    }

    public static void removeCustomer(){
        Scanner input = new Scanner(System.in);

        while(true){
            line();
            System.out.println("\t\t\t\t\t\t  REMOVE A CUSTOMER \t\t\t\t\t       ");
            line();
            System.out.println();

            System.out.println("Enter the que and the position you want to remove>> ");
            System.out.print("\t\tQue: ");
            int que = input.nextInt();
            System.out.print("\t\tPosition: ");
            int position = input.nextInt();

            if(que == 1) {
                if (position > 0 & position <= 2) {
                    int a=removeCustomerLogic(Q1, Q1.length, position);
                    if(a == 0) continue;
                    break;
                } else {
                    System.out.println("Enter correct position");

                }
            }
            else if (que == 2) {
                if (position > 0 & position <= 3) {
                    int a = removeCustomerLogic(Q2, Q2.length, position);
                    if(a == 0) continue;
                    break;
                } else {
                    System.out.println("Enter correct position");
                    continue;
                }
            }
            else if (que == 3){
                if (position > 0 & position <= 5) {
                    int a = removeCustomerLogic(Q3, Q3.length, position);
                    if(a == 0) continue;
                    break;
                } else {
                    System.out.println("Enter correct position");
                    continue;
                }
            }
            else {
                System.out.println("Enter correct que number");
                continue ;
            }
      }

    }

    public static void checkandfill0s(String addname) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the que you want to add>> ");
            int que = input.nextInt();

            if (que > 0) {
                if (que == 1) {
                    if (Q1[0][1] == "X") {
                        Q1[0][1] = "0";
                        Q1[0][0] = addname;
                        break;
                    } else if (Q1[1][1] == "X") {
                        Q1[1][1] = "0";
                        Q1[1][0] = addname;
                        break;
                    }
                    else {
                        System.out.println("Que is full..try another one.");
                        continue;
                    }

                } else if (que == 2) {
                    if (Q2[0][1] == "X") {
                        Q2[0][1] = "0";
                        Q2[0][0] = addname;
                        break;
                    } else if (Q2[1][1] == "X") {
                        Q2[1][1] = "0";
                        Q2[1][0] = addname;
                        break;
                    } else if (Q2[2][1] == "X") {
                        Q2[2][1] = "0";
                        Q2[2][0] = addname;
                        break;
                    } else {
                        System.out.println("Que is full..try another one.");
                        continue;
                    }
                } else if (que == 3) {
                    if (Q3[0][1] == "X") {
                        Q3[0][1] = "0";
                        Q3[0][0] = addname;
                        break;
                    } else if (Q3[1][1] == "X") {
                        Q3[1][1] = "0";
                        Q3[1][0] = addname;
                        break;
                    } else if (Q3[2][1] == "X") {
                        Q3[2][1] = "0";
                        Q3[2][0] = addname;
                        break;
                    } else if (Q3[3][1] == "X") {
                        Q3[3][1] = "0";
                        Q3[3][0] = addname;
                        break;
                    } else if (Q3[4][1] == "X") {
                        Q3[4][1] = "0";
                        Q3[4][0] = addname;
                        break;
                    } else {
                        System.out.println("Que is full..try another one.");
                        continue;
                    }

                }
            }
            else {
                System.out.println("\tInvalid input..");
                continue;
            }

        }
    }

    public static void addNewCustomer() {
        Scanner input = new Scanner(System.in);
        try {
            outer:
            while (true) {
                line();
                System.out.println("\t\t\t\t\t\t  ADD NEW CUSTOMER  \t\t\t\t\t       ");
                line();
                System.out.println();

                String name;
                System.out.print("Enter Customer Name: ");
                name = input.next();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);

                checkandfill0s(name);

                System.out.println("Customer added sucessfully..");

                char ch;
                while (true) {
                    System.out.print("Do you want to add another Customer (Y/N) : ");
                    ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        clearConsole();
                        continue outer;
                    } else if (ch == 'N' || ch == 'n') {
                        clearConsole();
                        return;
                    } else {
                        System.out.println("\tInvalid Input...  \n");
                        continue;

                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public static void ViewRemainingBurgerStock(){
        System.out.println("Remaining Burger Count: " + Burgercount);

    }
    public static void AddBurgertoStock(){
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the burger amount to add: ");
            int refill_burger = input.nextInt();

            if ((Burgercount + refill_burger) > 50) {
                System.out.println("Exceeded max burger count.");
                continue;
            }
            else{
                Burgercount = Burgercount + refill_burger;
                System.out.println("Stock updated.");
                break;
            }

        }
    }

    public static void sortArray(){
        Scanner input = new Scanner(System.in);

        String[] arr = {Q1[0][0], Q1[1][0], Q2[0][0], Q2[1][0], Q2[2][0], Q3[0][0], Q3[1][0], Q3[2][0], Q3[3][0], Q3[4][0] };

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent strings and swap them if necessary
                if (arr[j].compareToIgnoreCase(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i=0; i<arr.length; i++) {
            if (!arr[i].equals("")){
                System.out.println(arr[i]);
            }

        }

    }

    public static void writeDataintoFile(){

        try {
            // Step 1: Create an object of BufferedWriter
            BufferedWriter f_writer
                    = new BufferedWriter(new FileWriter(
                    "C:\\Users\\KMN IT\\Desktop\\JavaCW\\demo.txt"));

            f_writer.write("--------Customer names ------\n");

            for(int i=0; i< Q1.length;  i++){
                if(Q1[i][1] == "0")
                    f_writer.write(Q1[i][0] + "\n");
            }

            // Write text(content) to file
            for(int i=0; i< Q2.length;  i++){
                if(Q2[i][1] == "0")
                 f_writer.write(Q2[i][0] + "\n");

            }
            for(int i=0; i< Q3.length;  i++){
                if(Q3[i][1] == "0")
                f_writer.write(Q3[i][0] + "\n");
            }

            // Display message showcasing
            // successful execution of the program
            System.out.print("File is created successfully with the content.\n");

            f_writer.close();
        }
        // Catch block to handle if exceptions occurs
        catch (IOException e) {

            // Print the exception on console
            // using getMessage() method
            System.out.print(e.getMessage());
        }
    }

    public static void readFile() throws Exception
    {
        // pass the path to the file as a parameter
        File file = new File(
                "C:\\Users\\KMN IT\\Desktop\\JavaCW\\demo.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }

    public static void homepage(){
        line();
        System.out.println("                      |\t\t\t\t\t\t  Foodies Fave Food Center \t\t\t\t\t       |             ");
        line();
        System.out.println();
        System.out.println("\t\t\t 1) View All Queues.              -[VFQ/100] \t\t  2) View All Empty Queues.      -[VEQ/101]");
        System.out.println("\t\t\t 3) Add customer to a Queue.      -[ACQ/102] \t\t  4) Remove a Customer from Que. -[RCQ/103]");
        System.out.println("\t\t\t 5) Remove a served customer.     -[PCQ/104] \t\t  6) View Customers Sorted       -[VCS/105}");
        System.out.println("\t\t\t 7) Store Program Data into file. -[SPD/106] \t\t  8) Load Program Data from file -[LPD/107]");
        System.out.println("\t\t\t 9) View Remaining burgers Stock. -[STK/108] \t\t  10) Add burgers to Stock       -[AFS/109]");
        System.out.println(" \n\t\t\t 11) Exit the Program.  -[999/EXT]                                                                            ");
        System.out.println();

        if(Burgercount <= 10){
            System.out.println("WARNING: Stock is reaching out of the limit.Remaining burger count: " + Burgercount);
        }
    }

    public static void main(String[] args) throws Exception {
        clearConsole();
        Scanner input = new Scanner(System.in);

        homepage();

        while (true) {
            String option;
            System.out.print("Enter an option to continue > ");
            option = input.nextLine();

            if(Objects.equals(option, "999") | Objects.equals(option, "EXT")){
                break;
            }
            switch (option) {
                case "100":
                case "VFQ":
                    viewAllQueues();
                    homepage();
                    break;

                case "101":
                case "VEQ":
                    viewAllEmptyQueues2();
                    homepage();
                    break;
                case "102":
                case "ACQ":
                    addNewCustomer();
                    homepage();
                    break;
                case "103":
                case "RCQ":
                    removeCustomer();
                    homepage();
                    break;
                case "104":
                case "PCQ":
                    removeServedcustomer();
                    homepage();
                    break;
                case "105":
                case "VCS":
                    sortArray();
                    homepage();
                    break;
                // (...)
                case "106":
                case "SPD":
                    writeDataintoFile();
                    homepage();
                    break;
                case "107":
                case "LPD":
                    readFile();
                    homepage();
                    break;
                case "108":
                case "STK":
                    ViewRemainingBurgerStock();
                    homepage();
                    break;
                case "109":
                case "AFS":
                    AddBurgertoStock();
                    homepage();
                    break;
                default:
                    System.out.println("\t Invalid input...");

            }

        }

    }

}

