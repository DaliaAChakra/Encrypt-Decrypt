public class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  
    public static String encrypt(String plaintext, int shiftKey) {
      plaintext = plaintext.toLowerCase();
      StringBuilder encryptedText = new StringBuilder();
      for (int i = 0; i < plaintext.length(); i++) {
        char currentChar = plaintext.charAt(i);
        if (Character.isLetter(currentChar)) {
          int charPosition = ALPHABET.indexOf(currentChar);
          int shiftedPosition = (charPosition + shiftKey) % 26;
          char shiftedChar = ALPHABET.charAt(shiftedPosition);
          encryptedText.append(shiftedChar);
        } else {
          encryptedText.append(currentChar);
        }
      }
      return encryptedText.toString();
    }
  
    public static String decrypt(String ciphertext, int shiftKey) {
      StringBuilder decryptedText = new StringBuilder();
      for (int i = 0; i < ciphertext.length(); i++) {
        char currentChar = ciphertext.charAt(i);
        if (Character.isLetter(currentChar)) {
          int charPosition = ALPHABET.indexOf(Character.toLowerCase(currentChar));
          int shiftedPosition = (charPosition - shiftKey) % 26;
          if (shiftedPosition < 0) {
            shiftedPosition = ALPHABET.length() + shiftedPosition;
          }
          char shiftedChar = ALPHABET.charAt(shiftedPosition);
          if (Character.isUpperCase(currentChar)) {
            decryptedText.append(Character.toUpperCase(shiftedChar));
          } else {
            decryptedText.append(shiftedChar);
          }
        } else {
          decryptedText.append(currentChar);
        }
      }
      return decryptedText.toString();
    }
  }
  