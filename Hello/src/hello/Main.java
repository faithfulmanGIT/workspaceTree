package hello;

import javax.swing.JFrame;
import javax.swing.JTree;



public class Main {


    public static void main(String[] args) {  
        JFrame f = new JFrame("123");  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.add(new JTree());  
        f.setSize(400,400);  
        f.setLocation(200,200);  
        f.setVisible(true);  
    } 

}
