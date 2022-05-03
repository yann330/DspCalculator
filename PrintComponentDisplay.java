import javax.swing.*;

public class PrintComponentDisplay extends JFrame {
    public PrintComponentDisplay(Component c) {
        // Display
        super(c.getName());
        int y = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        // Declaration of the labels
        JPanel contentPane = (JPanel) this.getContentPane();
        // Name
        JLabel title = new JLabel();
        title.setText("<html><h1>" + c.getName() + "</h1><html>");
        title.setBounds(0, y, 400, 30);
        contentPane.add(title);
        // ID
        JLabel id = new JLabel();
        id.setText("<html><h2>ID: " + c.getId() + "</h2><html>");
        id.setBounds(0, y = 40, 400, 30);
        contentPane.add(id);
        contentPane.add(new JLabel(""));
        this.setVisible(true);
    }
}