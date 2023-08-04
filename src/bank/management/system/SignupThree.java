/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
       
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        r1 = new JRadioButton ("Saving Account");
        r1.setFont (new Font ("Raleway", Font. BOLD, 16));
        r1.setBackground (Color. WHITE);
        r1.setBounds (100, 180, 200, 20);
        add (r1);
        
        r2 = new JRadioButton ("Checking Account");
        r2.setFont (new Font ("Raleway", Font. BOLD, 16));
        r2.setBackground (Color. WHITE);
        r2.setBounds (340, 180, 200, 20);
        add (r2);
        
        r3 = new JRadioButton ("Money Market Account");
        r3.setFont (new Font ("Raleway", Font. BOLD, 16));
        r3.setBackground (Color. WHITE);
        r3.setBounds (100, 220, 200, 20);
        add (r3);
        
        r4 = new JRadioButton ("Certificate of Deposit Account");
        r4.setFont (new Font ("Raleway", Font. BOLD, 16));
        r4.setBackground (Color. WHITE);
        r4.setBounds (340, 220, 300, 20);
        add (r4);
        
        ButtonGroup groupAccounts = new ButtonGroup();
        groupAccounts.add(r1);
        groupAccounts.add(r2);
        groupAccounts.add(r3);
        groupAccounts.add(r4);
        
        JLabel cardLabel = new JLabel("Card Number");
        cardLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        cardLabel.setBounds(100, 300, 300, 30);
        add(cardLabel);
        
        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-5983");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNumber.setBounds(250, 300, 300, 30);
        add(cardNumber);
        
        JLabel cardDetail = new JLabel("Your 16 digit card number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);
        
        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        pinLabel.setBounds(100, 370, 300, 30);
        add(pinLabel);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(150, 370, 300, 30);
        add(pinNumber);
        
        JLabel pinDetail = new JLabel("Your 4 digit pin");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);
        
        // services
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 20);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 50);
        add(c1);
        
        c2 = new JCheckBox("SMS / Email Alerts");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("raleway", Font.BOLD, 16));
        c2.setBounds(100, 550, 200, 50);
        add(c2);
        
        c3 = new JCheckBox("Cheque Book");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("raleway", Font.BOLD, 16));
        c3.setBounds(350, 500, 200, 50);
        add(c3);
        
        c4 = new JCheckBox("E-statement");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 50);
        add(c4);
        
        c5 = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge.");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("raleway", Font.BOLD, 12));
        c5.setBounds(100, 600, 600, 50);
        add(c5);
        
        submit = new JButton ("Submit");
        submit.setBackground (Color.BLACK);
        submit. setForeground (Color. WHITE);
        submit.setFont (new Font ("Raleway", Font. BOLD, 14));
        submit.setBounds (250, 650, 100, 30);
        submit.addActionListener(this);
        add (submit);
        
        cancel = new JButton ("Cancel");
        cancel.setBackground (Color.BLACK);
        cancel.setForeground (Color. WHITE);
        cancel.setFont (new Font ("Raleway", Font. BOLD, 14));
        cancel.setBounds (420, 650, 100, 30);
        cancel.addActionListener(this);
        add (cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Savings";
            } else if (r2.isSelected()){
                accountType = "Checking";
            } else if (r3.isSelected()){
                accountType = "Money market";
            } else if (r4.isSelected()){
                accountType = "Certificate of Deposit";
            }
            
            Random random = new Random();
            String cardnum = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L); 
            String pinnum = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String services = "";
            if (c1.isSelected()){
                services = services + "ATM CARD";
            }
            if (c2.isSelected()){
                services = services + "SMS / Email Alerts";
            }
            if (c3.isSelected()){
                services = services + "Cheque Book";
            }
            if (c4.isSelected()){
                services = services + "E-Statement";
            }
            
            try{
                Conn conn = new Conn();
                String query1 = "insert into signupthree values ('"+formno+"', '"+accountType+"', '"+cardnum+"', "
                        + "'"+pinnum+"', '"+services+"')";
                String query2 = "insert into login values ('"+formno+"', '"+cardnum+"', "
                        + "'"+pinnum+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Card number: " + cardnum
                        + "\nPin: " + pinnum);
                
                setVisible(false);
                new Deposit(pinnum).setVisible(true);
                
            } catch (Exception e){
                System.out.print(e);
            }
            
        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
    
}
