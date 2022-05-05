package InterfacePackage;

import ClassesPackage.Building;
import ClassesPackage.BurnerCentral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BurnerCentralDisplay extends JFrame implements ActionListener {
    private LinkedList<JButton> b;
    private LinkedList<BurnerCentral> res;

    public BurnerCentralDisplay()
    {
        super("Centrales à carburant ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Resolution
        this.setSize(500, 1080);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();


        //Get the sorted list containing the names of the wanted components
        LinkedList<Building> tmp= Building.alphabeticBuildings();
        this.res =  new LinkedList<BurnerCentral>();
        this.b = new LinkedList<JButton>();
        for(int i=0 ; i<tmp.size(); i++)
        {
            if(tmp.get(i).getClass().getName().equals("ClassesPackage.BurnerCentral"))
            {
                res.add((BurnerCentral) tmp.get(i));
            }
        }
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
            public void run() {

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
                new PrintBurnerCentralDisplay(res.get(i));
            }
        }
    }
}



