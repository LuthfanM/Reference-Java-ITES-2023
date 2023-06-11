/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learnclass;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByData extends JFrame {
    private JTextField searchField;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;
    private JButton searchButton;

    private String[] data = {
            "Data 1",
            "Data 2",
            "Data 3",
            "Data 4",
            "Data 5"
   };
                    
                    

    public SearchByData() {
        setTitle("Search App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        searchField = new JTextField();
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(resultList);
        searchButton = new JButton("Search");

        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = resultList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        String selectedData = listModel.getElementAt(selectedIndex);
                        showDetail(selectedData);
                    }
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                listModel.clear();
                boolean found = false;

                for (String item : data) {
                    if (item.equalsIgnoreCase(searchText)) {
                        listModel.addElement(item);
                        found = true;
                    }
                }

                if (!found) {
                    listModel.addElement("Not found");
                }
            }
        });

        add(searchField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(searchButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void showDetail(String data) {
        JOptionPane.showMessageDialog(this, "Detail: " + data);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SearchByData().setVisible(true);
            }
        });
    }
}
