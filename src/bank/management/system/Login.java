
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        setLayout(null);
        setTitle("Login");
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource ("icons/atm.png"));
        Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon (i2);
        JLabel label= new JLabel (i3);
        label.setBounds(70, 10, 100, 100 );
        add (label);

        JLabel text= new JLabel("Welcome to ATM");
        text. setFont (new Font ("Osward", Font. BOLD, 38));
        text.setBounds (200, 40, 400, 40);
        add (text); 
        getContentPane().setBackground(Color. WHITE);

       
        JLabel cardno= new JLabel("Card No:");
        cardno. setFont(new Font ("Raleway", Font.BOLD, 28));
        cardno.setBounds (120, 150, 400, 40);
        add (cardno); 
        
        JLabel pin = new JLabel("PIN: ");
        pin. setFont(new Font ("Raleway", Font. BOLD, 28));
        pin.setBounds (120, 220, 400, 40);
        add (pin);
        
        cardTextField = new JTextField();
        cardTextField.setBounds (300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add (cardTextField);

        pinTextField = new JPasswordField();
        pinTextField.setBounds (300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add (pinTextField);
        
        login = new JButton ("SIGN IN");
        login.setBounds (300, 300, 100, 30);
        login.addActionListener(this);
        add (login);
        
        clear = new JButton ("CLEAR");
        clear.setBounds (430, 300, 100, 30);
        clear.addActionListener(this);
        add (clear);
        
        signup = new JButton ("SIGN UP");
        signup.setBounds (300, 350, 230, 30);
        signup.addActionListener(this);
        add (signup);
        
        
        


        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource () == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource () == login) {
            Conn conn = new Conn();
            String cardnum = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnum = '"+cardnum+"' and pin = '"+pinnumber+"' ";
            try{
                ResultSet rs = conn.s.executeQuery(query); // returns a resultset
                if (rs.next()){ // check if data was retrived
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect card number or pin.");
                }               
            } catch (Exception e){
                System.out.print(e);
            }
            
                
        } else if (ae.getSource () == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
