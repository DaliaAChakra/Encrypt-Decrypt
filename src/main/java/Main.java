import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Caesar Cipher Encryption and Decryption");

    while (true) {
        System.out.println("\nMenu:");
        System.out.println("1. Encrypt Text");
        System.out.println("2. Decrypt Text");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

      if(choice > 3 || choice < 1){
        System.out.println("Invalid choice. Please try again.");
        continue;
      }
       
        switch (choice) {
            case 1:
                System.out.print("Enter text for Encryption: ");
                String plaintext = scanner.nextLine();
                System.out.print("Enter shift key (number between 0 and 25): ");
                int shiftKeyEncrypt = scanner.nextInt();
                scanner.nextLine(); 

                if (shiftKeyEncrypt < 0 || shiftKeyEncrypt > 25) {
                    System.out.println("Shift key must be between 0 and 25.");
                    break;
                }
                String encryptedText = CaesarCipher.encrypt(plaintext, shiftKeyEncrypt);
                System.out.println("Encrypted Text: " + encryptedText);
                break;
            case 2:
                System.out.print("Enter text to decrypt: ");
                String ciphertext = scanner.nextLine();
                System.out.print("Enter shift key (number between 0 and 25): ");
                int shiftKeyDecrypt = scanner.nextInt();
                scanner.nextLine();  // Consume newline character
                if (shiftKeyDecrypt < 0 || shiftKeyDecrypt > 25) {
                    System.out.println("Shift key must be between 0 and 25.");
                    break;
                }
                String decryptedText = CaesarCipher.decrypt(ciphertext, shiftKeyDecrypt);
                System.out.println("Decrypted Text: " + decryptedText);
                break;
            case 3:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
  }
}
