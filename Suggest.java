import java.util.Random;

public class Suggest {

    static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lower = "abcdefghijklmnopqrstuvwxyz";
    static String numbers = "0123456789";
    static String special = "!@#$%^&*";

    public static String[] getSuggestions(String username, String password) {

        String[] suggestions = new String[3];

        for (int i = 0; i < 3; i++) {
            suggestions[i] = upgradePassword(username, password);
        }

        return suggestions;
    }

    private static String upgradePassword(String username, String password) {

        Random rand = new Random();
        StringBuilder upgraded = new StringBuilder(password);

        // Remove username if present
        if (upgraded.toString().toLowerCase().contains(username.toLowerCase())) {
            upgraded = new StringBuilder(
                upgraded.toString().replaceAll("(?i)" + username, "")
            );
        }

        // Add missing rules
        if (!upgraded.toString().matches(".*[A-Z].*")) {
            upgraded.insert(rand.nextInt(upgraded.length()+1),
                    upper.charAt(rand.nextInt(upper.length())));
        }

        if (!upgraded.toString().matches(".*[a-z].*")) {
            upgraded.insert(rand.nextInt(upgraded.length()+1),
                    lower.charAt(rand.nextInt(lower.length())));
        }

        if (!upgraded.toString().matches(".*[0-9].*")) {
            upgraded.insert(rand.nextInt(upgraded.length()+1),
                    numbers.charAt(rand.nextInt(numbers.length())));
        }

        if (!upgraded.toString().matches(".*[^a-zA-Z0-9].*")) {
            upgraded.insert(rand.nextInt(upgraded.length()+1),
                    special.charAt(rand.nextInt(special.length())));
        }

        // Ensure length >= 8
        while (upgraded.length() < 8) {
            upgraded.insert(rand.nextInt(upgraded.length()+1),
                    allChars().charAt(rand.nextInt(allChars().length())));
        }

        return upgraded.toString();
    }

    private static String allChars() {
        return upper + lower + numbers + special;
    }

    // test
    public static void main(String[] args) {
        String[] arr = getSuggestions("shivansh", "shiv123");

        for (String s : arr) {
            System.out.println(s);
        }
    }
}