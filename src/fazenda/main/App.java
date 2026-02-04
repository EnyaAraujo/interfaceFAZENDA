package fazenda.main;

import fazenda.view.JanelaPrincipal;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new JanelaPrincipal();
        });
    }
}
