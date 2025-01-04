package wrestletracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteRecords extends JFrame implements ActionListener {

    Choice choiceCode;
    JButton delete, back;

    DeleteRecords() {
        JLabel label = new JLabel("ALPHA CODE");
        label.setBounds(60, 130, 100, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        label.setForeground(new Color(0xFCF233));
        add(label);

        choiceCode = new Choice();
        choiceCode.setBounds(210, 130, 150, 30);
        choiceCode.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
        choiceCode.setForeground(Color.white);
        add(choiceCode);

        try {
            conn c = new conn();
            String query = "SELECT id FROM wrestler";
            PreparedStatement pstmt = c.connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                choiceCode.add(resultSet.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelring = new JLabel("RING NAME");
        labelring.setBounds(60, 180, 100, 30);
        labelring.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelring.setForeground(new Color(0xFCF233));
        add(labelring);

        JLabel textRing = new JLabel();
        textRing.setBounds(210, 180, 100, 30);
        textRing.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
        textRing.setForeground(Color.white);
        add(textRing);

        JLabel labelBelt = new JLabel("TITLES");
        labelBelt.setBounds(60, 230, 100, 30);
        labelBelt.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelBelt.setForeground(new Color(0xFCF233));
        add(labelBelt);

        JLabel textBelt = new JLabel();
        textBelt.setBounds(210, 230, 100, 30);
        textBelt.setForeground(Color.white);
        textBelt.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
        add(textBelt);

        JLabel labelmove = new JLabel("FINISHER");
        labelmove.setBounds(60, 280, 100, 30);
        labelmove.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelmove.setForeground(new Color(0xFCF233));
        add(labelmove);

        JLabel textmove = new JLabel();
        textmove.setBounds(210, 280, 100, 30);
        textmove.setForeground(Color.white);
        textmove.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
        add(textmove);

        loadWrestlerDetails(choiceCode.getSelectedItem(), textRing, textBelt, textmove);

        choiceCode.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadWrestlerDetails(choiceCode.getSelectedItem(), textRing, textBelt, textmove);
            }
        });

        delete = new JButton("MOVE TO ALUMNI");
        delete.setBounds(80, 370, 150, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(300, 370, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 450);
        add(img);

        setSize(600, 450);
        setLocation(300, 150);
        setLayout(null);
        setVisible(true);
    }

    private void loadWrestlerDetails(String id, JLabel textRing, JLabel textBelt, JLabel textmove) {
        try {
            conn c = new conn();
            String query = "SELECT ringname, belts, finisher FROM wrestler WHERE id = ?";
            PreparedStatement pstmt = c.connection.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                textRing.setText(resultSet.getString("ringname"));
                textBelt.setText(resultSet.getString("belts"));
                textmove.setText(resultSet.getString("finisher"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                conn c = new conn();
                String query = "DELETE FROM wrestler WHERE id = ?";
                PreparedStatement pstmt = c.connection.prepareStatement(query);
                pstmt.setString(1, choiceCode.getSelectedItem());
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Wrestler moved to ALUMNI");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete wrestler!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                setVisible(false);
                new Main_class();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteRecords();
    }
}
