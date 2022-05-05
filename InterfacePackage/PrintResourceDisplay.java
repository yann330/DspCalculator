package InterfacePackage;

import ClassesPackage.Extractor;
import ClassesPackage.Extracts;
import ClassesPackage.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PrintResourceDisplay extends JFrame implements ActionListener{
    private LinkedList<JButton> b;
    private LinkedList<Extracts> res;

    public PrintResourceDisplay(Resource r){
        // Display
        super(r.getName());
        int y=0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.res = r.getAssociatedExtractors();
        b = new LinkedList<JButton>();

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
        // MinedBy
        JLabel minedby_t = new JLabel();
        minedby_t.setText("<html><h2><em>Minedby: </em></h2><html>");
        minedby_t.setBounds(0, y=y+20, 400, 30);
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
            contentPane.setLayout(new GridLayout(res.size()+3,1));
            for(int i=0; i<res.size(); i++){
                b.add(new JButton(res.get(i).getName()));
                contentPane.add(b.get(i));
            }
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
                new PrintExtractorDisplay(res.get(i));
            }
        }
    }

}


