import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class FactoryDisplay extends JFrame implements ActionListener {
    private LinkedList<JButton> b;
    private LinkedList<Factory> res;

    public FactoryDisplay(){
        super("Les usines");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Resolution
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();


        //Get the sorted list containing the names of the wanted components
        LinkedList<Building> tmp= Building.alphabeticBuildings();
        this.res =  new LinkedList<Factory>();
        this.b = new LinkedList<JButton>();
        for(int i=0 ; i<tmp.size(); i++){
            if(tmp.get(i).getClass().getName().equals("Factory")){
                res.add((Factory) tmp.get(i));
            }
        }
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
                    new PrintFactoryDisplay(res.get(i));
                }
            }
        }
}



