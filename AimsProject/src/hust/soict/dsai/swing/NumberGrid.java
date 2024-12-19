package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple Swing application that creates a number grid with a display field.
 */
public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    /**
     * Constructs the NumberGrid frame with a display field and number buttons.
     */
    public NumberGrid() {
        // Create and configure the display field
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Create the panel for number buttons arranged in a 4x3 grid
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        // Get the content pane of the frame and set its layout to BorderLayout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Add the display field to the top (North) of the content pane
        cp.add(tfDisplay, BorderLayout.NORTH);

        // Add the panel with number buttons to the center of the content pane
        cp.add(panelButtons, BorderLayout.CENTER);

        // Set the font size of the display field and configure the frame
        tfDisplay.setFont(tfDisplay.getFont().deriveFont(24.0f));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(500, 400);
        setVisible(true);
    }

    /**
     * Adds number buttons, delete button, and reset button to the specified panel.
     *
     * @param panelButtons The panel to which buttons will be added.
     */
    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        // Add number buttons (1 to 9) to the panel
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Add delete button to the panel
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Add '0' button to the panel
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Add reset button to the panel
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    /**
     * ActionListener implementation for handling button clicks.
     */
    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                // Append clicked number to the display field text
                tfDisplay.setText(tfDisplay.getText() + button);
            }
            else if (button.equals("DEL")) {
                // Remove the last character from the display field text
                String s = tfDisplay.getText();
                s = s.substring(0, (s.length()-1));
                tfDisplay.setText(s);
            }
            else {
                // Clear the display field text for the 'C' (reset) button
                tfDisplay.setText("");
            }
        }
    }

    /**
     * Main method to start the NumberGrid application.
     */
    public static void main(String[] args) {
        new NumberGrid();
    }
}
