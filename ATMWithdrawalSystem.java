import java.util.Scanner;

public class ATMWithdrawalSystem {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin != CORRECT_PIN) {
                throw new SecurityException("Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = sc.nextDouble();

            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);

        } catch (SecurityException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Current Balance: " + balance);
            sc.close();
        }
    }
}
