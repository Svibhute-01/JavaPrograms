import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class bddemo extends JFrame implements ActionListener
{
  JLabel l1,l2;
  JTextField t1,t2;
  JButton b1,b2,b3;
  JPanel p1,p2;
  public bddemo()
  {
    setTitle("border layout");
    setLayout(new BorderLayout());
    l1=new JLabel("enter num");
    t1=new JTextField(20);
    p1=new JPanel();
    setSize(400,400);
    p1.add(l1);
    p1.add(t1);
    add(p1,BorderLayout.NORTH);

    l2=new JLabel("RESULT");
    t2=new JTextField(20);
    p2=new JPanel();
    p2.add(l2);
    p2.add(t2);
    add(p2,BorderLayout.SOUTH);
    b1=new JButton("binary");
    add(b1,BorderLayout.WEST);

    b2=new JButton("octal");
    add(b2,BorderLayout.CENTER);

    b3=new JButton("hexadecimal");
    add(b3,BorderLayout.EAST);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
   setSize(400,400);
   setVisible(true);  
   setDefaultCloseOperation(EXIT_ON_CLOSE); 
  }
  public void actionPerformed(ActionEvent e1)
{
  int num=Integer.parseInt(t1.getText());
  if(e1.getSource()==b1)
   {
      t2.setText(" "+Integer.toBinaryString(num));
   }  
  if(e1.getSource()==b2)
   {
      t2.setText(" "+Integer.toOctalString(num));
   }  
   if(e1.getSource()==b3)
   {
      t2.setText(" "+Integer.toHexString(num).toUpperCase());
   }  
}
public static void main(String a[])
{
   bddemo ob=new bddemo();
}
}

