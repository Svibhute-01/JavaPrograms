import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 class gddemo extends JFrame implements ActionListener
{  
  boolean flag;
  JButton b[]=new JButton[6];
  String name[]={"1","2","3","4","5","6"};
  public gddemo()
  {
    flag=true;
    setTitle("gridlayout");
    for(int i=0;i<name.length;i++)
    {
    b[i]=new JButton(name[i]);
    add(b[i]);
    b[i].addActionListener(this);
  }
   setLayout(new GridLayout(2,3));
   setSize(400,400);
   setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
}
public void actionPerformed(ActionEvent e)
{
   if(flag)
   {
     setLayout(new GridLayout(3,2));
   }
   else
   {
       setLayout(new GridLayout(2,3));       
   }
flag=!flag;
  validate();
}
public static void main(String[] args) 
{
  gddemo ob=new gddemo();
}
}
