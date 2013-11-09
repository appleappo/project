import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class RandomArt
{
    
    /**
     * Create an RandomArt show it on screen.
     */
    public RandomArt()
    {
        ArtFrame f = new ArtFrame();

    }
    
}

class ArtFrame extends JFrame {
   private JButton newRandomButton;
   private static final String VERSION = "Version 1.0";
   private RandomFunction random;
   private ArtPanel thePanel;
   private Frame frame;
   
   
    
    /**
     * Create the frame and its content.
     */
    public ArtFrame()
    {
        setTitle("RandomArt");
        setJMenuBar(makeMenuBar());

        //Container contentPane = frame.getContentPane();
     
        
        final Graphics graphics;
        thePanel = new ArtPanel();
        JPanel button = new JPanel();
        button.setLayout(new GridLayout());
        newRandomButton = new JButton("New Random");
        newRandomButton.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) {  }
                           }); 
        button.add(newRandomButton);
        
        
        
        
         // Add button into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(button);
        
        add(flow, BorderLayout.SOUTH);
        add(thePanel, BorderLayout.CENTER);
        
       
        
        

        // building is done - arrange the components and show 
        pack();
        setVisible(true);  
    }
    
    //menu bar
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private JMenuBar makeMenuBar()
    {
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;

        
        // create the File menu
        JMenu fileMenu = new JMenu("Menu");
        menubar.add(fileMenu);
       

        JMenuItem quitItem = new JMenuItem("Quit");
            quitItem.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { quit(); }
                           });
        fileMenu.add(quitItem);
        
        // create the Help menu
         menu = new JMenu("Help");
        menubar.add(menu);
        
        item = new JMenuItem("About Random Art...");
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { showAbout(); }
                           });
        menu.add(item);
        
        return menubar;
    }
    
    //menu item system
    private void showAbout()
    {
        ArtFrame frame;
       JOptionPane.showMessageDialog(thePanel, 
                    "Random Art\n" + VERSION,
                    "About Random Art", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }
    
    public Component newBox(){
        JPanel subbox = new JPanel();
        
        
        return subbox;
    }
    
}

  class ArtPanel extends JPanel   {
    public static final int SIZE = 600;
    private Color color;
    public ArtPanel(){
        setPreferredSize(new Dimension(SIZE, SIZE));
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
         
        
        for (int j = 0; j < getHeight() ; j++) {
             for (int i = 0; i < getWidth()  ; i++) {
           int r = (int) (Math.random()*255);
           int gr = (int) (Math.random()*255);
           int b = (int) (Math.random()*255);
            
            
            
            g2.setColor(new Color(r,gr,b));
            
            g2.fillRect(i,j, 1, 1);
            
            
          

        }
         
       }
    }
    /*private static int toColor(double val){
		val += 1.0;
		if (val < 0) {
			val *= -1;
		}
		val /= 2.0;
		int col = (int) (val * 255);
		if (col >= 255) {
			col = 255;
		}
		return col;
	 } */
      }
     
    
    

  


  class RandomFunction {
    private static final int MAX_LEVEL = 8;
      
     public Color randomColor(){
        Random colorbg = new Random();
        Color c1 = new Color(colorbg.nextInt(255),colorbg.nextInt(255),colorbg.nextInt(255)); 
        return c1;
    }
    
    private static double avg(double x, double y){
        return (x + y) / 2.0;
    }
    
    private static double mul(double x, double y){
        return (x *y);
    }
    
    private static double sin(double x, double y){
        return (x *y);
    }
    
    private static double sin(double value){
        return (Math.sin(Math.PI * value));
    }
    
    private static double cos(double value){
        return (Math.cos(Math.PI * value));
    }
   
  }