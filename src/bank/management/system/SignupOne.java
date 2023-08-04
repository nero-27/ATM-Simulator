
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, emailTextField, addressTextField, 
            cityTextField, stateTextField, zipTextField;
    
    JButton next;
    JRadioButton male, female;
    JDateChooser dateChooser;
    
    
    SignupOne() {
        
        setLayout (null);
        Random ran = new Random ();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formno = new JLabel ("APPLICATION FORM NO. " + random );
        formno. setFont (new Font ("Raleway", Font.BOLD, 38));
        formno.setBounds (140, 20, 600, 40);
        add(formno);
        
        JLabel personDetails = new JLabel ("Page 1: Personal Details");
        personDetails. setFont (new Font ("Raleway", Font. BOLD, 22));
        personDetails.setBounds (290, 80, 400, 30);
        add (personDetails);
        
        // name
        JLabel name= new JLabel("Name:");
        name.setFont (new Font ("Raleway", Font. BOLD, 22));
        name.setBounds (100, 140, 100, 30);
        add (name);
        
        nameTextField = new JTextField();
        nameTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        nameTextField.setBounds (300, 140, 400, 30);
        add (nameTextField);
        
        // dob
        JLabel dob= new JLabel("DOB:");
        dob.setFont (new Font ("Raleway", Font. BOLD, 22));
        dob.setBounds (100, 190, 100, 30);
        add (dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds (300, 190, 200, 30); 
        dateChooser.setForeground (new Color (105, 105, 105));
        add (dateChooser);
        
        // email
        JLabel email= new JLabel("Email Id:");
        email.setFont (new Font ("Raleway", Font. BOLD, 22));
        email.setBounds (100, 240, 100, 30);
        add (email);
        
        emailTextField = new JTextField();
        emailTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        emailTextField.setBounds (300, 240, 400, 30);
        add (emailTextField);
        
        // gender
        JLabel gender= new JLabel("Gender:");
        gender.setFont (new Font ("Raleway", Font. BOLD, 22));
        gender.setBounds (100, 290, 100, 30);
        add (gender);
        
        male = new JRadioButton ("Male");
        male.setBounds (300, 290, 60, 30);
        male.setBackground (Color.WHITE);
        add (male);
        
        female = new JRadioButton ("Female");
        female.setBounds (450, 290, 120, 30);
        female.setBackground (Color. WHITE);
        add (female); 
        
        ButtonGroup gendergroup = new ButtonGroup ();
        gendergroup.add (male);
        gendergroup.add (female);
        
        // address
        JLabel address= new JLabel("Address:");
        address.setFont (new Font ("Raleway", Font. BOLD, 22));
        address.setBounds (100, 340, 100, 30);
        add (address);
        
        addressTextField = new JTextField();
        addressTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        addressTextField.setBounds (300, 340, 400, 30);
        add (addressTextField);
        
        // city
        JLabel city= new JLabel("City:");
        city.setFont (new Font ("Raleway", Font. BOLD, 22));
        city.setBounds (100, 390, 100, 30);
        add (city);
        
        cityTextField = new JTextField();
        cityTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        cityTextField.setBounds (300, 390, 400, 30);
        add (cityTextField);
        
        // state
        JLabel state= new JLabel("State:");
        state.setFont (new Font ("Raleway", Font. BOLD, 22));
        state.setBounds (100, 440, 100, 30);
        add (state);
        
        stateTextField = new JTextField();
        stateTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        stateTextField.setBounds (300, 440, 400, 30);
        add (stateTextField);
        
        // zipcode
        JLabel zip= new JLabel("Zip:");
        zip.setFont (new Font ("Raleway", Font. BOLD, 22));
        zip.setBounds (100, 490, 100, 30);
        add (zip);
        
        zipTextField = new JTextField();
        zipTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        zipTextField.setBounds (300, 490, 400, 30);
        add (zipTextField);
        
        next = new JButton ("Next");
        next.setBounds(620, 590, 80, 30);
        next.setFont (new Font ("Raleway", Font. BOLD, 14));
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane ().setBackground (Color. WHITE);
        setSize (850, 800);
        setLocation (350, 10);
        setVisible (true);

        getContentPane().setBackground (Color. WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String zip = zipTextField.getText();
        
        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            } else{
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"', '"+name+"', '"+dob+"', '"+gender+"',"
                + "'"+email+"', '"+address+"', '"+city+"', '"+state+"', '"+zip+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.print(e);
        }
    }
    
    public static void main(String arg[]){
        new SignupOne();
    }
}
