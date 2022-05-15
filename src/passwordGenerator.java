import java.util.Scanner;

public class passwordGenerator {

    static int passwordLength = 0;

    public static void main(String[] args) {
        System.out.println("This program will generate password via lower and upper case and digits");
        System.out.println("Enter password length(min 3 chars):");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("You should enter a number");
        } else {
            passwordLength = scanner.nextInt() - 2;
            if (passwordLength < 4) {
                System.out.println("Your password should be longer");
            } else {
                System.out.println("Your password is:");
                String password = getPassword();
                System.out.println(password);
            }
        }
    }

    public static String getPassword() {
        String password = "";
        for (int i = 0; i < passwordLength; i++) {
            password += randomCharacter("abcdefghijklmnopqrstuvwxyz");
        }
        String randomDigit = randomCharacter("0123456789");
        password = insertAtRandom(password, randomDigit);
        String randomUpperCase = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        password = insertAtRandom(password, randomUpperCase);
        return password;
    }

    public static String randomCharacter(String chars) {
        int length = chars.length();
        int random = (int) (length * Math.random());
        return chars.substring(random, random + 1);
    }

    public static String insertAtRandom(String password, String charToInsert) {
        int length = password.length();
        int random = (int) ((length + 1) * Math.random());
        return password.substring(0, random) + charToInsert + password.substring(random);
    }
}
