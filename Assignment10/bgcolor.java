import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class bgcolor extends JFrame implements ActionListener{
JButton B1,B2,B3;
public bgcolor(){
B1=new JButton("Red");
B2=new JButton("Green");
B3=new JButton("Blue");
B1.setBounds(20,20,80,30);
B2.setBounds(120,20,80,30);
B3.setBounds(220,20,80,30);
add(B1);
add(B2);
add(B3);
B1.addActionListener(this);
B2.addActionListener(this);
B3.addActionListener(this);
setLayout(null);
setSize(400,400);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==B1){
getContentPane().setBackground(Color.RED);
}
else if (e.getSource()==B2){
getContentPane().setBackground(Color.GREEN);
}else
{
getContentPane().setBackground(Color.BLUE);
}
}
public static void main(String args[])
{
bgcolor r=new bgcolor();
}
}
