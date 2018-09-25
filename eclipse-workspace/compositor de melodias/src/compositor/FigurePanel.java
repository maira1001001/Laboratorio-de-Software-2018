package compositor;

import java.awt.Color;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class FigurePanel extends JPanel{
		
	private String getImageBaseUrl() {
		return  "https://raw.githubusercontent.com/maira1001001/Laboratorio-de-Software-2018/master/images/";
	}
	
	private URL buildImageUrl(Figures typeOfFigure) {
		StringBuffer str = new StringBuffer();
		str.append(this.getImageBaseUrl()).append(typeOfFigure).append(".png");
		URL url = null;
		try {
			url = new URL(str.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
		
	public void  initializeComponent() {
		defineFeaturePanel();
	}
	
	public void drawComponent() {
		drawFigure(Figures.SEMIBREVE);
		drawFigure(Figures.MINIM);
		drawFigure(Figures.CROTCHET);
		drawFigure(Figures.QUAVER);
		drawFigure(Figures.SEMIQUAVER);
		drawFigure(Figures.DEMISEMIQUAVER);
		drawFigure(Figures.HEMIDEMISEMIQUAVER);
	}
	
	private void defineFeaturePanel() {
		Border blueLine = BorderFactory.createLineBorder(Color.blue);
		TitledBorder title = BorderFactory.createTitledBorder(blueLine, "FIGURAS");
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitleColor(Color.blue);
		this.setBorder(title);
	}

	private void drawFigure(Figures figure) {
		JLabel minimLabel = new JLabel();
		ImageIcon minimIconImage = createFigureIcon(buildImageUrl(figure));
		minimLabel.setIcon(minimIconImage);
		this.add(minimLabel);
	}
	
	private ImageIcon createFigureIcon(URL figureUrl) {
		ImageIcon imageIcon = new ImageIcon(figureUrl);
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return imageIcon = new ImageIcon(newimg);
	}

}
