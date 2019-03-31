package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

import static java.awt.BorderLayout.CENTER;


public class MyGUIForm extends JFrame {


    private JPanel rootPanel;
    public JTextArea textArea;
    public JTextField textField;
    public JButton button;
    public JList funList;



    final JMenuBar menub = new JMenuBar();
    final JMenu options = new JMenu("Options");
    final JMenuItem reset = new JMenuItem("Reset");
    final JMenuItem exit = new JMenuItem("Exit");
    //JScrollBar bar = new JScrollBar(JScrollBar.VERTICAL);
    //JScrollPane scroll = new JScrollPane(textArea);

    public MyGUIForm() {

        super("Calculator");
        setJMenuBar(menub);
        setContentPane(rootPanel);

        options.add(reset);
        options.add(exit);
        options.addSeparator();
        menub.add(options);
        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       // scroll.setBounds(500,0,30,400);
       // textArea.add(bar);

        setSize(700,500);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //konczy dzialanie programu całkowicie po wcisnieciu x na apce



        //Przycisk reset czysci JTextField i JTextArea
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(null);
                textArea.setText(null);
            }
        });

        //Przycisk Exit zamyka program
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

    }


}
