import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class CardRandomizer {
    final private JFrame frame;
    final private JPanel cardPanel;
    final private JButton shuffleButton;
    private java.util.List<ImageIcon> cardIcons;

    public CardRandomizer() {
        frame = new JFrame("Card Randomizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Load all poker card images from the "cards" directory.
        cardIcons = new ArrayList<>();
        String[] suits = { "hearts", "diamonds", "clubs", "spades" };
        String[] ranks = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };

        // System.out.println(new File("Lab4", "cards").getParent());

        for (String suit : suits) {
            for (String rank : ranks) {
                String cardsDir = new File("Lab4", "cards").getPath();
                String filePath = cardsDir + File.separator + rank + "_of_" + suit + ".png";
                cardIcons.add(new ImageIcon(filePath));
            }
        }

        // Scale cards down.
        for (int i = 0; i < cardIcons.size(); i++) {
            Image originalImage = cardIcons.get(i).getImage();
            Image scaledImage = originalImage.getScaledInstance(50, 70, Image.SCALE_SMOOTH);
            cardIcons.set(i, new ImageIcon(scaledImage));
        }

        // Create a panel to display the cards in a grid layout.
        cardPanel = new JPanel(new GridLayout(0, 13, 5, 5));
        cardPanel.setBackground(new Color(10, 108, 3));
        displayCards();

        // Create a shuffle button that shuffles the cards when clicked.
        shuffleButton = new JButton("Shuffle Cards");
        shuffleButton.addActionListener((ActionEvent e) -> {
            Collections.shuffle(cardIcons);
            displayCards();
        });

        // Add the card panel inside a scroll pane and the button at the bottom.
        frame.add(new JScrollPane(cardPanel), BorderLayout.CENTER);
        frame.add(shuffleButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(948, 504);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // frame.setResizable(true);
    }

    // Method to refresh the card display on the GUI.
    private void displayCards() {
        cardPanel.removeAll();
        for (ImageIcon icon : cardIcons) {
            cardPanel.add(new JLabel(icon));
        }
        cardPanel.revalidate();
        cardPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CardRandomizer());
    }
}
