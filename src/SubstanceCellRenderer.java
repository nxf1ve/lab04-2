import javax.swing.*;
import java.awt.*;

public class SubstanceCellRenderer extends JLabel implements ListCellRenderer<Substance> {
    public SubstanceCellRenderer() {
        setOpaque(true);
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends Substance> list, Substance substance, int index, boolean isSelected, boolean cellHasFocus) {
        setText(substance.getName() + " - Density: " + substance.getDensity() + " - ChemicalSymbol: " + substance.getChemicalSymbol());
        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        return this;
    }
}
