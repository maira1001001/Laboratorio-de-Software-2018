package listadecolores;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColorList extends JPanel {

  private JList<String> list;
  private DefaultListModel<String> model;
  private JScrollPane pane;

  public ColorList() {
    model = new DefaultListModel<String>();
    list = new JList<String>(model);
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
  
  public boolean aColorIsSelected() {
	  return (list.getSelectedIndex() >= 0);
  }
  
  public void addOnClickAction(JButton deleteButton) {
	  list.addMouseListener(new ColorListMouseListener());
	  list.addListSelectionListener(new ColorListListSelectionListener(deleteButton));
  }
  
  public JList<String> getList() {
	  return list;
  }
  
  public void deleteColorSelected() {
	  model.removeElementAt(list.getSelectedIndex());
  }

}
           
         
  
