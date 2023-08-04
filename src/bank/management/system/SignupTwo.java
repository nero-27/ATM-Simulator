
package bank.management.system;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField ssnTextField;
    String formno;
    JButton next;
    JRadioButton syes, sno, eayes, eano;
    JComboBox religion, income, education, occupation;
    
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout (null);
        
        setTitle("NEW APPLICATION FORM: PAGE 2");
                
        JLabel additionalDetails = new JLabel ("Page 1: Additional Details");
        additionalDetails. setFont (new Font ("Raleway", Font. BOLD, 22));
        additionalDetails.setBounds (290, 80, 400, 30);
        add (additionalDetails);
        
        // religion
        JLabel name = new JLabel("Religion:");
        name.setFont (new Font ("Raleway", Font. BOLD, 22));
        name.setBounds (100, 140, 100, 30);
        add (name);
        
        String valReligion[] = {"Hindu", "Muslim", "Christian", "Sikh", "Jew", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        // income
        JLabel inc= new JLabel("Income");
        inc.setFont (new Font ("Raleway", Font. BOLD, 22));
        inc.setBounds (100, 190, 100, 30);
        add (inc);
        
        String valIncome[] = {"null", "$50,000 - %100,000", "$100,000 - $150,000", "$150,000 - $200,000", 
            "$200,000 - 300,000", "$ > 300,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 190, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
      
        
        // educational qualification
        JLabel ed = new JLabel("Educational");
        ed.setFont (new Font ("Raleway", Font. BOLD, 22));
        ed.setBounds (100, 240, 200, 30);
        add (ed);
        
        JLabel qualification= new JLabel("Qualification:");
        qualification.setFont (new Font ("Raleway", Font. BOLD, 22));
        qualification.setBounds (100, 270, 200, 30);
        add (qualification);
        
        String valEducation[] = {"High School", "Undergraduate", "Graduate", "Doctoral", "Others"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 250, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
    
        // occupation
        JLabel occ= new JLabel("Occupation:");
        occ.setFont (new Font ("Raleway", Font. BOLD, 22));
        occ.setBounds (100, 340, 200, 30);
        add (occ);
        
        String valOccupation[] = {"Salaried Employee", "Self-employed", "Student", "Retired", "Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        // ssn
        JLabel ssn = new JLabel("SSN:");
        ssn.setFont (new Font ("Raleway", Font. BOLD, 22));
        ssn.setBounds (100, 390, 100, 30);
        add (ssn);
        
        ssnTextField = new JTextField();
        ssnTextField. setFont (new Font ("Raleway", Font. BOLD, 14));
        ssnTextField.setBounds (300, 390, 400, 30);
        add (ssnTextField);
        
        // senior citizen
        JLabel state= new JLabel("Senior citizen:");
        state.setFont (new Font ("Raleway", Font. BOLD, 22));
        state.setBounds (100, 440, 200, 30);
        add (state);
        
        syes = new JRadioButton ("Yes");
        syes.setBounds (300, 440, 60, 30);
        syes.setBackground (Color.WHITE);
        add (syes);
        
        sno = new JRadioButton ("No");
        sno.setBounds (450, 440, 120, 30);
        sno.setBackground (Color. WHITE);
        add (sno); 
        
        ButtonGroup seniorgroup = new ButtonGroup ();
        seniorgroup.add (syes);
        seniorgroup.add (sno);
        
        // existing account
        JLabel zip = new JLabel("Existing Account:");
        zip.setFont (new Font ("Raleway", Font. BOLD, 22));
        zip.setBounds (100, 490, 200, 30);
        add (zip);
        
        eayes = new JRadioButton ("Yes");
        eayes.setBounds (300, 490, 60, 30);
        eayes.setBackground (Color.WHITE);
        add (eayes);
        
        eano = new JRadioButton ("No");
        eano.setBounds (450, 490, 120, 30);
        eano.setBackground (Color. WHITE);
        add (eano); 
        
        ButtonGroup eagroup = new ButtonGroup ();
        eagroup.add (eayes);
        eagroup.add (eano);
        
        
        next = new JButton ("Next");
        next.setBounds(620, 590, 80, 30);
        next.setFont (new Font ("Raleway", Font. BOLD, 14));
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground (Color. WHITE);
        setSize (850, 800);
        setLocation (350, 10);
        setVisible (true);

        getContentPane().setBackground (Color. WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        String seniorCitizen = null;
        if (syes.isSelected()){
            seniorCitizen = "Yes";
        } else if (sno.isSelected()){
            seniorCitizen = "No";
        }
        
        String existingAcc = null;
        if (eayes.isSelected()){
            existingAcc = "Yes";
        } else if (eano.isSelected()){
            existingAcc = "No";
        }
        
        String ssn = ssnTextField.getText();
        
        
        try{           
            Conn c = new Conn();
            String query = "insert into signuptwo values ('"+formno+"', '"+sreligion+"', '"+sincome+"', '"+seducation+"',"
            + "'"+soccupation+"', '"+seniorCitizen+"', '"+existingAcc+"')";
            c.s.executeUpdate(query);
                
            // signup 3 object
            
        } catch (Exception e){
            System.out.print(e);
        }
    }
    
    public static void main(String arg[]){
        new SignupTwo("");
    }
}
