import javax.swing.*;
import java.awt.*;

public class PrintRecipeDisplay extends JFrame{
        public PrintRecipeDisplay(Recipe r){
            // Display
            super(r.getName());
            int y=0;
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setSize(400, 400);
            this.setLocationRelativeTo(null);
            // Declaration of the labels
            JPanel contentPane = (JPanel) this.getContentPane();
            // Name
            JLabel title = new JLabel();
            title.setText("<html><h1>"+r.getName()+"</h1><html>");
            title.setBounds(0, y, 400, 30);
            // ID
            JLabel id = new JLabel();
            id.setText("<html><h2>ID: "+r.getId()+"</h2><html>");
            id.setBounds(0, y=40, 400, 30);
            // Time
            JLabel time = new JLabel();
            time.setText("<html><h2>Time: "+r.getTime()+"</h2><html>");
            time.setBounds(0,60, 400, 30 );
            // Producers
            JLabel prod_title = new JLabel();
            prod_title.setText("<html><h2>Producers:</h2><html>");
            prod_title.setBounds(0, 80, 400, 30);
            JLabel[] producers = new JLabel[r.getProducers().size()];
            // In
            JLabel in_title = new JLabel();
            in_title.setText("<html><h2>In:</h2><html>");
            JLabel[] in = new JLabel[r.getIn().size()];
            y=80;
            // Out
            JLabel out_title = new JLabel();
            out_title.setText("<html><h2>Out:</h2><html>");
            JLabel[] out = new JLabel[r.getOut().size()];
            // Adding the labels
            // Titles
            contentPane.add(title);
            contentPane.add(id);
            //Time
            contentPane.add(time);
            contentPane.add(prod_title);
            // Producers
            for(int i=0; i<r.getProducers().size(); i++){
                y=y+20;
                producers[i] = new JLabel(r.getProducers().get(i).getName());
                producers[i].setBounds(0,y, 400, 30 );
                contentPane.add(producers[i]);
            }
            in_title.setBounds(0, y=y+30, 400, 30);
            // IN
            contentPane.add(in_title);
            for(int i=0; i<r.getIn().size(); i++){
                y=y+20;
                in[i] = new JLabel(r.getIn().get(i).getName());
                in[i].setBounds(0,y, 400, 30 );
                contentPane.add(in[i]);
            }
            //Out
            y=y+30;
            out_title.setBounds(0,y, 400, 30);
            contentPane.add(out_title);
            // No component found
            if((r.getOut().size()==0)){
                y=y+20;
                JLabel no_out= new JLabel();
                no_out.setText("No component found.");
                no_out.setBounds(0,y, 400, 30);
                contentPane.add(no_out);
            }
            else {
                for (int i = 0; i < r.getOut().size(); i++) {
                    y=y+20;
                    out[i] = new JLabel(r.getIn().get(i).getName());
                    out[i].setBounds(0, y, 400, 30);
                    contentPane.add(out[i]);
                }
            }
            contentPane.add(new JLabel(""));
            this.setVisible(true);
        }
}


