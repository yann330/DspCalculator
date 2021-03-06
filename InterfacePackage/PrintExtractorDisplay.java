package InterfacePackage;

import ClassesPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PrintExtractorDisplay extends JFrame implements ActionListener {
    private LinkedList<JButton> btt;
    private LinkedList<Resource> res;

    public PrintExtractorDisplay(Extracts e){
        // Display
        super(e.getName());
        if(e instanceof Extractor) {
            afficher_extractor((Extractor)e);
        }
        else if(e instanceof ExtractorNonElectric) {
            afficher_ExtractorNonElectric((ExtractorNonElectric)e);
        }
        else if(e instanceof EnergyProductionCentral) {
            afficher_EnergyProductionCentral((EnergyProductionCentral)e);
        }
    }
    public void afficher_extractor(Extractor e){
        int y = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.res = e.getExtractedResources();
        this.btt = new LinkedList<JButton>();
        // Declaration of the labels
        JPanel contentPane = (JPanel) this.getContentPane();
        // Name
        JLabel title = new JLabel();
        title.setText("<html><h1>" + e.getName() + "</h1><html>");
        title.setBounds(0, y, 400, 10);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // ID
        JLabel id = new JLabel();
        id.setText("<html><h2><em>ID: </em>" + e.getId() + "</h2><html>");
        id.setBounds(0, y = 20, 400, 10);
        // Type
        JLabel type = new JLabel();
        type.setText("<html><h2><em>Type: </em>"+ e.getType()+"</h2><html>");
        type.setBounds(0, y=40, 400, 10);
        // Speed
        JLabel speed = new JLabel();
        speed.setText("<html><h2><em>Speed: </em>"+ e.getSpeed()+"</h2><html>");
        speed.setBounds(0, y=60, 400, 10);
        // Usage
        JLabel usage = new JLabel();
        usage.setText("<html><h2><em>Usage: </em>"+e.getUsage()+"</h2><html>");
        usage.setBounds(0, y=80, 400, 10);
        // Drain
        JLabel drain = new JLabel();
        drain.setText("<html><h2><em>Drain: </em>"+e.getDrain()+"</h2><html>");
        usage.setBounds(0, y=100, 400, 10);
        // Mining_speed
        JLabel mining_speed = new JLabel();
        mining_speed.setText("<html><h2><em>Mining speed: </em>"+e.getMining_speed()+"</h2><html>");
        mining_speed.setBounds(0, y=120, 400, 10);
        // Adding the labels
        contentPane.add(title);
        contentPane.add(id);
        contentPane.add(type);
        contentPane.add(speed);
        contentPane.add(usage);
        contentPane.add(drain);
        contentPane.add(mining_speed);
        // Associated Recipes
        JLabel recipes_title = new JLabel();
        recipes_title.setText("<html><h2><em>Associated resources:</em></h2><html>");
        recipes_title.setBounds(0, y =140, 400, 10);
        contentPane.add(recipes_title);

        JLabel[] recipes = new JLabel[res.size()];
        contentPane.setLayout(new GridLayout(res.size()+8,1));
        if(res.size()==0){
            contentPane.setLayout(new GridLayout(res.size()+10,1));
            JLabel no_recipe_found = new JLabel();
            no_recipe_found.setText("No resource found.");
            no_recipe_found.setBounds(0, y = 160, 400, 10);
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
    public void afficher_ExtractorNonElectric(ExtractorNonElectric e){
        int y = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.res = e.getExtractedResources();
        this.btt = new LinkedList<JButton>();
        // Declaration of the labels
        JPanel contentPane = (JPanel) this.getContentPane();
        // Name
        JLabel title = new JLabel();
        title.setText("<html><h1>" + e.getName() + "</h1><html>");
        title.setBounds(0, y, 400, 10);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // ID
        JLabel id = new JLabel();
        id.setText("<html><h2><em>ID: </em>" + e.getId() + "</h2><html>");
        id.setBounds(0, y = 20, 400, 10);
        // Mining_speed
        JLabel mining_speed = new JLabel();
        mining_speed.setText("<html><h2><em>Mining speed: </em>"+e.getMining_speed()+"</h2><html>");
        mining_speed.setBounds(0, y=40, 400, 10);
        // Adding the labels
        contentPane.add(title);
        contentPane.add(id);
        contentPane.add(mining_speed);
        // Associated Recipes
        JLabel recipes_title = new JLabel();
        recipes_title.setText("<html><h2><em>Associated resources:</em></h2><html>");
        recipes_title.setBounds(0, y =60, 400, 10);
        contentPane.add(recipes_title);

        JLabel[] recipes = new JLabel[res.size()];
        if(res.size()==0){
            JLabel no_recipe_found = new JLabel();
            no_recipe_found.setText("No resource found.");
            no_recipe_found.setBounds(0, y = 80, 400, 10);
            contentPane.add(no_recipe_found);
            contentPane.add(new Label(""));
        }
        else {
            contentPane.setLayout(new GridLayout(res.size()+4,1));
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
    public void afficher_EnergyProductionCentral(EnergyProductionCentral e){
        int y = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.res = e.getExtractedResources();
        this.btt = new LinkedList<JButton>();
        // Declaration of the labels
        JPanel contentPane = (JPanel) this.getContentPane();
        // Name
        JLabel title = new JLabel();
        title.setText("<html><h1>" + e.getName() + "</h1><html>");
        title.setBounds(0, y, 400, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // ID
        JLabel id = new JLabel();
        id.setText("<html><h2><em>ID: </em>" + e.getId() + "</h2><html>");
        id.setBounds(0, y = 20, 400, 30);
        // Type
        JLabel type = new JLabel();
        type.setText("<html><h2><em>Type: </em>"+ e.getType()+"</h2><html>");
        type.setBounds(0, y=40, 400, 30);
        // Adding the labels
        contentPane.add(title);
        contentPane.add(id);
        contentPane.add(type);
        // Associated Recipes
        JLabel recipes_title = new JLabel();
        recipes_title.setText("<html><h2><em>Associated resources:</em></h2><html>");
        recipes_title.setBounds(0, y =60, 400, 30);
        contentPane.add(recipes_title);

        JLabel[] recipes = new JLabel[res.size()];
        if(res.size()==0){
            JLabel no_recipe_found = new JLabel();
            no_recipe_found.setText("No resource found.");
            no_recipe_found.setBounds(0, y = 80, 400, 30);
            contentPane.add(no_recipe_found);
            contentPane.add(new Label(""));
        }
        else {
            contentPane.setLayout(new GridLayout(res.size()+4,1));
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