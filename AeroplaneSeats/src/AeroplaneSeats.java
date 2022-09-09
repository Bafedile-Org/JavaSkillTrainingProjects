
import java.util.Scanner;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class AeroplaneSeats {

    public static void main(String[] args) {
        String[][] seats = new String[7][4];
        char[] seatAlphas = {'A', 'B', 'C', 'D'};
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int ans;
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                if ((row % 2 == 0) && (col % 3 == 0)) {
                    seats[row][col] = "X";
                } else {
                    seats[row][col] = String.valueOf(seatAlphas[col]);
                }
            }
        }

        do {
            displayArray(seats);
            System.out.print("Please enter your desired seat: ");
            sb.append(input.next().toUpperCase());
            
            int seat = Integer.parseInt("" + sb.charAt(0));
            if (seat>=0 && seat < 8) {
                switch (seat) {
                    case 1:
                        setSeat(sb, seat, seats);
                        break;
                    case 2:
                        setSeat(sb, seat, seats);
                        break;
                    case 3:
                        setSeat(sb, seat, seats);
                        break;
                    case 4:
                        setSeat(sb, seat, seats);
                        break;
                    case 5:
                        setSeat(sb, seat, seats);
                        break;
                    case 6:
                        setSeat(sb, seat, seats);
                        break;
                    default:
                        setSeat(sb, seat, seats);
                        break;

                }
            }

            sb.delete(0, sb.length());
            
            System.out.print("Enter 1 to continue or 2 to exit the program: ");
            ans = input.nextInt();
            if(ans==2){
                System.out.println("===============================================\n"
                        + "\t\tTHANK YOU FOR BOOKING\n"
                        + "===============================================");
            }
        } while (ans == 1);
    }

    public static void setSeat(StringBuilder sb, int seat, String[][] seats) {
        char col = sb.charAt(1);
        seat = seat -1;
        switch (col) {
            case 'A':
                if ("X".equals(seats[seat][0])) {
                    System.out.println("Seat occupied!");
                    return;
                }
                seats[seat][0] = "X";
                break;
            case 'B':
                if ("X".equals(seats[seat][1])) {
                    System.out.println("Seat occupied!");
                    return;
                }
                seats[seat][1] = "X";
                break;
            case 'C':
                if ("X".equals(seats[seat][2])) {
                    System.out.println("Seat occupied!");
                    return;
                }
                seats[seat][1] = "X";
                break;
            default:
                if ("X".equals(seats[seat][3])) {
                    System.out.println("Seat occupied!");
                    return;
                }
                seats[seat][2] = "X";
        }
    }

    public static void displayArray(String[][] seats) {
        System.out.println("\n====================================================\n"
                + "\t\tAVAILABLE SEATS\n"
                + "====================================================");
        for (int row = 0; row < seats.length; row++) {
            System.out.printf("%-5d", (row + 1));
            for (String seat : seats[row]) {
                System.out.printf("%-5s", seat);
            }
            System.out.println();
        }
    }

}
