package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    TextField tname,tfname,taddress,tphone,temail,taadhar,tsalary,tdesignation,teducation;
    JLabel tempid;
    JButton add,back;

    String number;

    UpdateEmployee(String number){
        this.number = number;
        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new TextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new TextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new TextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new TextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new TextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        teducation = new TextField();
        teducation.setBounds(600,300,150,30);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(600,350,150,30);
        taadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new TextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        JLabel empid = new JLabel("Empl ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(150,400,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        tempid.setForeground(Color.RED);
        add(tempid);

        try{
            conn c = new conn();
            String query = "select * from employee where empid = '"+number+"'";
            ResultSet res = c.statement.executeQuery(query);

            while (res.next()){
                tname.setText(res.getString("name"));
                tfname.setText(res.getString("fname"));
                tdob.setText(res.getString("dob"));
                tsalary.setText(res.getString("slaray"));
                taddress.setText(res.getString("address"));
                tphone.setText(res.getString("phone"));
                temail.setText(res.getString("email"));
                teducation.setText(res.getString("education"));
                tdesignation.setText(res.getString("designation"));
                tempid.setText(res.getString("empid"));
                taadhar.setText(res.getString("aadhar"));
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }


        add= new JButton("Update");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back= new JButton("Back");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        setLayout(null);
        setLocation(300,50);
        setResizable(false);
        setSize(900,700);
        setVisible(true);
    }
    public static void main(String[] args) {
            new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String faname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try{
                conn c=new conn();
                String query = "update employee set fname='"+faname+"',slaray='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Update sucessfully");
                setVisible(false);
                new View_Employee();

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new View_Employee();
        }
    }
}
