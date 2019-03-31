package Application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

public class Funcionality {
    MyGUIForm my = new MyGUIForm();
    public String last;


    DefaultListModel<Application.Functions> listModel = new DefaultListModel<>();

   public Funcionality(){

       my.funList.setModel(listModel);
       functions();


       //ii. Komponent JTextArea powinien być read-only
       my.textArea.setEditable(false);



       //iii. W razie potrzeby suwak powinien umożliwić przesuwanie zawartości okna


       //JTextField: Służy do wpisywania działań matematycznych:

       my.textField.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
               super.keyPressed(e);
               if(e.getKeyCode() == KeyEvent.VK_ENTER){
                   try {

                       calculate(my.textField.getText());


                   }
                   catch(Exception ex){
                       JOptionPane.showMessageDialog(null, ex.getMessage()," Error", JOptionPane.ERROR_MESSAGE);
                   }
                   my.textField.setText("");


               }

               //i. Jeśli użytkownik wciśnie na klawiaturze klawisz [↑] to w polu tekstowym powinno się pojawić ostatnie wpisane działanie.
               if(e.getKeyCode() == KeyEvent.VK_UP){

                   my.textField.setText(last);
               }

               }

       });


       //JList
       // ii. Po podwójnym kliknięciu wybrana funkcja powinna się pojawić w polu JTextField
       my.funList.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               if(e.getClickCount()==2){
                   int index = my.funList.getSelectedIndex();  //zwraca pierwszy element pasujący
                   String function = listModel.getElementAt(index).getFunction();
                   my.textField.setText(my.textField.getText()+ function);
                   my.textField.requestFocus();
                   if(my.textField.getText().contains("(")){ // jesli formula ma jakis nawias

                       my.textField.setCaretPosition(my.textField.getText().lastIndexOf("(")+1);  // to ustawia kursor miedzy nimi
                   }
                   else
                       my.textField.setCaretPosition(my.textField.getText().length()); // jesli nie to na koncu

               }
           }

       });

       //Po wcisnieciu Evaluate znika z pola i liczy w textArea
       my.button.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               try {
                   calculate(my.textField.getText());

               }
               catch(Exception ex){
                   JOptionPane.showMessageDialog(null, ex.getMessage()," Error", JOptionPane.ERROR_MESSAGE);
               }
               my.textField.setText("");

           }

       });

   }


   public void calculate(String sentence) throws Exception{

       Expression exp = new Expression(sentence); //korzystanie z biblioteki
       if (exp.checkSyntax() ){ // jelsi poprawne wyrazenie to liczy i dodaje do historii

           Double result=exp.calculate();
           listModel.lastElement().setFunction(result.toString()); // zwraca wynik ostaniego wyrażenia
           last=sentence; //zapamietanie ostatniego wyrazenia
           addToTextArea(sentence, result); // dodaje do historii
       }
       else if(exp.getExpressionString().isEmpty()==false){

           String errorMessage = exp.getErrorMessage();
           throw new Exception(errorMessage);

       }


   }

    public void addToTextArea(String sentence, Double result){

        Object[] testArgs = {sentence, result, };
        MessageFormat formats = new MessageFormat(
                "{0}\n \t = {1} \n ------- \n");

        my.textArea.setText( my.textArea.getText()+ "\n "+formats.format(testArgs));
        my.textField.setText("");

    }

    //JList: Zawiera listę funkcji matematycznych
   public void functions(){
       Application.Functions tan=new Application.Functions("Sinus","sin()");
       listModel.addElement(tan);
       Application.Functions log =new Application.Functions("Natural logarithm","ln()");
       listModel.addElement(log);
       Application.Functions rad =new Application.Functions("Radians","rad()");
       listModel.addElement(rad);
       Application.Functions sqrt =new Application.Functions("Square root","sqrt()");
       listModel.addElement(sqrt);
       Application.Functions abs =new Application.Functions("Absolute value","abs()");
       listModel.addElement(abs);

       Application.Functions pi =new Application.Functions("Pi value","pi");
       listModel.addElement(pi);
       Application.Functions e =new Application.Functions("Euler number","e");
       listModel.addElement(e);
       Application.Functions omg =new Application.Functions("Omega constant","[Om]");
       listModel.addElement(omg);

       Application.Functions plus =new Application.Functions("Plus","+");
       listModel.addElement(plus);
       Application.Functions minus =new Application.Functions("Minus","-");
       listModel.addElement(minus);
       Application.Functions multiply =new Application.Functions("Multiply","*");
       listModel.addElement(multiply);

       Application.Functions lastR = new Application.Functions("Last result ","");
       listModel.addElement(lastR);
   }
}
