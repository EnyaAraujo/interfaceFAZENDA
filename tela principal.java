import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JogoFazenda extends JFrame {

    // Painel lateral que vai mudar os botões
    private JPanel painelLateral;
    private CardLayout cardLayout;

    public JogoFazenda() {
        setTitle("Fazenda Idle - Java Swing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 1. CRIANDO O PAINEL DA FAZENDA (ESQUERDA/CENTRO)
        PainelFazenda painelFazenda = new PainelFazenda();
        add(painelFazenda, BorderLayout.CENTER);

        // 2. CRIANDO O PAINEL DE BOTÕES (DIREITA)
        painelLateral = new JPanel();
        cardLayout = new CardLayout(); // O CardLayout permite "pilhas" de painéis
        painelLateral.setLayout(cardLayout);
        painelLateral.setPreferredSize(new Dimension(200, 600)); // Largura fixa

        // Criando os diferentes menus de botões
        painelLateral.add(criarMenuPrincipal(), "GERAL");
        painelLateral.add(criarMenuPlantacao(), "PLANTACAO");
        painelLateral.add(criarMenuAnimais(), "ANIMAIS");

        add(painelLateral, BorderLayout.EAST);

        setVisible(true);
    }

    // -- Métodos auxiliares para criar os botões --
    
    private JPanel criarMenuPrincipal() {
        JPanel p = new JPanel();
        p.add(new JLabel("Menu Geral"));
        p.add(new JButton("Salvar Jogo"));
        p.add(new JButton("Configurações"));
        return p;
    }

    private JPanel criarMenuPlantacao() {
        JPanel p = new JPanel();
        p.add(new JLabel("Ações da Plantação"));
        p.add(new JButton("Regar"));
        p.add(new JButton("Colher"));
        p.add(new JButton("Voltar")); // Exemplo de botão para voltar
        return p;
    }

    private JPanel criarMenuAnimais() {
        JPanel p = new JPanel();
        p.add(new JLabel("Ações dos Animais"));
        p.add(new JButton("Alimentar"));
        p.add(new JButton("Carinho"));
        return p;
    }

    // Método público para trocar o menu (chamado pelo PainelFazenda)
    public void mostrarMenu(String nomeDoMenu) {
        cardLayout.show(painelLateral, nomeDoMenu);
    }

    // --- CLASSE INTERNA: O DESENHO DA FAZENDA ---
    // É aqui que desenhamos a casa, cercados e detectamos os cliques
    private class PainelFazenda extends JPanel {
        
        // Coordenadas (X, Y, Largura, Altura) dos elementos
        Rectangle areaPlantacao = new Rectangle(50, 50, 150, 150);
        Rectangle areaOvelha = new Rectangle(300, 50, 100, 100);
        Rectangle areaVaca = new Rectangle(300, 200, 100, 100);
        Rectangle areaGalinha = new Rectangle(450, 50, 100, 100);
        Rectangle areaCasa = new Rectangle(50, 300, 200, 150);

        public PainelFazenda() {
            setBackground(new Color(34, 139, 34)); // Verde floresta (Forest Green)

            // Ouvinte do Mouse (Detecta onde você clicou)
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point clique = e.getPoint(); // Onde o mouse clicou?

                    if (areaPlantacao.contains(clique)) {
                        mostrarMenu("PLANTACAO");
                        System.out.println("Clicou na plantação!");
                    } else if (areaOvelha.contains(clique) || areaVaca.contains(clique) || areaGalinha.contains(clique)) {
                        mostrarMenu("ANIMAIS");
                        System.out.println("Clicou nos animais!");
                    } else {
                        mostrarMenu("GERAL"); // Clicou na grama volta ao normal
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Limpa a tela e pinta o fundo verde

            // Desenhando a Plantação (Marrom)
            g.setColor(new Color(139, 69, 19)); 
            g.fillRect(areaPlantacao.x, areaPlantacao.y, areaPlantacao.width, areaPlantacao.height);
            g.setColor(Color.WHITE);
            g.drawString("Plantação", areaPlantacao.x + 10, areaPlantacao.y + 20);

            // Desenhando os Cercados (Cinza)
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(areaOvelha.x, areaOvelha.y, areaOvelha.width, areaOvelha.height);
            g.fillRect(areaVaca.x, areaVaca.y, areaVaca.width, areaVaca.height);
            g.fillRect(areaGalinha.x, areaGalinha.y, areaGalinha.width, areaGalinha.height);
            
            // Labels
            g.setColor(Color.BLACK);
            g.drawString("Ovelha", areaOvelha.x + 10, areaOvelha.y + 20);
            g.drawString("Vaca", areaVaca.x + 10, areaVaca.y + 20);
            g.drawString("Galinha", areaGalinha.x + 10, areaGalinha.y + 20);

            // Desenhando a Casa (Vermelha)
            g.setColor(Color.RED);
            g.fillRect(areaCasa.x, areaCasa.y, areaCasa.width, areaCasa.height);
            g.setColor(Color.WHITE);
            g.drawString("Casa Principal", areaCasa.x + 10, areaCasa.y + 20);
        }
    }

    public static void main(String[] args) {
        // Iniciar na Thread correta do Swing
        SwingUtilities.invokeLater(() -> new JogoFazenda());
    }
}
public class NewJFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame.class.getName());

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new NewJFrame().setVisible(true));
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
// ... Imports anteriores continuam iguais
    import javax.imageio.ImageIO; // Importante: para ler as imagens
    import java.io.File;
    import java.io.IOException;

    // --- CLASSE INTERNA: O DESENHO DA FAZENDA (AGORA COM IMAGENS) ---
    private class PainelFazenda extends JPanel {
        
        // As áreas de clique (Hitboxes) continuam as mesmas!
        // A lógica do jogo não muda, apenas a "pele" (visual) muda.
        Rectangle areaPlantacao = new Rectangle(50, 50, 150, 150);
        Rectangle areaOvelha = new Rectangle(300, 50, 100, 100);
        Rectangle areaVaca = new Rectangle(300, 200, 100, 100);
        Rectangle areaGalinha = new Rectangle(450, 50, 100, 100);
        Rectangle areaCasa = new Rectangle(50, 300, 200, 150);

        // Variáveis para guardar as imagens na memória
        private Image imgPlantacao;
        private Image imgOvelha;
        private Image imgVaca;
        private Image imgGalinha;
        private Image imgCasa;
        private Image imgFundo; // Opcional: imagem de grama para o fundo

        public PainelFazenda() {
            // Tenta carregar as imagens do disco
            try {
                // "ImageIO.read" lê o arquivo. "new File" diz onde ele está.
                imgPlantacao = ImageIO.read(new File("plantacao.png"));
                imgOvelha = ImageIO.read(new File("ovelha.png"));
                imgVaca = ImageIO.read(new File("vaca.png"));
                imgGalinha = ImageIO.read(new File("galinha.png"));
                imgCasa = ImageIO.read(new File("casa.png"));
                
                // Se quiser carregar um fundo de grama:
                // imgFundo = ImageIO.read(new File("grama.png"));
                
            } catch (IOException e) {
                System.out.println("ERRO: Não encontrei alguma imagem!");
                e.printStackTrace(); 
                // Dica: Se der erro, verifique se o nome do arquivo está IGUALzinho (letra maiúscula importa)
            }

            // O MouseListener continua EXATAMENTE igual ao anterior
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point clique = e.getPoint();
                    if (areaPlantacao.contains(clique)) mostrarMenu("PLANTACAO");
                    else if (areaOvelha.contains(clique) || areaVaca.contains(clique) || areaGalinha.contains(clique)) mostrarMenu("ANIMAIS");
                    else mostrarMenu("GERAL");
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 

            // 1. Desenha o Fundo
            g.setColor(new Color(34, 139, 34)); // Fundo verde (caso não tenha imagem de fundo)
            g.fillRect(0, 0, getWidth(), getHeight());

            // Se você tiver uma imagem de grama, descomente a linha abaixo:
            // g.drawImage(imgFundo, 0, 0, getWidth(), getHeight(), this);

            // 2. Desenha as Imagens
            // Sintaxe: g.drawImage(imagem, X, Y, Largura, Altura, this);
            
            // Usamos as coordenadas dos Retângulos (area.x, area.y) para saber onde desenhar
            if (imgPlantacao != null) g.drawImage(imgPlantacao, areaPlantacao.x, areaPlantacao.y, areaPlantacao.width, areaPlantacao.height, this);
            if (imgOvelha != null)    g.drawImage(imgOvelha, areaOvelha.x, areaOvelha.y, areaOvelha.width, areaOvelha.height, this);
            if (imgVaca != null)      g.drawImage(imgVaca, areaVaca.x, areaVaca.y, areaVaca.width, areaVaca.height, this);
            if (imgGalinha != null)   g.drawImage(imgGalinha, areaGalinha.x, areaGalinha.y, areaGalinha.width, areaGalinha.height, this);
            if (imgCasa != null)      g.drawImage(imgCasa, areaCasa.x, areaCasa.y, areaCasa.width, areaCasa.height, this);

            // 3. (Opcional) Desenhar contorno só para ajudar a visualizar a área de clique
            // g.setColor(Color.RED);
            // g.drawRect(areaVaca.x, areaVaca.y, areaVaca.width, areaVaca.height);
        }
    }
