package compositor;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PentagramPanel  extends JPanel{

	private String getUrlImageLine() {
		return "https://raw.githubusercontent.com/maira1001001/Laboratorio-de-Software-2018/master/images/black-line.png";
	}
	
	public void initializeComponent() {
		Border lineaCyan = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder titlePentagram = BorderFactory.createTitledBorder(lineaCyan, "Pentagrama");
		titlePentagram.setTitleJustification(TitledBorder.CENTER);
		titlePentagram.setTitleColor(Color.CYAN);
		this.setBorder(titlePentagram);
	}
	
	public void drawComponent() {
		BufferedImage image = null;
		try {
			URL url = new URL(getUrlImageLine());
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
        	InputStream lala = getClass().getResourceAsStream("/black-lines.png");
			BufferedImage sheet = ImageIO.read(lala);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//this.add(image);
	}
	
	public static void main(String args[]) {
		PentagramPanel p = new PentagramPanel();
		p.drawComponent();
	}
		

}

