import javax.swing.*;

public class main {
    public static void main(String[] args) {

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Username"));
        panel.add(usernameField);

        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("Password"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Login",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            boolean[] errorsArr = logic.getError(username, password);
            boolean stregth = logic.getStrength(username, password); // true/false

            if (!stregth) {

                StringBuilder errors = new StringBuilder();

                if (!errorsArr[0]) errors.append("- Missing uppercase letter\n");
                if (!errorsArr[1]) errors.append("- Missing lowercase letter\n");
                if (!errorsArr[3]) errors.append("- Missing number\n");
                if (!errorsArr[2]) errors.append("- Missing special character\n");
                if (!errorsArr[4]) errors.append("- Must be at least 8 characters\n");
                if (!errorsArr[5]) errors.append("- Should not contain username\n");

                String[] suggestion = Suggest.getSuggestions(username, password);

                JOptionPane.showMessageDialog(null,
                        "Weak Password ❌\n\nIssues:\n"
                        + errors.toString()
                        + "\nSuggestions:\n"
                        + "1. " + suggestion[0] + "\n"
                        + "2. " + suggestion[1] + "\n"
                        + "3. " + suggestion[2],
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(null,
                        "Username and Password saved ✅",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
                    }
    }
}