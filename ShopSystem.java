import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ShopSystem {

    static String[] customerNames=new String[0];
    static char[] q1 = {'X', 'X'};
    static char[] q2 = {'X', 'X', 'X'};
    static char[] q3 = {'X', 'X', 'X', 'X', 'X'};

    public final static void clearConsole() {
        try{
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void line(){
        System.out.print(" --------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void viewAllQueues(){
        Scanner input = new Scanner(System.in);

        System.out.println("*****************");
        System.out.println("  * Cashiers *");
        System.out.println("*****************");

        for(int i=0; i<5; i++) {
            if (i < 2) {
                System.out.print("   " + q1[i] + "  " + q2[i] + "  " + q3[i]);
                System.out.println();
            } else if (i == 2) {
                System.out.print("      " + q2[i] + "  " + q3[i]);
                System.out.println();
            } else {
                System.out.print("         " + q3[i]);
                System.out.println();

            }
        }

        System.out.print("Press any character to load the main menu... : ");
        input.next().charAt(0);

        }

    public static void QuesandPositions(){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the que and the position you want to add>> ");

            outer:while (true) {
                System.out.print("\t\tQue: ");
                int que = input.nextInt();

                while (true) {
                    if (que == 1) {
                        System.out.print("\t\tPosition: ");
                        int position = input.nextInt();
                        if (position > 0 & position <= 2) {
                            updateQueArray(q1,position);
                            //System.out.println("Customer added successfully");
                            break outer;

                        } else
                            System.out.println("\t\tInvalid position\n");
                        continue;
                    }
                    else if (que == 2) {
                        System.out.print("\t\tPosition: ");
                        int position = input.nextInt();
                        if (position > 0 & position <= 3) {
                            //updateQueArray
                            System.out.println("Customer added successfully");
                            break outer;
                        }else
                            System.out.println("\t\tInvalid position\n");
                        continue;

                    }
                    else if (que == 3) {
                        System.out.print("\t\tPosition: ");
                        int position = input.nextInt();
                        if (position > 0 & position <= 5) {
                            //updateQueArray
                            System.out.println("Customer added successfully");
                            break outer;
                        }else
                            System.out.println("\t\tInvalid position\n");
                        continue;

                    }
                    else
                        System.out.println("\t\tInvalid Que.\n");
                    break;

                }

            }

    }

    public static void updateQueArray(char[] q,int pos){
        if (q[pos-1] == 'X') {
            q[pos - 1] = '0';
            System.out.println("Customer added successfully");
        }
        else if (q[pos-1] == '0') {
            System.out.println("\t\tQue postion already allocated.\n");
        }
    }


    public static void addNewCustomer() {
        Scanner input = new Scanner(System.in);

        outer:while (true) {
            line();
            System.out.println("\t\t\t\t\t\t  ADD NEW CUSTOMER  \t\t\t\t\t       ");
            line();
            System.out.println();

//Adding Customer name to the array.
            String name;
            System.out.print("Enter Customer Name: ");
            name = input.next();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            String[] temp2 = new String[customerNames.length + 1];
            for (int i = 0; i < customerNames.length; i++) {
                temp2[i] = customerNames[i];
            }
            customerNames = temp2;
            customerNames[customerNames.length - 1] = name;
            System.out.println(Arrays.toString(customerNames));

            QuesandPositions();

            char ch;
            while (true) {
                System.out.print("Do you want to add Customer (Y/N) : ");
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



    public static void homepage(){
        line();
        System.out.println("                      |\t\t\t\t\t\t  iHungry Burger  \t\t\t\t\t       |             ");
        line();
        System.out.println();
        System.out.println("\t\t\t 1) View All Queues.              -[VFQ/100] \t\t  2) View All Empty Queues.      -[VEQ/101]");
        System.out.println("\t\t\t 3) Add customer to a Queue.      -[ACQ/102] \t\t  4) Remove a Customer from Que. -[RCQ/103]");
        System.out.println("\t\t\t 5) Remove a served customer.     -[PCQ/104] \t\t  6) View Customers Sorted       -[VCS/105}");
        System.out.println("\t\t\t 7) Store Program Data into file. -[SPD/106] \t\t  8) Load Program Data from file -[LPD/107]");
        System.out.println("\t\t\t 9) View Remaining burgers Stock. -[STK/108] \t\t  10) Add burgers to Stock       -[AFS/109]");
        System.out.println(" \n\t\t\t 11) Exit the Program.  -[999/EXT]                                                                            ");
        System.out.println();
    }

    public static void main(String[] args){
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
//                    homepage();
                    break;
                case "102":
                case "ACQ":
                    addNewCustomer();
                    homepage();
                    break;
                case "103":
                case "RCQ":
                    //get the 'B' image;
                    break;
                case "104":
                case "PCQ":
                    //get the 'B' image;
                    break;
                case "105":
                case "VCS":
                    //get the 'B' image;
                    break;
                // (...)
                case "106":
                case "SPD":
                    //get the 'Z' image;
                    break;
                case "107":
                case "LPD":
                    //get the 'Z' image;
                    break;
                case "108":
                case "STK":
                    //get the 'Z' image;
                    break;
                case "109":
                case "AFS":
                    //get the 'Z' image;
                    break;

                default:
                    System.out.println("\t Invalid input...");

            }


        }

    }

}

