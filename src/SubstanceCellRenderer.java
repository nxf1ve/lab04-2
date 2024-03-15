import javax.swing.*;
import java.awt.*;

public class SubstanceCellRenderer extends JLabel implements ListCellRenderer<Substance> {
    public SubstanceCellRenderer() {
        setOpaque(true);
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends Substance> list, Substance value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getName() + " - Density: " + value.getDensity() + " - ChemicalSymbol: " + value.getChemicalSymbol());
        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        return this;
    }
}
