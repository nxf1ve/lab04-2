import javax.sound.midi.ShortMessage;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SubstanceApp extends JFrame {
    private final ArrayList<Substance> arrayList;
    private JList<Substance> jList;

    public SubstanceApp() {

        JLabel nameLabel, densityLabel, chemicalSymbolLabel;
        JTextField nameField, densityField, chemicalSymbolField;
        JButton addButton, removeButton, editButton;
        JPanel infoPanel, inputPanel, buttonPanel;

        setTitle("Substances list");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        arrayList = new ArrayList<>();
        jList = new JList<>();
        jList.setCellRenderer(new SubstanceCellRenderer());

        infoPanel = new JPanel(new GridLayout(3, 2));
        nameLabel = new JLabel("Name:");
        densityLabel = new JLabel("Density:");
        chemicalSymbolLabel = new JLabel("ChemicalSymbol:");
        nameField = new JTextField();
        densityField = new JTextField();
        chemicalSymbolField = new JTextField();
        infoPanel.add(nameLabel);
        infoPanel.add(nameField);
        infoPanel.add(densityLabel);
        infoPanel.add(densityField);
        infoPanel.add(chemicalSymbolLabel);
        infoPanel.add(chemicalSymbolField);

        inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(infoPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        editButton = new JButton("Edit");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Substance selectedSubstance = jList.getSelectedValue();

                if (selectedSubstance != null) {
                    nameField.setText(selectedSubstance.getName());
                    densityField.setText(String.valueOf(selectedSubstance.getDensity()));
                    chemicalSymbolField.setText(String.valueOf(selectedSubstance.getChemicalSymbol()));
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    double density = Double.parseDouble(densityField.getText());
                    String chemicalSymbol = chemicalSymbolField.getText();
                    Substance newSubstance = new Substance(name, density, chemicalSymbol);
                    arrayList.add(newSubstance);
                    jList.setListData(arrayList.toArray(new Substance[0]));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(SubstanceApp.this,
                            "Invalid input", "Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jList.getSelectedIndex();
                if (selectedIndex != -1) {
                    arrayList.remove(selectedIndex);
                    jList.setListData(arrayList.toArray(new Substance[0]));
                } else {
                    JOptionPane.showMessageDialog(SubstanceApp.this,
                            "Please select an item to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jList.getSelectedIndex();
                if (selectedIndex != -1) {
                    try {
                        String name = nameField.getText();
                        double density = Double.parseDouble(densityField.getText());
                        String chemicalSymbol = chemicalSymbolField.getText();
                        Substance updatedSubstance = new Substance(name, density, chemicalSymbol);
                        arrayList.set(selectedIndex, updatedSubstance);
                        jList.setListData(arrayList.toArray(new Substance[0]));
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(SubstanceApp.this, "Invalid input",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(SubstanceApp.this, "Select an item to edit.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        getContentPane().add(new JScrollPane(jList), BorderLayout.WEST);
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

}
