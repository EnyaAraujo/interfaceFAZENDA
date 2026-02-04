package fazenda.view;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    private JPanel painelLateral;
    private CardLayout cardLayout;
    private PainelFazenda painelFazenda; // Agora referenciamos a outra classe

    public JanelaPrincipal() {
        setTitle("Fazenda Idle");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 1. Instancia o painel do desenho (que está no outro arquivo)
        // Passamos 'this' para que o PainelFazenda consiga chamar métodos daqui (como trocar menu)
        painelFazenda = new PainelFazenda(this); 
        add(painelFazenda, BorderLayout.CENTER);

        // 2. Configura o painel lateral
        configurarPainelLateral();
        add(painelLateral, BorderLayout.EAST);

        setVisible(true);
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    private void configurarPainelLateral() {
        painelLateral = new JPanel();
        cardLayout = new CardLayout();
        painelLateral.setLayout(cardLayout);
        painelLateral.setPreferredSize(new Dimension(200, 600));

        painelLateral.add(criarMenu("Menu Geral", "Comprar", "Modo Automatico"), "GERAL");
        painelLateral.add(criarMenu("Plantação", "Regar", "Colher"), "PLANTACAO");
        painelLateral.add(criarMenu("Animais", "Alimentar", "Colher"), "ANIMAIS");
    }

    // Método genérico para criar menus rapidinho
    private JPanel criarMenu(String titulo, String btn1, String btn2) {
        JPanel p = new JPanel();
        p.add(new JLabel(titulo));
        p.add(new JButton(btn1));
        p.add(new JButton(btn2));
        if (!titulo.equals("Menu Geral")) {
             JButton btnVoltar = new JButton("Voltar");
             btnVoltar.addActionListener(e -> mostrarMenu("GERAL"));
             p.add(btnVoltar);
        }
        return p;
    }

    public void mostrarMenu(String nome) {
        cardLayout.show(painelLateral, nome);
    }
}