package fazenda.main;

import fazenda.view.JanelaPrincipal;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        // Boa prática: Iniciar a GUI na Thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            new JanelaPrincipal(); // Chama a janela visual
        });
    }
}