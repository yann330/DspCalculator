import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PrintBuildingDisplay extends JFrame implements ActionListener {
    private LinkedList<JButton> btt;
    private LinkedList<Recipe> res;

    public PrintBuildingDisplay(Building b){
        // Display
        super(b.getName());
        int y = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.res = Recipe.alphabeticRecipies();
        this.btt = new LinkedList<JButton>();
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
        // Adding the labels
        contentPane.add(title);
        contentPane.add(id);
        // Associated Recipes
        JLabel recipes_title = new JLabel();
        recipes_title.setText("<html><h2>Associated recipes:</h2><html>");
        recipes_title.setBounds(0, y = 30, 400, 10);
        contentPane.add(recipes_title);
        // Separator
        this.res = b.getAssociatedRecipes();
        JLabel[] recipes = new JLabel[res.size()];
        contentPane.setLayout(new GridLayout(res.size()+5,1));
        if(res.size()==0){
            this.setSize(400, 300);
            JLabel no_recipe_found = new JLabel();
            no_recipe_found.setText("No recipe found.");
            no_recipe_found.setBounds(0, y = 50, 400, 10);
            contentPane.add(no_recipe_found);
            contentPane.add(new Label(""));
        }
        else {
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
                new PrintRecipeDisplay(res.get(i));
            }
        }
    }
}

