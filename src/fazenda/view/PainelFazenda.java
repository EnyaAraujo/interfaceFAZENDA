package fazenda.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class PainelFazenda extends JPanel {

    private JanelaPrincipal janelaMae;

    // --- 1. DEFININDO POSIÇÕES E TAMANHOS (HITBOXES) ---
    // Rectangle(x, y, largura, altura)
    
    // Loja no canto superior direito
    Rectangle areaLojinha = new Rectangle(550, 20, 180, 160); 

    // Plantação grande no lado esquerdo
    Rectangle areaPlantacao = new Rectangle(50, 150, 200, 200);

    // Animais espalhados no centro/baixo
    // Crie áreas específicas para os cercados de cada bicho
    Rectangle areaCercadoVaca = new Rectangle(300, 300, 120, 120);
    Rectangle areaCercadoOvelha = new Rectangle(450, 350, 100, 100);
    Rectangle areaCercadoGalinha = new Rectangle(350,180,80,80);
            
    Rectangle areaVaca = new Rectangle(300, 300, 120, 120);
    Rectangle areaOvelha = new Rectangle(450, 350, 100, 100);
    Rectangle areaGalinha = new Rectangle(350, 180, 80, 80);

    // Variáveis para as imagens
    private Image imgLojinha, imgPlantacao, imgVaca, imgOvelha, imgGalinha, imgCercado;

    public PainelFazenda(JanelaPrincipal janela) {
        this.janelaMae = janela;
        // Carrega as imagens ao criar o painel
        carregarImagens();

        // --- 2. DETECTANDO CLIQUES ---
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clique = e.getPoint(); // Onde o mouse clicou?

                // Verifica se o clique caiu dentro de algum retângulo
                if (areaLojinha.contains(clique)) {
                    System.out.println("Abriu a Loja!"); 
                    // Se tiver um menu de loja, chame aqui: janelaMae.mostrarMenu("LOJA");
                } 
                else if (areaPlantacao.contains(clique)) {
                    janelaMae.mostrarMenu("PLANTACAO");
                } 
                else if (areaVaca.contains(clique) || areaOvelha.contains(clique) || areaGalinha.contains(clique)) {
                    janelaMae.mostrarMenu("ANIMAIS");
                } 
                else {
                    janelaMae.mostrarMenu("GERAL");
                }
            }
        });
    }

    private void carregarImagens() {
        try {
            // Lendo os arquivos da pasta raiz do projeto
            imgLojinha = ImageIO.read(new File("lojinha.png"));
            imgPlantacao = ImageIO.read(new File("plantio.png"));
            
            // Animais
            imgVaca = ImageIO.read(new File("vaca.png"));
            imgOvelha = ImageIO.read(new File("ovelha.png"));
            imgGalinha = ImageIO.read(new File("galinha.png"));
            
            // Tente criar um fundo verde ou usar uma imagem
            // imgFundo = ImageIO.read(new File("fundo_grama.png")); 
            imgCercado = ImageIO.read(new File("cercado.png"));

        } catch (IOException e) {
            System.out.println("ERRO: Imagem não encontrada! Verifique a pasta do projeto.");
            // Dica: Imprima o erro para saber qual imagem falhou
            System.out.println(e.getMessage()); 
        }
    }

    // --- 3. DESENHANDO NA TELA (RENDERIZAÇÃO) ---
    // --- 3. DESENHANDO NA TELA (RENDERIZAÇÃO) ---
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa a tela

        // A. Desenha o chão (Fundo)
        g.setColor(new Color(100, 160, 50)); 
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // --- CAMADA 1: ESTRUTURAS (Ficam atrás dos animais) ---
        
        // 1. Desenha a Plantação
        if (imgPlantacao != null) 
            g.drawImage(imgPlantacao, areaPlantacao.x, areaPlantacao.y, areaPlantacao.width, areaPlantacao.height, this);
        
        // 2. Desenha a Lojinha
        if (imgLojinha != null) 
            g.drawImage(imgLojinha, areaLojinha.x, areaLojinha.y, areaLojinha.width, areaLojinha.height, this);
            
        // 3. NOVO: Desenha o Cercado
        // Note que usamos "imgCercado" mas desenhamos na posição "areaCercado"
        if (imgCercado != null) {
            g.drawImage(imgCercado, areaCercadoVaca.x, areaCercadoVaca.y, areaCercadoVaca.width, areaCercadoVaca.height, this);
    
    // Cercado da Ovelha
        g.drawImage(imgCercado, areaCercadoOvelha.x, areaCercadoOvelha.y, areaCercadoOvelha.width, areaCercadoOvelha.height, this);
    
    // Cercado da Galinha
        g.drawImage(imgCercado, areaCercadoGalinha.x, areaCercadoGalinha.y, areaCercadoGalinha.width, areaCercadoGalinha.height, this);
            }
           
        

        // --- CAMADA 2: ANIMAIS (Ficam na frente do cercado) ---
            
        if (imgVaca != null) 
            g.drawImage(imgVaca, areaVaca.x, areaVaca.y, areaVaca.width, areaVaca.height, this);
            
        if (imgOvelha != null) 
            g.drawImage(imgOvelha, areaOvelha.x, areaOvelha.y, areaOvelha.width, areaOvelha.height, this);
            
        if (imgGalinha != null) 
            g.drawImage(imgGalinha, areaGalinha.x, areaGalinha.y, areaGalinha.width, areaGalinha.height, this);

        // --- DEBUG (Opcional) ---
        // ... (seu código de debug continua aqui)
    }
}