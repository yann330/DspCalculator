package InterfacePackage;

import ClassesPackage.Recipe;

import javax.swing.*;

public class RecipeConsumptionDisplay extends JFrame{
    public RecipeConsumptionDisplay(Recipe r) {
        // Display
        super(r.getName());
        int y = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 70);
        this.setLocationRelativeTo(null);
        // Declaration of the labels
        JPanel contentPane = (JPanel) this.getContentPane();
        // Name
        JLabel title = new JLabel();
        title.setText("<html><h1>" + r.getName() + "</h1><html>");
        title.setBounds(0, y, 400, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        //Consumptions
        JLabel cons = new JLabel();
        title.setText("<html><h1>Consumption: " + Recipe.recipeTotalConsommation(r.getId()) + "</h1><html>");
        title.setBounds(0, y, 400, 30);
        //Adding the labels
        contentPane.add(title);
        contentPane.add(cons);
        this.setVisible(true);
    }
}
