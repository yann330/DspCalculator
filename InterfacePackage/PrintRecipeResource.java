package InterfacePackage;

import ClassesPackage.Recipe;
import ClassesPackage.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PrintRecipeResource extends JFrame implements ActionListener {
    private LinkedList<JButton> btt;
    private LinkedList<Resource> res;

    public PrintRecipeResource(Recipe r){
        // Display
        super(r.getName());
        int y=0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        LinkedList<Resource> resources = new LinkedList<Resource>();
        this.res = Recipe.getRecipeResources(r.getId(), resources);
        this.btt = new LinkedList<JButton>();
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
        // Time
        JLabel time = new JLabel();
        time.setText("<html><h2><em>Time: </em>"+r.getTime()+"</h2><html>");
        time.setBounds(0,60, 400, 30 );
        // required resources
        JLabel required_resources = new JLabel();
        required_resources.setText("<html><h2><em>Required resources:</em></h2><html>");
        required_resources.setBounds(0, 80, 400, 30);
        // Adding the labels
        contentPane.add(title);
        contentPane.add(id);
        contentPane.add(time);
        contentPane.add(required_resources);

        // Display the required resources

        if(res.size()==0){
            JLabel no_recipe_found = new JLabel();
            no_recipe_found.setText("No resource found.");
            no_recipe_found.setBounds(0, y = 100, 400, 10);
            contentPane.add(no_recipe_found);
            contentPane.add(new Label(""));
        }
        else {
            contentPane.setLayout(new GridLayout(res.size()+5,1));
            for (int i = 0; i < res.size(); i++) {
                btt.add(new JButton(res.get(i).getName()));
                contentPane.add(btt.get(i));
            }
            for (int i = 0; i < res.size(); i++) {
                btt.get(i).addActionListener(this);
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

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        for(int i=0; i< res.size(); i++){
            if(source.equals(this.btt.get(i))){
                new PrintResourceDisplay(res.get(i));
            }
        }
    }
}


