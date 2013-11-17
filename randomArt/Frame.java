import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame{
  
  private Panel panel;
  private int width;
  private int height;
  boolean check;
  
  public Frame(){
    createWelcomePopUp();
  }
  
  public void createFrame(int width, int height){
    //set title of window
    setTitle("CSC319-OOP PROJECT RANDOM ART");
    setSize(width, height); // will change to use input later
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createMenuBar();
    
    panel = new Panel();
    add(panel, BorderLayout.CENTER);
  }
  
  public void createMenuBar(){
    //createMenuBar
    JMenuBar menu = new JMenuBar();
    JMenu file = new JMenu("File");  
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    menu.add(file);
    menu.add(edit);
    menu.add(help);
    //add sub menu to file
    file.add("New");
    file.add("Save");
    file.add("Exit");
    //add sub menu to edit
    edit.add("New Color");
    edit.add("New Gray");
    edit.add("Change Size");
    edit.add("Random New");
    //add sub menu to about
    help.add("About");
    setJMenuBar(menu);
    addButton("Generate", "SOUTH");
  }
  
  public void addButton(String s, String layout){
    //create button
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(new JButton(s));
    if(layout == "SOUTH"){
      add(buttonPanel, BorderLayout.SOUTH);
    }else if(layout == "NORTH"){
      add(buttonPanel, BorderLayout.NORTH);
    }else if(layout == "EAST"){
      add(buttonPanel, BorderLayout.EAST);
    }else if(layout == "WEST"){
      add(buttonPanel, BorderLayout.WEST);
    }else{
      add(buttonPanel, BorderLayout.CENTER);
    }
  }
  
  public void addLabel(String s, String layout){
    JLabel label = new JLabel(s);
    if(layout == "NORTH"){
      add(label, BorderLayout.NORTH);
    }else if(layout == "SOUTH"){
      add(label, BorderLayout.SOUTH);
    }else if(layout == "EAST"){
      add(label, BorderLayout.EAST);
    }else if(layout == "WEST"){
      add(label, BorderLayout.WEST);
    }else{
      add(label, BorderLayout.CENTER);
    }
  }
  
  
  
  
  
  public void createWelcomePopUp(){
    setTitle("RandomArtProject");
    setSize(320, 50);
    Container contentPanes = new Panel();
    JLabel label = new JLabel("       Welcome! to Random-Art Beta v.2.2.27 ");
    add(label, BorderLayout.CENTER);
    //setBackground(Color.BLUE);
    setVisible(true);
    
    //timeCheck(50);
    setVisible(false);
    remove(label);
    //createFrame(320,320);
    //createWidthHeight();
    //createColorSelection();
    createOption();
    setVisible(true);
  }
  
  public void timeCheck(int check){
    long time1 = System.currentTimeMillis();
    long stop = 0;
    while(stop >= check){
      stop = (System.currentTimeMillis() - time1)/1000;
    }
  }
  
  private List<SizeList> createSize(){
    List<SizeList> sizeList = new ArrayList<SizeList>();
    sizeList.add(new SizeList(200, 200));
    sizeList.add(new SizeList(320, 320));
    sizeList.add(new SizeList(480, 480));
    sizeList.add(new SizeList(800, 600));
    sizeList.add(new SizeList(1280, 720));    
    return sizeList;
  }
  
  public void createOption(){
    
    JTextField widthText = new JTextField(5), heightText = new JTextField(5);
    
    JRadioButton color = new JRadioButton("RGB Color"), gray = new JRadioButton("Grayscale");
    
    
    
    JButton okButton = new JButton(" Generate"), 
      defaultButton = new JButton(" Default ");;
    
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    String[] size = new String[5];
    size[0] = "Defualt: 200 x 200"; size[1] = "320 x 320"; size[2] = "480 x 480"; size[3] = "800 x 600"; size[4] = "1280 x 720";
    String currentSize;
    
    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridBagLayout());
    JLabel width = new JLabel("Width: ");
    JLabel height = new JLabel("Height: ");
    JComboBox combo = new JComboBox(size);
    
    
    
    Box sizeBox = Box.createHorizontalBox();
    sizeBox.add(width); 
    sizeBox.add(widthText);
    sizeBox.add(height); 
    sizeBox.add(heightText);
    widthText.setEnabled(false);
    sizeBox.setBorder(BorderFactory.createTitledBorder("Size"));
    addItem(panel1, sizeBox, 1, 3, 1, 1, GridBagConstraints.NORTH);   
    
    addItem(panel1, combo, 0, 0, 0, 0, GridBagConstraints.SOUTH);
    
    Box colorBox = Box.createVerticalBox();
    ButtonGroup colorGroup = new ButtonGroup();
    colorGroup.add(color);
    colorGroup.add(gray);
    colorBox.add(color);
    colorBox.add(gray);
    colorBox.setBorder(BorderFactory. createTitledBorder("Color Option"));
    addItem(panel1, colorBox, 0, 3, 1, 1, GridBagConstraints.CENTER);
    
    Box buttonBox = Box.createVerticalBox();
    buttonBox.add(okButton);
    buttonBox.add(Box.createVerticalStrut(5));
    buttonBox.add(defaultButton);
    addItem(panel1, buttonBox, 2, 3, 1, 1, GridBagConstraints.CENTER);
    
    this.add(panel1);
    this.pack();
    this.setVisible(true);
  }
  
  private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
    GridBagConstraints gc = new GridBagConstraints();
    gc.gridx = x;
    gc.gridy = y;
    gc.gridwidth = width;
    gc.gridheight = height;
    gc.weightx = 100.0;
    gc.weighty = 100.0;
    gc.insets = new Insets(5, 5, 5, 5);
    gc.anchor = align;
    gc.fill = GridBagConstraints.NONE;
    p.add(c, gc);
    
  }
  
  /*
   public void createWidthHeight(){
   setSize(250, 125);
   setLayout(new GridLayout(3,1));
   JTextField text = new JTextField(5);
   JTextField text2 = new JTextField(5);
   
   addLabel("Width: ", "WEST");
   add(text);//,BorderLayout.EAST);
   addLabel("Height: ", "WEST");
   add(text2);//,BorderLayout.EAST);
   addButton("Next","SOUTH");
   }
   
   public void createColorSelection(){
   setSize(250,125);
   setLayout(new GridLayout(2,2));
   JRadioButton color = new JRadioButton(" Random Color");
   JRadioButton gray = new JRadioButton(" Random Gray");
   add(color, BorderLayout.CENTER); 
   add(gray, BorderLayout.CENTER);
   addButton("Generate", "CENTER");
   addButton("Back", "CENTER");
   }
   */
  public void run(){
    //setVisible(true);
  }
}
