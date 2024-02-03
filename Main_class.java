package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image image1 = image.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(image1);

        JLabel bg = new JLabel(i3);
        bg.setBounds(0,0,1120,630);
        add(bg);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        bg.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        bg.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.white);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });
        bg.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);
        rem.setBackground(Color.BLACK);
        rem.setForeground(Color.white);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee();
            }
        });
        bg.add(rem);


        setSize(1120,630);
        setLocation(200,50);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
