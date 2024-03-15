import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SubstanceApp app = new SubstanceApp();
                app.setVisible(true);
            }
        });
    }
}
