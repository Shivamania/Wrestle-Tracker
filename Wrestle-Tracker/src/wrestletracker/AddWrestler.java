package wrestletracker;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddWrestler extends JFrame implements ActionListener {


    JTextField ringname,realname,age,ranking,belts,networth,finisher,win;
    JLabel id;

    JDateChooser debutdate;

    JComboBox roster;

    Random code = new Random();
    int number = code.nextInt(9999);

    JButton add,back;

    AddWrestler(){

        getContentPane().setBackground(new Color(163, 189, 255));

        JLabel heading = new JLabel("Add Wrestler's Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);


        JLabel ring = new JLabel("RING NAME");
        ring.setBounds(50,150,150,30);
        ring.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(ring);

        ringname = new JTextField();
        ringname.setBounds(200,150,150,30);
        ringname.setBackground(new Color(216, 160, 186, 245));
        ringname.setForeground(new Color(0x0526A2));
        ringname.setFont(new Font("SERIF",Font.BOLD,15));
        add(ringname);



        JLabel real = new JLabel("REAL NAME");
        real.setBounds(450,150,150,30);
        real.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(real);

        realname = new JTextField();
        realname.setBounds(600,150,150,30);
        realname.setBackground(new Color(216, 160, 186, 245));
        add(realname);



        JLabel debut = new JLabel("DEBUT DATE");
        debut.setBounds(50,200,150,30);
        debut.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(debut);

        debutdate = new JDateChooser();
        debutdate.setBounds(200,200,150,30);
        debutdate.setBackground(new Color(216, 160, 186, 245));
        add(debutdate);



        JLabel age1 = new JLabel("AGE");
        age1.setBounds(450,200,150,30);
        age1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(age1);

        age = new JTextField();
        age.setBounds(600,200,150,30);
        age.setBackground(new Color(216, 160, 186, 245));
        add(age);




        JLabel rank = new JLabel("RANKING");
        rank.setBounds(50,250,150,30);
        rank.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(rank);

        ranking = new JTextField();
        ranking.setBounds(200,250,150,30);
        ranking.setBackground(new Color(216, 160, 186, 245));
        add(ranking);



        JLabel belt = new JLabel("TITLES");
        belt.setBounds(450,250,150,30);
        belt.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(belt);

        belts = new JTextField();
        belts.setBounds(600,250,150,30);
        belts.setBackground(new Color(216, 160, 186, 245));
        add(belts);



        JLabel worth = new JLabel("WORTH");
        worth.setBounds(50,300,150,30);
        worth.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(worth);

        networth = new JTextField();
        networth.setBounds(200,300,150,30);
        networth.setBackground(new Color(216, 160, 186, 245));
        add(networth);



        JLabel move = new JLabel("FINISHER");
        move.setBounds(450,300,150,30);
        move.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(move);

        finisher = new JTextField();
        finisher.setBounds(600,300,150,30);
        finisher.setBackground(new Color(216, 160, 186, 245));
        add(finisher);




        JLabel brand = new JLabel("ROSTER");
        brand.setBounds(50,350,150,30);
        brand.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(brand);

        String items[] = {" ","Raw","Smack Down","Hall Of Famer"};
        roster = new JComboBox(items);
        roster.setBackground(new Color(216, 160, 186, 245));
        roster.setBounds(200,350,150,30);
        add(roster);




        JLabel winning = new JLabel("WIN %");
        winning.setBounds(450,350,150,30);
        winning.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(winning);

        win = new JTextField();
        win.setBounds(600,350,150,30);
        win.setBackground(new Color(216, 160, 186, 245));
        add(win);




        JLabel digit = new JLabel("ALPHA CODE");
        digit.setBounds(350,450,150,30);
        digit.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(digit);

        id = new JLabel(""+number);
        id.setBounds(500,450,150,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        id.setForeground(Color.red);
        add(id);



        add = new JButton("ADD");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String ring = ringname.getText();
            String real = realname.getText();
            String debut = ((JTextField) debutdate.getDateEditor().getUiComponent()).getText();
            String age1 = age.getText();
            String rank = ranking.getText();
            String belt = belts.getText();
            String worth = networth.getText();
            String move = finisher.getText();
            String brand = (String) roster.getSelectedItem();
            String winning = win.getText();
            String digit = id.getText();


            try {
                conn c = new conn();
                String query = "insert into wrestler values('"+ring+"','"+real+"','"+debut+"','"+age1+"','"+rank+"','"+belt+"','"+worth+"','"+move+"','"+brand+"','"+winning+"','"+digit+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully !");
                setVisible(false);
                new Main_class();

            }catch (Exception E) {
                E.printStackTrace();
            }


        }
    }

    public static void main(String[] args) {
               new AddWrestler();
    }
}
