package wrestletracker;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Raw extends JFrame implements ActionListener {

    JTable table;

    Choice choice;

    JButton searchbtn, print, update, back;


    View_Raw(){

        getContentPane().setBackground(new Color(201, 233, 213));
        JLabel search = new JLabel("Search by ALPHA CODE");
        search.setBounds(20,20,150,20);
        add(search);

        choice = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from wrestler");
            while (resultSet.next()){
                choice.add(resultSet.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from wrestler");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

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





        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==searchbtn){
            String query = "select * from wrestler where id = '"+choice.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==update) {
            setVisible(false);
            new UpdateWrestler(choice.getSelectedItem());

        }else {
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String[] args) {
        new View_Raw();
    }
}
