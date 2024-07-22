package wrestletracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading = new JLabel("");
        heading.setBounds(375,135,450,40);
        heading.setFont(new Font("Raleway",Font.BOLD,55));
        heading.setForeground(Color.yellow);
        img.add(heading);




        JButton add0 = new JButton("RAW");
        add0.setBounds(335,270,150,40);
        add0.setForeground(Color.white);
        add0.setBackground(Color.black);
        add0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Raw();
                setVisible(false);

            }
        });
        img.add(add0);

        JButton add1 = new JButton("SMACKDOWN");
        add1.setBounds(665,270,150,40);
        add1.setForeground(Color.white);
        add1.setBackground(Color.black);
        add1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        img.add(add1);

        JButton add = new JButton("Add Wrestler");
        add.setBounds(335,370,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddWrestler();
                setVisible(false);

            }
        });
        img.add(add);

        JButton add2 = new JButton("Update Info");
        add2.setBounds(665,370,150,40);
        add2.setForeground(Color.white);
        add2.setBackground(Color.black);
        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        img.add(add2);

        JButton add3 = new JButton("HALL OF FAMER");
        add3.setBounds(335,470,150,40);
        add3.setForeground(Color.white);
        add3.setBackground(Color.black);
        add3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        img.add(add3);

        JButton add4 = new JButton("ALUMNI");
        add4.setBounds(665,470,150,40);
        add4.setForeground(Color.white);
        add4.setBackground(Color.black);
        add4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteRecords();

            }
        });
        img.add(add4);

        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Main_class();
    }
}
