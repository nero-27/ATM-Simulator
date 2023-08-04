/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener {
    
    JTextField withdrawTextField;
    JButton withdraw, back;
    String pinnumber;
    
    Withdrawal(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        setTitle("Withdrawal");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bgimg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);
        
        JLabel text = new JLabel("Please enter amount to withdraw");
        text.setBounds(200, 300, 400, 20);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        img.add(text);
        
        withdrawTextField = new JTextField();
        withdrawTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        withdrawTextField.setBounds (170, 350, 320, 25);
        img.add (withdrawTextField);
        
        withdraw = new JButton("Withdraw Cash");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.setFont(new Font("Submit", Font.BOLD, 14));
        withdraw.addActionListener(this);
        img.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.setFont(new Font("Submit", Font.BOLD, 14));
        back.addActionListener(this);
        img.add(back);
        
        
        setSize(900, 900);
        setLocation(300, 0);
//        setUndecorated(true); // to remove close, minimise bar of window
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdraw){
            String depositAmt = withdrawTextField.getText();
            Date date = new Date();
            if (depositAmt.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter amount to deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+depositAmt+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$ " + depositAmt + " withdrawed successfully!");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e){
                    System.out.print(e);
                }
                
            }
            
        } else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawal("");
    }
}
