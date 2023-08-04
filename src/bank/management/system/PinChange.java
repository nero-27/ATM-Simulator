
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener{
    
    String pinnumber;
    JPasswordField newpinTextField, repinTextField;
    JButton change, back;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        setTitle("Pin Change");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bgimg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 300, 400, 20);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        img.add(text);
        
        
        // new pin
        JLabel pintext = new JLabel("Enter new pin");
        pintext.setBounds(165, 350, 150, 25);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        img.add(pintext);
        
        newpinTextField = new JPasswordField();
        newpinTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        newpinTextField.setBounds (300, 350, 100, 25);
        img.add (newpinTextField);
        
        JLabel repintext = new JLabel("Re-enter new pin");
        repintext.setBounds(165, 380, 150, 25);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        img.add(repintext);
        
        repinTextField = new JPasswordField();
        repinTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        repinTextField.setBounds (300, 380, 100, 25);
        img.add (repinTextField);
        
        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.setFont(new Font("Submit", Font.BOLD, 14));
        change.addActionListener(this);
        img.add(change);
        
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
        
        if (ae.getSource() == change){
            try {
                String npin = newpinTextField.getText();
                String rpin = repinTextField.getText();

                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if (npin.equals("") || rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                
                if (npin.length() != 4 || rpin.length() != 4){
                    JOptionPane.showMessageDialog(null, "Please enter 4 digit PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+npin+"' where pin = '"+pinnumber+"' ";
                String query2 = "update login set pin = '"+npin+"' where pin = '"+pinnumber+"' ";
                String query3 = "update signupthree set pin = '"+npin+"' where pin = '"+pinnumber+"' ";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully!");
                
                setVisible(false);
                new Transactions(npin).setVisible(true);
            
            } catch (Exception e){
                System.out.print(e);
            }
        } else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
        
    }
}
