package wrestletracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateWrestler extends JFrame implements ActionListener {

    JTextField ringname, roster, age, ranking, belts, networth, finisher, win;
    JLabel id, realname, debutdate;
    JButton add, back;
    String number;

    UpdateWrestler(String number) {

        this.number = number;
        getContentPane().setBackground(new Color(163, 189, 255));

        JLabel heading = new JLabel("Update Wrestler's Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel ring = new JLabel("RING NAME");
        ring.setBounds(50, 150, 150, 30);
        ring.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(ring);

        ringname = new JTextField();
        ringname.setBounds(200, 150, 150, 30);
        ringname.setBackground(new Color(216, 160, 186, 245));
        add(ringname);

        JLabel real = new JLabel("REAL NAME");
        real.setBounds(450, 150, 150, 30);
        real.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(real);

        realname = new JLabel();
        realname.setBounds(600, 150, 150, 30);
        realname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(realname);

        JLabel debut = new JLabel("DEBUT DATE");
        debut.setBounds(50, 200, 150, 30);
        debut.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(debut);

        debutdate = new JLabel();
        debutdate.setBounds(250, 200, 150, 30);
        debutdate.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(debutdate);

        JLabel age1 = new JLabel("AGE");
        age1.setBounds(450, 200, 150, 30);
        age1.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(age1);

        age = new JTextField();
        age.setBounds(600, 200, 150, 30);
        age.setBackground(new Color(216, 160, 186, 245));
        add(age);

        JLabel rank = new JLabel("RANKING");
        rank.setBounds(50, 250, 150, 30);
        rank.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(rank);

        ranking = new JTextField();
        ranking.setBounds(200, 250, 150, 30);
        ranking.setBackground(new Color(216, 160, 186, 245));
        add(ranking);

        JLabel belt = new JLabel("TITLES");
        belt.setBounds(450, 250, 150, 30);
        belt.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(belt);

        belts = new JTextField();
        belts.setBounds(600, 250, 150, 30);
        belts.setBackground(new Color(216, 160, 186, 245));
        add(belts);

        JLabel worth = new JLabel("WORTH");
        worth.setBounds(50, 300, 150, 30);
        worth.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(worth);

        networth = new JTextField();
        networth.setBounds(200, 300, 150, 30);
        networth.setBackground(new Color(216, 160, 186, 245));
        add(networth);

        JLabel move = new JLabel("FINISHER");
        move.setBounds(450, 300, 150, 30);
        move.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(move);

        finisher = new JTextField();
        finisher.setBounds(600, 300, 150, 30);
        finisher.setBackground(new Color(216, 160, 186, 245));
        add(finisher);

        JLabel brand = new JLabel("ROSTER");
        brand.setBounds(50, 350, 150, 30);
        brand.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(brand);

        roster = new JTextField();
        roster.setBounds(200, 350, 150, 30);
        roster.setBackground(new Color(216, 160, 186, 245));
        add(roster);

        JLabel winning = new JLabel("WIN %");
        winning.setBounds(450, 350, 150, 30);
        winning.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(winning);

        win = new JTextField();
        win.setBounds(600, 350, 150, 30);
        win.setBackground(new Color(216, 160, 186, 245));
        add(win);

        JLabel idLabel = new JLabel("ALPHA CODE");
        idLabel.setBounds(350, 450, 150, 30);
        idLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(idLabel);

        id = new JLabel();
        id.setBounds(500, 450, 150, 30);
        id.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        id.setForeground(Color.red);
        add(id);

        try {
            conn c = new conn();
            String query = "SELECT * FROM wrestler WHERE id = ?";
            PreparedStatement ps = c.connection.prepareStatement(query);
            ps.setString(1, number);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("UPDATE");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String ring = ringname.getText();
            String real = realname.getText();
            String debut = debutdate.getText();
            String age1 = age.getText();
            String rank = ranking.getText();
            String belt = belts.getText();
            String worth = networth.getText();
            String move = finisher.getText();
            String brand = roster.getText();
            String winning = win.getText();
            String digit = id.getText();

            try {
                conn c = new conn();
                String query = "UPDATE wrestler SET ring = ?, real = ?, debut = ?, age1 = ?, rank = ?, belt = ?, worth = ?, move = ?, brand = ?, winning = ? WHERE digit = ?";
                PreparedStatement ps = c.connection.prepareStatement(query);
                ps.setString(1, ring);
                ps.setString(2, real);
                ps.setString(3, debut);
                ps.setString(4, age1);
                ps.setString(5, rank);
                ps.setString(6, belt);
                ps.setString(7, worth);
                ps.setString(8, move);
                ps.setString(9, brand);
                ps.setString(10, winning);
                ps.setString(11, digit);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Wrestler details updated successfully!");
                setVisible(false);
                new View_Raw();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new View_Raw();
        }
    }

    public static void main(String[] args) {
        new UpdateWrestler("");
    }
}
