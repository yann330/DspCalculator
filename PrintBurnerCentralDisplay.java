import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PrintBurnerCentralDisplay extends JFrame {
    private LinkedList<IsCarburant> res;

    public PrintBurnerCentralDisplay(BurnerCentral b){
        // Display
        super(b.getName());
        int y = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.res = b.getCarburants();

        // Declaration of the labels
        JPanel contentPane = (JPanel) this.getContentPane();
        // Name
        JLabel title = new JLabel();
        title.setText("<html><h1>" + b.getName() + "</h1><html>");
        title.setBounds(0, y, 400, 10);
        // ID
        JLabel id = new JLabel();
        id.setText("<html><h2>ID: " + b.getId() + "</h2><html>");
        id.setBounds(0, y = 20, 400, 10);
        // Type
        JLabel type = new JLabel();
        type.setText("<html><h2>Type: "+ b.getType()+"</h2><html>");
        type.setBounds(0, y=40, 400, 10);
        // category
        JLabel category = new JLabel();
        category.setText("<html><h2>Type: "+ b.getCategory()+"</h2><html>");
        type.setBounds(0, y=60, 400, 10);
        // Adding the labels
        contentPane.add(title);
        contentPane.add(id);
        contentPane.add(type);
        contentPane.add(category);

        JLabel carburants = new JLabel();
        carburants.setText("<html><h2>Carburants:</h2><html>");
        carburants.setBounds(0, y =120, 400, 10);
        contentPane.add(carburants);

        JLabel[] carburant = new JLabel[res.size()];
        contentPane.setLayout(new GridLayout(res.size()+9,1));
        if(res.size()==0){
            this.setSize(400, 400);
            JLabel no_recipe_found = new JLabel();
            no_recipe_found.setText("No carburant found.");
            no_recipe_found.setBounds(0, y = 50, 400, 10);
            contentPane.add(no_recipe_found);
            contentPane.add(new Label(""));
        }
        else {
            for (int i = 0; i < res.size(); i++) {
                y=y+20;
                carburant[i] = new JLabel(res.get(i).getName());
                carburant[i].setBounds(0, y, 400, 30);
                contentPane.add(carburant[i]);
            }
        }
        this.setVisible(true);
        JScrollPane pane = new JScrollPane(contentPane);
        this.setContentPane(pane);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }


}