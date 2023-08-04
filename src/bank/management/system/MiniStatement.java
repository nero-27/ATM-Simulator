
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    String pinnumber;
    
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        setTitle("Mini Statement");
        
        JLabel text = new JLabel("BANK OF USA");
        text.setBounds(130, 50, 200, 25);
        text.setFont(new Font("System", Font.BOLD, 22));
        add(text);
        
        // card label
        JLabel card = new JLabel();
        card.setBounds(20, 90, 300, 20);
        card.setFont(new Font("System", Font.BOLD, 16));
        add(card);
        
        //mini
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        // balance
        JLabel balance = new JLabel();
        balance.setBounds(20, 120, 400, 20);
        balance.setFont(new Font("System", Font.BOLD, 18));
        add(balance);
        
        // get data from db
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"' ");
            while(rs.next()){
                card.setText("Card number: " + rs.getString("cardnum")
                        .substring(0,4) + "XXXXXXXX" + 
                        rs.getString("cardnum").substring(12,16));
            }
        } catch (Exception e){
            System.out.print(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '2798' ");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + 
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + 
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");
                
                if (rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdrawal")){
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                
                balance.setText("Current Balance: $ " + bal);
            }
        } catch (Exception e){
            System.out.print(e);
        }
        
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
