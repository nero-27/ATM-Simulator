
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceInquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    
    BalanceInquiry(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        setTitle("Balance Inquiry");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bgimg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);
        
        Conn conn = new Conn();
        int balance = 0;
        
        try{
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
            while (rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdrawal")){
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e){
            System.out.print(e);
        }
        
        JLabel currentBalance = new JLabel("Your current balance is $ " + balance);
        currentBalance.setBounds(165, 300, 400, 25);
        currentBalance.setFont(new Font("System", Font.BOLD, 16));
        currentBalance.setForeground(Color.WHITE);
        img.add(currentBalance);
        
        // back
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.setFont(new Font("Submit", Font.BOLD, 14));
        back.addActionListener(this);
        img.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    }
    
    public static void main(String args[]){
        new BalanceInquiry("");
    }
}
