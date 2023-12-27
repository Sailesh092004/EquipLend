import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EquipLend {
    private final JFrame frame;
    private JTextField emailTextField;
    private JPasswordField passwordTextField;
    private JTextField nameTextField;
    private JTextField mobileNumberTextField;
    private JPasswordField confirmPasswordTextField;

    public EquipLend() {
        frame = new JFrame("Equipment Lending and Rental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel, BorderLayout.CENTER);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel descriptionLabel = new JLabel("<html>Welcome to the Equipment Lending and Rental System!<br/>Please select an option below:</html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(descriptionLabel, constraints);

        emailTextField = new JTextField(20);
        passwordTextField = new JPasswordField(20);
        nameTextField = new JTextField(20);
        mobileNumberTextField = new JTextField(20);
        confirmPasswordTextField = new JPasswordField(20);

        JButton loginButton = createButton("Login");
        constraints.gridy = 1;
        panel.add(loginButton, constraints);

        JButton signupButton = createButton("Sign Up");
        constraints.gridy = 2;
        panel.add(signupButton, constraints);

        frame.setVisible(true);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(120, 40));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (label.equals("Login")) {
                    openLoginFrame();
                } else if (label.equals("Sign Up")) {
                    openSignupFrame();
                }
            }
        });
        return button;
    }
    /*   public addLabelAndField(JPanel panel, GridBagConstraints constraints, String label, int row, JTextField textField) {
        JLabel fieldLabel = new JLabel(label);
        constraints.gridx = 0;
        constraints.gridy = row;
        panel.add(fieldLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = row;
        panel.add(textField, constraints);
    }
*/
    private void openLoginFrame() {
        JFrame loginFrame = new JFrame("Login Page");
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginFrame.add(loginPanel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        addLabelAndField(loginPanel, constraints, "Email:", 0, emailTextField);
        addLabelAndField(loginPanel, constraints, "Password:", 1, passwordTextField);

        JButton submitButton = new JButton("Submit");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        loginPanel.add(submitButton, constraints);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String password = new String(passwordTextField.getPassword());

                // Add logic to check login credentials here
                // For example:
                // if (checkLoginCredentials(email, password)) {
                //     JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                //     openWelcomeFrame("User");
                //     loginFrame.dispose();
                // } else {
                //     JOptionPane.showMessageDialog(loginFrame, "Login failed. Please check your credentials.");
                // }
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // You can bypass the database check and directly open the welcome frame.
                openWelcomeFrame("User");
                loginFrame.dispose();
            }
        });


        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

   /*  private void addLabelAndField(JPanel panel, GridBagConstraints constraints, String label, int row, JTextField textField) {
        JLabel fieldLabel = new JLabel(label);
        constraints.gridx = 0;
        constraints.gridy = row;
        panel.add(fieldLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = row;
        panel.add(textField, constraints);
    }*/

    private void openSignupFrame() {
        JFrame signupFrame = new JFrame("Sign Up Page");
        signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel signupPanel = new JPanel(new GridBagLayout());
        signupFrame.add(signupPanel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        addLabelAndField(signupPanel, constraints, "Name:", 0, nameTextField);
        addLabelAndField(signupPanel, constraints, "Email:", 1, emailTextField);
        addLabelAndField(signupPanel, constraints, "Mobile Number:", 2, mobileNumberTextField);

        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"Student", "Faculty", "Vendor"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        constraints.gridx = 0;
        constraints.gridy = 3;
        signupPanel.add(roleLabel, constraints);
        constraints.gridx = 1;
        signupPanel.add(roleComboBox, constraints);

        addLabelAndField(signupPanel, constraints, "Password:", 4, passwordTextField);
        addLabelAndField(signupPanel, constraints, "Re-enter Password:", 5, confirmPasswordTextField);

        JButton submitButton = new JButton("Submit");
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        signupPanel.add(submitButton, constraints);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String mobileNumber = mobileNumberTextField.getText();
                String role = roleComboBox.getSelectedItem().toString();
                String password = new String(passwordTextField.getPassword());
                String confirmPassword = new String(confirmPasswordTextField.getPassword());

                // Add logic to register the user here
                // For example:
                // if (registerUser(name, email, mobileNumber, role, password, confirmPassword)) {
                //     JOptionPane.showMessageDialog(signupFrame, "Registration successful!");
                //     openWelcomeFrame(name);
                //     signupFrame.dispose();
                // } else {
                //     JOptionPane.showMessageDialog(signupFrame, "Registration failed. Please check your input.");
                // }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Bypass user registration logic and directly open the welcome frame.
                openWelcomeFrame(nameTextField.getText());
                signupFrame.dispose();
            }
        });


        signupFrame.pack();
        signupFrame.setLocationRelativeTo(null);
        signupFrame.setVisible(true);
    }

    /**
     * @param userName
     */
    private void openWelcomeFrame(String userName) {
        JFrame welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel welcomePanel = new JPanel(new GridBagLayout());
        welcomeFrame.add(welcomePanel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel greetingLabel = new JLabel("Welcome, " + userName + "!");
        greetingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        greetingLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        welcomePanel.add(greetingLabel, constraints);

        JLabel questionLabel = new JLabel("Are you looking to lend or borrow?");
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton lendButton = new JButton("Lend");
        JButton borrowButton = new JButton("Borrow");

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        welcomePanel.add(questionLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.EAST;
        welcomePanel.add(lendButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        welcomePanel.add(borrowButton, constraints);

        lendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLendItemsPage();
                welcomeFrame.dispose();
            }
        });

        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBorrowFrame();
                welcomeFrame.dispose();
            }
        });

        welcomeFrame.pack();
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setVisible(true);
    }

    private void openLendItemsPage() {
        JFrame lendingFrame = new JFrame("Lend a Product");
        lendingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel lendingPanel = new JPanel(new GridBagLayout());
        lendingFrame.add(lendingPanel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel productNameLabel = new JLabel("Product Name:");
        JTextField productNameField = new JTextField(20);
        addLabelAndField(lendingPanel, constraints, "Product Name:", 0, productNameField);

        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField(20);
        addLabelAndField(lendingPanel, constraints, "Description:", 1, descriptionField);

        JLabel conditionLabel = new JLabel("Condition:");
        JTextField conditionField = new JTextField(20);
        addLabelAndField(lendingPanel, constraints, "Condition:", 2, conditionField);

        JLabel costLabel = new JLabel("Cost per day:");
        JTextField costField = new JTextField(20);
        addLabelAndField(lendingPanel, constraints, "Cost per day:", 3, costField);

        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {"Electronics", "Mobility", "Books", "Hardware Tools", "Stationary", "Sports Gear"};
        JComboBox<String> categoryComboBox = new JComboBox<>(categories);
        constraints.gridx = 0;
        constraints.gridy = 4;
        lendingPanel.add(categoryLabel, constraints);
        constraints.gridx = 1;
        lendingPanel.add(categoryComboBox, constraints);

        JButton submitButton = new JButton("Submit");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        lendingPanel.add(submitButton, constraints);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = productNameField.getText();
                String description = descriptionField.getText();
                String condition = conditionField.getText();
                String costPerDay = costField.getText();
                String selectedCategory = categoryComboBox.getSelectedItem().toString();

                // Add your logic to save the product to your database or perform other actions here
                // For this example, we will just display the entered details
                String message = "Product Name: " + productName + "\nDescription: " + description + "\nCondition: " + condition
                        + "\nCost per day: " + costPerDay + "\nCategory: " + selectedCategory;
                JOptionPane.showMessageDialog(lendingFrame, message);

                // Optionally, you can clear the fields after submission
                productNameField.setText("");
                descriptionField.setText("");
                conditionField.setText("");
                costField.setText("");
            }
        });

        lendingFrame.pack();
        lendingFrame.setLocationRelativeTo(null);
        lendingFrame.setVisible(true);
    }

    private void addLabelAndField(JPanel panel, GridBagConstraints constraints, String label, int row, JTextField textField) {
        JLabel fieldLabel = new JLabel(label);
        constraints.gridx = 0;
        constraints.gridy = row;
        panel.add(fieldLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = row;
        panel.add(textField, constraints);
    }

    private void openBorrowFrame() {
        JFrame borrowFrame = new JFrame("Borrow Items");
        borrowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel borrowPanel = new JPanel(new BorderLayout());
        borrowFrame.add(borrowPanel);

        JTextArea borrowDescription = new JTextArea();
        borrowDescription.setText("Welcome to the Borrow Items page. Use the search box below to find items you want to borrow.");
        borrowDescription.setFont(new Font("Arial", Font.PLAIN, 16));
        borrowDescription.setWrapStyleWord(true);
        borrowDescription.setLineWrap(true);
        borrowDescription.setOpaque(false);
        borrowDescription.setEditable(false);
        borrowPanel.add(borrowDescription, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        borrowPanel.add(searchPanel, BorderLayout.CENTER);

        Border searchBorder = BorderFactory.createTitledBorder("Search for Items");
        searchPanel.setBorder(searchBorder);

        JTextField searchField = new JTextField(20);
        searchField.setMaximumSize(searchField.getPreferredSize());
        JButton searchButton = new JButton("Search");

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
// From here
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchField.getText();

                // Implement your search logic here, and display the results to the user
                // For this example, we will just display the search query
                JOptionPane.showMessageDialog(borrowFrame, "Searching for: " + searchQuery);

                // Simulate search results (replace with your actual search logic)
                List<String> searchResults = new ArrayList<>();
                searchResults.add("Result 1");
                searchResults.add("Result 2");

                // Call the method to display the search results
                displaySearchResults(searchResults);
            }
        });

//Till here
        borrowFrame.pack();
        borrowFrame.setLocationRelativeTo(null);
        borrowFrame.setVisible(true);
    }
    private void displaySearchResults(List<String> searchResults) {
        JFrame resultFrame = new JFrame("Search Results");
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to display search results
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));

        JLabel countLabel = new JLabel("The following items are found:");
        countLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultPanel.add(countLabel);

        // Add search results to the panel
        for (String result : searchResults) {
            JLabel resultLabel = new JLabel(result);
            resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            resultPanel.add(resultLabel);
        }

        JScrollPane resultScrollPane = new JScrollPane(resultPanel);
        resultFrame.add(resultScrollPane);

        resultFrame.setSize(400, 300); // Adjust the size as needed
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EquipLend();
            }
        });
    }
}
