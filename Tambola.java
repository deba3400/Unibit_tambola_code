/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][][] tickets = generateTambolaTickets(3);
        printTickets(tickets);
    }

    public static int[][][] generateTambolaTickets(int numTickets) {
        int[][][] tickets = new int[numTickets][3][9];

        for (int t = 0; t < numTickets; t++) {
            List<Integer>[] columns = new List[9];
            for (int i = 0; i < 9; i++) {
                columns[i] = new ArrayList<>();
            }

            
            for (int num = 1; num <= 90; num++) {
                int col = num / 10;
                if (col == 9) col--; 
                columns[col].add(num);
            }

            
            for (List<Integer> column : columns) {
                Collections.shuffle(column);
            }

        
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 9; col++) {
                    if (columns[col].isEmpty()) {
                        tickets[t][row][col] = 0;  // Blank cell
                    } else {
                        tickets[t][row][col] = columns[col].remove(0);
                    }
                }
            }
        }
        return tickets;
    }

    public static void printTickets(int[][][] tickets) {
        for (int t = 0; t < tickets.length; t++) {
            System.out.println("Ticket " + (t + 1) + ":");
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 9; col++) {
                    if(row==col || row+2==col|| row+4==col|| row+6==col){
                         System.out.print("x"+ "\t");
                    }
                    
                    else{
                    System.out.print(tickets[t][row][col] + "\t");}
                    
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
