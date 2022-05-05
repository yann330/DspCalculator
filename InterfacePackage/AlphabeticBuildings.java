package InterfacePackage;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.LinkedList;


import ClassesPackage.Building;

public class AlphabeticBuildings extends JFrame implements ActionListener
{
    private LinkedList<JButton> b;
    private LinkedList<Building> res;

    public AlphabeticBuildings()
    {
        super("Afficher les batiments par ordre alphabetique");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Resolution
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();

        //Get the sorted list containing the names of the wanted components
        this.res = Building.alphabeticBuildings();
        this.b = new LinkedList<JButton>();
        contentPane.setLayout(new GridLayout(res.size(),1));

        for(int i=0; i<res.size(); i++)
        {
            b.add(new JButton(res.get(i).getName()));
            contentPane.add(b.get(i));
        }

        for(int i=0; i< res.size(); i++)
        {
            b.get(i).addActionListener(this);
        }

        this.setVisible(true);
        JScrollPane pane = new JScrollPane(contentPane);
        this.setContentPane(pane);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
            }
        });
    }


    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        for(int i=0; i< res.size(); i++)
        {
            if(source.equals(this.b.get(i)))
            {
                new PrintBuildingDisplay(res.get(i));
            }
        }
    }
}
