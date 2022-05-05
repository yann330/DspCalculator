package InterfacePackage;

import ClassesPackage.Carburant;

import javax.swing.*;

public class PrintCarburantDisplay extends JFrame{
    public PrintCarburantDisplay(Carburant c){
        // Display
        super(c.getName());
        int y=0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        // Declaration of the labels
        JPanel contentPane = (JPanel) this.getContentPane();
        // Name
        JLabel title = new JLabel();
        title.setText("<html><h1>"+c.getName()+"</h1><html>");
        title.setBounds(0, y, 400, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(title);
        // ID
        JLabel id = new JLabel();
        id.setText("<html><h2><em>ID: </em>"+c.getId()+"</h2><html>");
        id.setBounds(0, y=40, 400, 30);
        contentPane.add(id);
        // Category
        JLabel category = new JLabel();
        category.setText("<html><h2><em>Category: </em>"+c.getCategory()+"</h2><html>");
        category.setBounds(0, y=60, 400, 30);
        contentPane.add(category);
        // Value
        JLabel value = new JLabel();
        value.setText("<html><h2><em>Value: </em>"+c.getValue()+"</h2><html>");
        value.setBounds(0, y=80, 400, 30);
        contentPane.add(value);
        contentPane.add(new JLabel(""));
        this.setVisible(true);
    }
}


