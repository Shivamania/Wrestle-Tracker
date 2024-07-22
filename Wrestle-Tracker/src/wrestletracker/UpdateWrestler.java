package wrestletracker;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateWrestler extends JFrame implements ActionListener {

    JTextField ringname,roster,age,ranking,belts,networth,finisher,win;

    JLabel id;

    JButton add,back;

    String number;
    UpdateWrestler(String number){

        this.number=number;
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
        add(ringname);



        JLabel real = new JLabel("REAL NAME");
        real.setBounds(450,150,150,30);
        real.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(real);

        JLabel realname = new JLabel();
        realname.setBounds(600,150,150,30);
        realname.setBackground(new Color(216, 160, 186, 245));
        add(realname);



        JLabel debut = new JLabel("DEBUT DATE");
        debut.setBounds(50,200,150,30);
        debut.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(debut);

        JLabel debutdate = new JLabel();
        debutdate.setBounds(250,200,150,30);
        debutdate.setFont(new Font("Tahoma",Font.BOLD,20));
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

        roster = new JTextField();
        roster.setBounds(600,300,150,30);
        roster.setBackground(new Color(216, 160, 186, 245));
        add(roster);




        JLabel winning = new JLabel("WIN %");
        winning.setBounds(450,350,150,30);
        winning.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(winning);

        win = new JTextField();
        win.setBounds(600,350,150,30);
        win.setBackground(new Color(216, 160, 186, 245));
        add(win);




        JLabel id = new JLabel("ALPHA CODE");
        id.setBounds(350,450,150,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        id = new JLabel();
        id.setBounds(500,450,150,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        id.setForeground(Color.red);
        add(id);

        try {
            conn c = new conn();
            String query = "select * from wrestler where id = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                ringname.setText(resultSet.getString("ring"));
                realname.setText(resultSet.getString("real"));
                debutdate.setText(resultSet.getString("debut"));
                age.setText(resultSet.getString("age1"));
                ranking.setText(resultSet.getString("rank"));
                belts.setText(resultSet.getString("belt"));
                networth.setText(resultSet.getString("worth"));
                finisher.setText(resultSet.getString("move"));
                roster.setText(resultSet.getString("brand"));
                win.setText(resultSet.getString("winning"));
                id.setText(resultSet.getString("digit"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }



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
        if (e.getSource() == add){
            String ring = ringname.getText();
        }

    }

    public static void main(String[] args) {
        new UpdateWrestler("");
    }
}
