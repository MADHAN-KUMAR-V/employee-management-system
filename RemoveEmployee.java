package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete,back;
    RemoveEmployee(){

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

        try{
            conn c = new conn();
            ResultSet res = c.statement.executeQuery("select * from employee");
            while(res.next()){
                choiceEMPID.add(res.getString("empid"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelname);

        JLabel textname = new JLabel();
        textname.setBounds(200,100,100,30);
        textname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        labelphone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelphone);

        JLabel textphone = new JLabel();
        textphone.setBounds(200,150,100,30);
        textphone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelemail);

        JLabel textemail = new JLabel();
        textemail.setBounds(200,200,100,30);
        textemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textemail);

        try{
            conn c = new conn();
            ResultSet res = c.statement.executeQuery("select * from employee where empid='"+choiceEMPID.getSelectedItem()+"'");
            while (res.next()){
                textname.setText(res.getString("name"));
                textphone.setText(res.getString("phone"));
                textemail.setText(res.getString("email"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }
        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet res = c.statement.executeQuery("select * from employee where empid='"+choiceEMPID.getSelectedItem()+"'");
                    while (res.next()){
                        textname.setText(res.getString("name"));
                        textphone.setText(res.getString("phone"));
                        textemail.setText(res.getString("email"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(200,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel bg= new JLabel(i3);
        bg.setBounds(700,80,200,200);
        add(bg);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);

        JLabel bg1= new JLabel(i33);
        bg1.setBounds(0,0,1120,630);
        add(bg1);



        setSize(1000,400);
        setLocation(200,100);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            try{
                conn c = new conn();
                String query = "delete from employee where empid='"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Delete sucessfully");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource()==back) {
            setVisible(false);
            new Main_class();
        }
    }
}
