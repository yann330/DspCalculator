import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class AlphabeticBuildings extends JFrame implements ActionListener {
    private LinkedList<JButton> b;
    private LinkedList<Building> res;

    public AlphabeticBuildings(){
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

        for(int i=0; i<res.size(); i++){
            b.add(new JButton(res.get(i).getName()));
            contentPane.add(b.get(i));
        }

        for(int i=0; i< res.size(); i++){
            b.get(i).addActionListener(this);
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
            if(source.equals(this.b.get(i))){
                new PrintBuildingDisplay(res.get(i));
            }
        }
    }
}
