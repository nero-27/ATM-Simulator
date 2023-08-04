
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
 
    JButton deposit, withdraw, pinChange, miniStatement, balanceInquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        setTitle("Transactions");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bgimg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);
        
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(230, 280, 700, 75);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        img.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.setFont(new Font("Submit", Font.BOLD, 14));
        deposit.addActionListener(this);
        img.add(deposit);
        
        withdraw = new JButton("Cash withdraw");
        withdraw.setBounds(355, 415, 150, 30);
        withdraw.setFont(new Font("Submit", Font.BOLD, 14));
        withdraw.addActionListener(this);
        img.add(withdraw);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 450, 150, 30);
        pinChange.setFont(new Font("Submit", Font.BOLD, 14));
        pinChange.addActionListener(this);
        img.add(pinChange);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.setFont(new Font("Submit", Font.BOLD, 14));
        miniStatement.addActionListener(this);
        img.add(miniStatement);
        
        balanceInquiry = new JButton("Balance Inquiry");
        balanceInquiry.setBounds(170, 485, 150, 30);
        balanceInquiry.setFont(new Font("Submit", Font.BOLD, 14));
        balanceInquiry.addActionListener(this);
        img.add(balanceInquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 485, 150, 30);
        exit.setFont(new Font("Submit", Font.BOLD, 14));
        exit.addActionListener(this);
        img.add(exit);
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
//        setUndecorated(true); // to remove close, minimise bar of window
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdraw){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceInquiry){
            setVisible(false);
            new BalanceInquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == miniStatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
}
