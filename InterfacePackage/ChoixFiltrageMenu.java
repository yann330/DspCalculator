package InterfacePackage;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;


import InterfacePackage.AlphabeticBuildings;
import InterfacePackage.AlphabeticRecipes;
import InterfacePackage.BurnerCentralDisplay;


public class ChoixFiltrageMenu extends JFrame implements ActionListener {
    private JButton p1;
    private JButton p2;
    private JButton p3;
    private JButton p4;
    private JButton p5;
    private JButton p6;
    private JButton p7;
    private JButton p8;
    private JButton p9;

    public ChoixFiltrageMenu() {
        //On ouvre la fenêtre avec les possibilités données dans le projet
        super("DspCalculator");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Résolution de la fenêtre
        this.setSize(900, 1080);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new GridLayout(9, 1));
        //Possibilités de filtrage:
        p1 = new JButton("Afficher la liste des composants non bâtiment par ordre alphabétique.");
        p2 = new JButton(("Afficher la liste des bâtiments par ordre alphabétique."));
        p3 = new JButton(("Afficher la liste des recettes par ordre alphabétique."));
        p4 = new JButton(("Afficher, pour une usine donnée, toutes les recettes qui lui sont associées."));
        p5 = new JButton(("Afficher, pour un extracteur donné, toutes les ressources qu’il peut extraire"));
        p6 = new JButton(("Afficher, pour une centrale à carburant donnée, tous les carburants qu’elle peut prendre en entrée"));
        p7 = new JButton(("Afficher, pour une recette spécifique, l’ensemble des composants de type ressource qui sont nécessaires pour l’élaboration de la recette."));
        p8 = new JButton(("Afficher, pour une recette donnée, la consommation électrique totale requise par cette recette à partir des ressources de base."));
        p9 = new JButton(("Quitter"));
        //Pour l'exécution de chaque choix de filtrage
        p1.addActionListener(this);
        p2.addActionListener(this);
        p3.addActionListener(this);
        p4.addActionListener(this);
        p5.addActionListener(this);
        p6.addActionListener(this);
        p7.addActionListener(this);
        p8.addActionListener(this);
        p9.addActionListener(this);

        //On ajoute les bouttons à la fenêtre de choix de flitrage
        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p4);
        contentPane.add(p5);
        contentPane.add(p6);
        contentPane.add(p7);
        contentPane.add(p8);
        contentPane.add(p9);

    }


    public void actionPerformed(ActionEvent e){
        Object source= e.getSource();
        if(source==p1){
            new NotBuildingDisplay();
        }
        if(source==p2){
            new AlphabeticBuildings();
        }
        if(source==p3){
            new AlphabeticRecipes();
        }
        if(source==p4){
            new FactoryDisplay();
        }
        if(source==p5){
            new ExtractorDisplay();
        }
        if(source==p6){
            new BurnerCentralDisplay();
        }
        if(source==p7){
            new RecipeResource();
        }
        if(source==p8){
            new RecipeConsumption();
        }
        if(source==p9){
            System.exit(0);
        }

    }
}





