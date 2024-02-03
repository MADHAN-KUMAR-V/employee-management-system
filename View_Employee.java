package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {

    Choice choiceEMP;
    JTable table;
    JButton searchb,print,update,back;
    View_Employee(){
        getContentPane().setBackground(new Color(255,131,122));

        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            conn c = new conn();
            ResultSet res = c.statement.executeQuery("select * from employee");
            while(res.next()){
                choiceEMP.add(res.getString("empid"));
            }


        }catch (Exception E){
            E.printStackTrace();
        }

        table = new JTable();

        try{
            conn c = new conn();
            ResultSet res = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(res));

        }catch (Exception E){
            E.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchb = new JButton("Search");
        searchb.setBounds(20,70,80,20);
        searchb.addActionListener(this);
        add(searchb);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setSize(900,700);
        setLocation(300,50);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new View_Employee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchb){
            String query = "select * from employee where empid='"+ choiceEMP.getSelectedItem()+"'";
            try{
                conn c= new conn();
                ResultSet res = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(res));

            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()== print){
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==update) {
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        }
        else {
            setVisible(false);
            new Main_class();
        }
    }
}
