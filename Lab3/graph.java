package Lab3;

import javax.swing.*; // for jframe, jpanel, jbutton
import java.awt.*; //for graphics, color, basic stroke
import java.awt.geom.Line2D; //for drawing lines
import java.util.Random; //for rand color/heights

public class Graph extends JFrame { //extend jframe to rep the main window

    public Graph() {
        setTitle("Random Bar Chart");
        setSize(600, 650); // square size + extra length for button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program when closing the window

        GraphPanel graphPanel = new GraphPanel(); //create graph instance that draws the grid
        add(graphPanel, BorderLayout.CENTER); //add and center the graph in window

        JButton redrawButton = new JButton("Redraw"); //make redraw button
        redrawButton.addActionListener(e -> graphPanel.repaint()); //when button is clicked, call repaint from component class, which triggers paintComponent method
        add(redrawButton, BorderLayout.SOUTH); //add and place the button in bottom of the screen
    }

    //IMPORTANT for smoothness of the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Graph().setVisible(true)); //run gui in swingutil.invokeLater, create new graph instance, set visibility to true
    }
}

class GraphPanel extends JPanel {
    private static final int GRID_SIZE = 10;  // for a 10x10 grid
    private static final int BAR_COUNT = 12;  // # of bars
    private static final float LINE_THICKNESS = 10f;
    private static final int GRAPH_SIZE = 500; // fixed size of the graph (500x500px)
    private final Random random = new Random();

    @Override //override paintComponent from jcomponent class
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //clear canvas(the prev lines)
        Graphics2D g2d = (Graphics2D) g; //graphics -> graphics2d
        
        // get current w and h of the window/panel (for centering the graph)
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // centering the graph
        int startX = (panelWidth - GRAPH_SIZE) / 2;
        int startY = (panelHeight - GRAPH_SIZE) / 2;

        int cellSize = GRAPH_SIZE / GRID_SIZE; //make cell size based on graph size and grid size   
        g2d.setColor(Color.LIGHT_GRAY);

        // loop for drawing the graph, (no lines)
        for (int i = 0; i <= GRID_SIZE; i++) { 
            int pos = startX + i * cellSize;
            g2d.drawLine(pos, startY, pos, startY + GRAPH_SIZE); //vert graph lines
            g2d.drawLine(startX, startY + i * cellSize, startX + GRAPH_SIZE, startY + i * cellSize); //horz graph lines
        }

        // draw the (data) lines on the bar graph
        g2d.setStroke(new BasicStroke(LINE_THICKNESS)); //set line(stroke) size to 10f
        int barSpacing = GRAPH_SIZE / (BAR_COUNT + 1); // make unfiorm spaces btwn each bar
        
        // loop to draw the (data) lines on the graph
        for (int i = 0; i < BAR_COUNT; i++) {
            int x = startX + (i + 1) * barSpacing; //ensures consistent spacing (changes based on i)
            int y1 = startY + GRAPH_SIZE - 5; //set start height to the bottom of the grid (constant)
            int y2 = startY + GRAPH_SIZE - random.nextInt(GRAPH_SIZE); //randomize the height of the line
            g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))); //randomize the color of the line
            g2d.draw(new Line2D.Double(x, y1, x, y2)); //draws the line
        }
    }

}
