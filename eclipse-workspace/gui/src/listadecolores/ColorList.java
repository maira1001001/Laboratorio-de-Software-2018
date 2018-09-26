package listadecolores;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

public class ColorList extends JPanel {

  private JList<String> list;
  private DefaultListModel<String> model;
  private JScrollPane pane;

  public ColorList() {
    //setLayout(new BorderLayout());
    model = new DefaultListModel<String>();
    list = new JList<String>(model);
    //list.setPreferredSize(new Dimension(40, 20));
    pane = new JScrollPane(list);
    pane.setPreferredSize(new Dimension(150, 120));
    add(pane);
  }
  
  public void addDefaultColors() {
	  model.addElement("Rojo");
	  model.addElement("Azul");
	  model.addElement("Verde");
  }
  
  public void addColor(String color) {
	  model.addElement(color);
  }
  
//  public void addAction1() {
//	  MouseListener mouseListener = new MouseAdapter() {
//	      public void mouseClicked(MouseEvent mouseEvent) {
//	        JList<String> theList = (JList) mouseEvent.getSource();
//	        if (mouseEvent.getClickCount() == 1) {
//	          int index = theList.locationToIndex(mouseEvent.getPoint());
//	          if (index >= 0) {
//	            Object o = theList.getModel().getElementAt(index);
//	            System.out.println("Double-clicked on: " + o.toString());
//	          }
//	        }
//	      }
//	    };
//    list.addMouseListener(mouseListener);
//  }
  
  public JList<String> getList() {
	  return list;
  }
  
  public void deleteColorSelected() {
	  model.removeElementAt(list.getSelectedIndex());
  }
  
  public static void main(String s[]) {
    JFrame frame = new JFrame("lalala");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ColorList c = new ColorList();
    c.addDefaultColors();
    c.addDefaultColors();
    c.addDefaultColors();
    c.addDefaultColors();
    frame.setContentPane(c);
    frame.setSize(260, 200);
    frame.setVisible(true);
  }
}
           
         
  
