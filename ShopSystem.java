import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ShopSystem {

    static String[] customerNames = new String[0];
    static char[] q1 = {'X', 'X'};
    static char[] q2 = {'X', 'X', 'X'};
    static char[] q3 = {'X', 'X', 'X', 'X', 'X'};



    static String[][] Q1 = {{"", "X"}, {"", "X"}};
    static String[][] Q2 = {{"", "X"}, {"", "X"}, {"", "X"}};
    static String[][] Q3 = {{"", "X"}, {"", "X"}, {"", "X"}, {"", "X"}, {"", "X"}};

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

    public static void viewAllQueues() {
        Scanner input = new Scanner(System.in);

        String[] tempQ1 = {Q1[0][1], Q1[1][1]};
        String[] tempQ2 = {Q2[0][1], Q2[1][1], Q2[2][1]};
        String[] tempQ3 = {Q3[0][1], Q3[1][1], Q3[2][1], Q3[3][1], Q3[4][1]};

        System.out.println("*****************");
        System.out.println("  * Cashiers *");
        System.out.println("*****************");

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
//        String[] tempQ1 = {Q1[0][1], Q1[1][1]};
//        String[] tempQ2 = {Q2[0][1], Q2[1][1], Q2[2][1]};
//        String[] tempQ3 = {Q3[0][1], Q3[1][1], Q3[2][1], Q3[3][1], Q3[4][1]};
//
//
//        String[][] arrays = {tempQ1, tempQ2, tempQ3};
//
//        // Print the output
//        for (int i = 0; i < arrays.length; i++) {
//            for (int j = 0; j < arrays[i].length; j++) {
//                System.out.print(arrays[j][i] + " ");
//            }
//            System.out.println();
//        }

        System.out.print("Press any character to load the main menu... : ");
        input.next().charAt(0);

    }

    public static void viewAllEmptyQueues2() {
        Scanner input = new Scanner(System.in);

        System.out.println("*****************");
        System.out.println("  * empty Cashiers *");
        System.out.println("*****************");

        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                if (q1[0] == 'X' && q1[1] == 'X') {
                    System.out.print("q11111111111");
                    System.out.print("   " + q1[i]);
                    //System.out.print("   " + q1[i] + "  " + q2[i] + "  " + q3[i]);
                    //System.out.println();
                }
                if (q2[0] == 'X' && q2[1] == 'X' && q2[2] == 'X') {
                    System.out.print("q22222");
                    System.out.print("   " + q2[i]);
                }
                if (q3[0] == 'X' && q3[1] == 'X' && q3[2] == 'X' && q3[3] == 'X' && q3[4] == 'X') {
                    System.out.print("q3333   ");
                    System.out.print("   " + q3[i]);
                }

            } else if (i == 2) {
                System.out.println();
                System.out.print("bbbbbb");
                System.out.print("      " + q2[i] + "  " + q3[i]);
                System.out.println();
            } else {
                System.out.print("ccccccc");
                System.out.print("         " + q3[i]);
                System.out.println();

            }
        }

        System.out.print("Press any character to load the main menu... : ");
        input.next().charAt(0);

    }

    public static void viewAllEmptyQueues() {
        Scanner input = new Scanner(System.in);

        System.out.println("*****************");
        System.out.println("  * Cashiers *");
        System.out.println("*****************");

        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                //if(q1[0] == 'X' & q1[1] == 'X'){
                System.out.print("   " + q1[i] + "  " + q2[i] + "  " + q3[i]);
                System.out.println();
                //}
            } else if (i == 2) {
                //if (q2[0] == 'X' & q2[1] == 'X' & q2[2] == 'X'){
                System.out.print("      " + q2[i] + "  " + q3[i]);
                System.out.println();
                //}

            } else {
                //if (q3[0] == 'X' & q3[1] == 'X' & q3[2] == 'X' & q3[3] == 'X' & q3[4] == 'X'){
                System.out.print("         " + q3[i]);
                System.out.println();
                //}

            }

            System.out.print("Press any character to load the main menu... : ");
            input.next().charAt(0);
        }

    }

    public static void updateRemovearray(String[][] twoDArray){

        String[] arrayToRemove = {"", "X"};
        String[] arrayToAdd = {"", "X"};

        int indexToRemove = -1;
        for (int i = 0; i < twoDArray.length; i++) {
            if (Arrays.equals(twoDArray[i], arrayToRemove)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            String[][] tempArray = new String[twoDArray.length - 1][];
            System.arraycopy(twoDArray, 0, tempArray, 0, indexToRemove);
            System.arraycopy(twoDArray, indexToRemove + 1, tempArray, indexToRemove, twoDArray.length - indexToRemove - 1);
            twoDArray = tempArray;
        }
        String[][] newArray = Arrays.copyOf(twoDArray, twoDArray.length + 1);
        newArray[newArray.length - 1] = arrayToAdd;
        twoDArray = newArray;

        System.out.println("Customer removed & updated the que sucessfully..");

    }
    public static void removeCustomer(){
        Scanner input = new Scanner(System.in);

        outer:while(true){
            line();
            System.out.println("\t\t\t\t\t\t  REMOVE A CUSTOMER \t\t\t\t\t       ");
            line();
            System.out.println();

            System.out.println("Enter the que and the position you want to remove>> ");
            System.out.print("\t\tQue: ");
            int que = input.nextInt();
            System.out.print("\t\tPosition: ");
            int position = input.nextInt();


            if(que == 1 & position == 1){
                if (Q1[0][1] == "0") {
                    Q1[0][1] = "X";
                    Q1[0][0] = "";
                    updateRemovearray(Q1);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 1 & position == 2){
                if (Q1[1][1] == "0") {
                    Q1[1][1] = "X";
                    Q1[1][0] = "";
                    updateRemovearray(Q1);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 2 & position == 1){
                if (Q2[0][1] == "0") {
                    Q2[0][1] = "X";
                    Q2[0][0] = "";
                    updateRemovearray(Q2);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 2 & position == 2){
                if (Q2[1][1] == "0") {
                    Q2[1][1] = "X";
                    Q2[1][0] = "";
                    updateRemovearray(Q2);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 2 & position == 3){
                if (Q2[2][1] == "0") {
                    Q2[2][1] = "X";
                    Q2[2][0] = "";
                    updateRemovearray(Q2);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 3 & position == 1){
                if (Q3[0][1] == "0") {
                    Q3[0][1] = "X";
                    Q3[0][0] = "";
                    updateRemovearray(Q3);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 3 & position == 2){
                if (Q3[1][1] == "0") {
                    Q3[1][1] = "X";
                    Q3[1][0] = "";
                    updateRemovearray(Q3);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 3 & position == 3){
                if (Q3[2][1] == "0") {
                    Q3[2][1] = "X";
                    Q3[2][0] = "";
                    updateRemovearray(Q3);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 3 & position == 4){
                if (Q3[3][1] == "0") {
                    Q3[3][1] = "X";
                    Q3[3][0] = "";
                    updateRemovearray(Q3);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }
            else if(que == 3 & position == 5){
                if (Q3[4][1] == "0") {
                    Q3[4][1] = "X";
                    Q3[4][0] = "";
                    updateRemovearray(Q3);
                    break;
                }
                else {
                    System.out.println("No customer is in that position.");
                    continue;
                }
            }

            while (true) {
                System.out.print("Do you want to add another Customer (Y/N) : ");
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
                    } else {
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

        outer:while (true) {
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
                    viewAllEmptyQueues2();
                    //viewAllEmptyQueues();
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

