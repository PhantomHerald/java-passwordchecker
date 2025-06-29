import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class PasswordStrengthChecker {
    private JFrame frame;
    private JPasswordField passwordField;
    private JLabel strengthLabel, recommendationLabel;
    private JProgressBar strengthBar;

    public PasswordStrengthChecker() {
        frame = new JFrame("Password Strength Checker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("Enter Your Password:", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));

        passwordField = new JPasswordField(20);
        passwordField.setHorizontalAlignment(JPasswordField.CENTER);

        strengthLabel = new JLabel("Strength: ", JLabel.CENTER);
        strengthLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));

        strengthBar = new JProgressBar(0, 100);
        strengthBar.setStringPainted(true);

        recommendationLabel = new JLabel("", JLabel.CENTER);
        recommendationLabel.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 12));

        frame.add(titleLabel);
        frame.add(passwordField);
        frame.add(strengthLabel);
        frame.add(strengthBar);
        frame.add(recommendationLabel);

        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { updateStrength(); }
            public void removeUpdate(DocumentEvent e) { updateStrength(); }
            public void changedUpdate(DocumentEvent e) { updateStrength(); }
        });

        frame.setVisible(true);
    }

    private void updateStrength() {
        String password = new String(passwordField.getPassword());
        int strength = calculateStrength(password);

        strengthBar.setValue(strength);
        if (strength < 30) {
            strengthBar.setForeground(Color.RED);
            strengthLabel.setText("Strength: Weak ❌");
            recommendationLabel.setText("Try adding numbers, symbols, and more length.");
        } else if (strength < 60) {
            strengthBar.setForeground(Color.ORANGE);
            strengthLabel.setText("Strength: Medium ⚠️");
            recommendationLabel.setText("Mix uppercase, lowercase, and special characters.");
        } else {
            strengthBar.setForeground(Color.GREEN);
            strengthLabel.setText("Strength: Strong ✅");
            recommendationLabel.setText("Good job! Your password is strong.");
        }
    }

    private int calculateStrength(String password) {
        int lengthScore = password.length() * 5;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        int complexityScore = (hasUpper ? 15 : 0) + (hasLower ? 10 : 0) + 
                              (hasDigit ? 20 : 0) + (hasSpecial ? 30 : 0);
        
        return lengthScore + complexityScore;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PasswordStrengthChecker::new);
    }
}
// add a for loop to check if there are repeated numbers and alo too simple passwords that are easy to find.  eg 1234567890, 1234, 11111111, 222222222,3333333333333 etc


/*import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();

        int strength = calculateStrength(password);
        if (strength < 30) {
            System.out.println("Weak password! Try adding numbers, special characters, or making it longer.");
        } else if (strength < 60) {
            System.out.println("Medium strength password! You can improve it by mixing uppercase, lowercase, and symbols.");
        } else {
            System.out.println("Strong password! Good job.");
        }
        System.out.println("Entropy Score: " + strength);
    }

    public static int calculateStrength(String password) {
        int lengthScore = password.length() * 5; // Length factor
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        int complexityScore = (hasUpper ? 15 : 0) + (hasLower ? 10 : 0) + 
                              (hasDigit ? 20 : 0) + (hasSpecial ? 30 : 0);
        
        return lengthScore + complexityScore;
    }
}*/
/* 

// this one uses a button and shows what was already typed
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordStrengthChecker {
    private JFrame frame;
    private JPasswordField passwordField;
    private JLabel strengthLabel, recommendationLabel;
    private JProgressBar strengthBar;
    private JButton showPasswordButton;
    private boolean isPasswordVisible = false;

    public PasswordStrengthChecker() {
        frame = new JFrame("Password Strength Checker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        JLabel titleLabel = new JLabel("Enter Your Password:", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        passwordField = new JPasswordField(20);
        passwordField.setHorizontalAlignment(JPasswordField.CENTER);

        strengthLabel = new JLabel("Strength: ", JLabel.CENTER);
        strengthLabel.setFont(new Font("Arial", Font.BOLD, 14));

        strengthBar = new JProgressBar(0, 100);
        strengthBar.setStringPainted(true);

        recommendationLabel = new JLabel("", JLabel.CENTER);
        recommendationLabel.setFont(new Font("Arial", Font.ITALIC, 12));

        showPasswordButton = new JButton("Show Password");
        showPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPasswordVisible) {
                    passwordField.setEchoChar('*');
                    showPasswordButton.setText("Show Password");
                } else {
                    passwordField.setEchoChar((char) 0);
                    showPasswordButton.setText("Hide Password");
                }
                isPasswordVisible = !isPasswordVisible;
            }
        });

        frame.add(titleLabel);
        frame.add(passwordField);
        frame.add(showPasswordButton);
        frame.add(strengthLabel);
        frame.add(strengthBar);
        frame.add(recommendationLabel);

        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { updateStrength(); }
            public void removeUpdate(DocumentEvent e) { updateStrength(); }
            public void changedUpdate(DocumentEvent e) { updateStrength(); }
        });

        frame.setVisible(true);
    }

    private void updateStrength() {
        String password = new String(passwordField.getPassword());
        int strength = calculateStrength(password);

        strengthBar.setValue(strength);
        if (strength < 30) {
            strengthBar.setForeground(Color.RED);
            strengthLabel.setText("Strength: Weak ❌");
            recommendationLabel.setText("Try adding numbers, symbols, and more length.");
        } else if (strength < 60) {
            strengthBar.setForeground(Color.ORANGE);
            strengthLabel.setText("Strength: Medium ⚠️");
            recommendationLabel.setText("Mix uppercase, lowercase, and special characters.");
        } else {
            strengthBar.setForeground(Color.GREEN);
            strengthLabel.setText("Strength: Strong ✅");
            recommendationLabel.setText("Good job! Your password is strong.");
        }
    }

    private int calculateStrength(String password) {
        int lengthScore = password.length() * 5;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        int complexityScore = (hasUpper ? 15 : 0) + (hasLower ? 10 : 0) + 
                              (hasDigit ? 20 : 0) + (hasSpecial ? 30 : 0);
        
        return lengthScore + complexityScore;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PasswordStrengthChecker::new);
    }
}
    */
