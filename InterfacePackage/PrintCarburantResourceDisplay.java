package InterfacePackage;

import ClassesPackage.CarburantResource;

import javax.swing.*;
import java.util.LinkedList;

public class PrintCarburantResourceDisplay extends JFrame{

    private LinkedList<String> res;

    public PrintCarburantResourceDisplay(CarburantResource r){
        // Display
        super(r.getName());
        int y=0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.res = r.getMinedby();

        // Declaration of the labels
        JPanel contentPane = (JPanel) this.getContentPane();
        // Name
        JLabel title = new JLabel();
        title.setText("<html><h1>"+r.getName()+"</h1><html>");
        title.setBounds(0, y, 400, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        // ID
        JLabel id = new JLabel();
        id.setText("<html><h2><em>ID: </em>"+r.getId()+"</h2><html>");
        id.setBounds(0, y=40, 400, 30);
        // Category
        JLabel category = new JLabel();
        category.setText("<html><h2><em>Category: </em>"+r.getCategory()+"</h2><html>");
        category.setBounds(0, y=60, 400, 30);
        contentPane.add(category);
        // Value
        JLabel value = new JLabel();
        value.setText("<html><h2><em>Value: </em>"+r.getValue()+"</h2><html>");
        value.setBounds(0, y=80, 400, 30);
        contentPane.add(value);
        // MinedBy
        JLabel minedby_t = new JLabel();
        minedby_t.setText("<html><h2><em>Minedby: </em></h2><html>");
        minedby_t.setBounds(0, y=100, 400, 30);
        // Adding the labels
        // Titles
        contentPane.add(title);
        contentPane.add(id);
        contentPane.add(minedby_t);
        // Minedby
        JLabel[] minedby = new JLabel[res.size()];
        if((r.getMinedby().size()==0)){
            y=y+20;
            JLabel no_minedby= new JLabel();
            no_minedby.setText("No extractor found.");
            no_minedby.setBounds(0,y, 400, 30);
            contentPane.add(no_minedby);
        }
        else {
            for (int i = 0; i < res.size(); i++) {
                y=y+20;
                minedby[i]=new JLabel(res.get(i));
                minedby[i].setBounds(0, y, 400, 30);
                contentPane.add(minedby[i]);
            }
        }
        contentPane.add(new JLabel(""));
        this.setVisible(true);
        JScrollPane pane = new JScrollPane(contentPane);
        this.setContentPane(pane);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }


}


