import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;

public class TelaFazenda extends JPanel {

    private Image imgFundo, imgCercado, imgPlantacao;
    

    private Rectangle areaCercado = new Rectangle(100, 100, 150, 150);

    public TelaFazenda() {
        carregarImagens();

    private void carregarImagens() {
        try {

            imgFundo = ImageIO.read(new File("res/ "));
            imgCercado = ImageIO.read(new File("res/" ));
            imgPlantacao = ImageIO.read(new File("res/));
    }
}
