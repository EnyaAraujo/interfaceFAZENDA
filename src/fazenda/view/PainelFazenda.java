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

    // Rectangle(x, y, largura, altura)
    Rectangle areaLojinha = new Rectangle(550, 20, 180, 160); 


    Rectangle areaPlantacao = new Rectangle(50, 150, 200, 200);

    Rectangle areaCercadoVaca = new Rectangle(300, 300, 120, 120);
    Rectangle areaCercadoOvelha = new Rectangle(450, 350, 100, 100);
    Rectangle areaCercadoGalinha = new Rectangle(350,180,80,80);
            
    Rectangle areaVaca = new Rectangle(300, 300, 120, 120);
    Rectangle areaOvelha = new Rectangle(450, 350, 100, 100);
    Rectangle areaGalinha = new Rectangle(350, 180, 80, 80);

   
    private Image imgLojinha, imgPlantacao, imgVaca, imgOvelha, imgGalinha, imgCercado;

    public PainelFazenda(JanelaPrincipal janela) {
        this.janelaMae = janela;

        carregarImagens();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clique = e.getPoint(); 
                
                if (areaLojinha.contains(clique)) {
                    System.out.println("Abriu a Loja!"); 
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
           
            imgLojinha = ImageIO.read(new File("lojinha.png"));
            imgPlantacao = ImageIO.read(new File("plantio.png"));
            
            
            imgVaca = ImageIO.read(new File("vaca.png"));
            imgOvelha = ImageIO.read(new File("ovelha.png"));
            imgGalinha = ImageIO.read(new File("galinha.png"));
            
            
            imgCercado = ImageIO.read(new File("cercado.png"));

        } catch (IOException e) {
            System.out.println("ERRO: Imagem não encontrada! Verifique a pasta do projeto.");
            
            System.out.println(e.getMessage()); 
        }
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

       
        g.setColor(new Color(100, 160, 50)); 
        g.fillRect(0, 0, getWidth(), getHeight());
        
        
        if (imgPlantacao != null) 
            g.drawImage(imgPlantacao, areaPlantacao.x, areaPlantacao.y, areaPlantacao.width, areaPlantacao.height, this);
        
        
        if (imgLojinha != null) 
            g.drawImage(imgLojinha, areaLojinha.x, areaLojinha.y, areaLojinha.width, areaLojinha.height, this);
            
        
        if (imgCercado != null) {
            g.drawImage(imgCercado, areaCercadoVaca.x, areaCercadoVaca.y, areaCercadoVaca.width, areaCercadoVaca.height, this);
            g.drawImage(imgCercado, areaCercadoOvelha.x, areaCercadoOvelha.y, areaCercadoOvelha.width, areaCercadoOvelha.height, this);
            g.drawImage(imgCercado, areaCercadoGalinha.x, areaCercadoGalinha.y, areaCercadoGalinha.width, areaCercadoGalinha.height, this);
            }

        if (imgVaca != null) 
            g.drawImage(imgVaca, areaVaca.x, areaVaca.y, areaVaca.width, areaVaca.height, this);
            
        if (imgOvelha != null) 
            g.drawImage(imgOvelha, areaOvelha.x, areaOvelha.y, areaOvelha.width, areaOvelha.height, this);
            
        if (imgGalinha != null) 
            g.drawImage(imgGalinha, areaGalinha.x, areaGalinha.y, areaGalinha.width, areaGalinha.height, this);

    }
}
