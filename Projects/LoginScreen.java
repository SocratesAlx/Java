import javax.swing.*; // javax.swing package contains classes for creating a graphical user interface (GUI) in Java
import java.awt.*;  // java.awt package contains classes for creating user interfaces and for painting graphics and images
import java.awt.event.ActionEvent; // java.awt.event package provides interfaces and classes for dealing with different types of events fired by AWT components
import java.awt.event.ActionListener;


public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen() {
        // Set the frame properties
        setTitle("Login Screen");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Add Username Label and Text Field
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Add Password Label and Password Field
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Add Login Button
        loginButton = new JButton("Login");
        panel.add(loginButton);

        // Add an empty label to align the button to the center
        panel.add(new JLabel());

        // Add the panel to the frame
        add(panel);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    // Method to handle login logic
    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Simple validation (In real-world applications, validate against a database or other storage)
        if (username.equals("admin") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        // Create and display the login screen
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}

    
 