package incatch;
import java.util.Vector;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Framework extends JPanel implements ActionListener{
    
    private ImageIcon mapIcon;
    private BufferedImage mapImage;
    private JLabel mapLabel;
    private JFrame frame;
    private JButton playButton, stopButton, nextButton , mapButton,logButton ;
    private JPanel buttonPanel;
    private String mapname;
    private int actions;
    private Vector<Pose> log;
    private Map map;
    
    
    public Framework(){
       
         //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(false);
        //JDialog.setDefaultLookAndFeelDecorated(true);
 
        //Instantiate the controlling class.
        frame = new JFrame("IntcatchDEMO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null); //center it
        frame.setVisible(true);
        actions=0;
        log=null;
    }
    public void addButton(){
        
        ImageIcon playButtonIcon = new ImageIcon("images/play.png");
        playButton = new JButton(playButtonIcon);
        playButton.setActionCommand("play");
        playButton.addActionListener(this);
        buttonPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(playButton);
        
        ImageIcon stopButtonIcon = new ImageIcon("images/stop.png");
        stopButton = new JButton(stopButtonIcon);
        stopButton.setActionCommand("stop");
        stopButton.addActionListener(this);
        buttonPanel.add(stopButton);
        
        ImageIcon nextButtonIcon = new ImageIcon("images/next.png");
        nextButton = new JButton(nextButtonIcon);
        nextButton.setActionCommand("next");
        nextButton.addActionListener(this);
        buttonPanel.add(nextButton);
        
        ImageIcon mapButtonIcon = new ImageIcon("images/map.png");
        mapButton = new JButton(mapButtonIcon);
        mapButton.setActionCommand("map");
        mapButton.addActionListener(this);
      //buttonPanel =new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(mapButton);
        
        ImageIcon logButtonIcon = new ImageIcon("images/log.png");
        logButton = new JButton(logButtonIcon);
        logButton.setActionCommand("log");
        logButton.addActionListener(this);
      // buttonPanel =new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(logButton);
        
      
        frame.getContentPane().add(buttonPanel,BorderLayout.NORTH);

        frame.setVisible(true);
        frame.repaint();
        
        
    }
    public void addMap(){
       
        mapImage= map.getMapImage();
        System.out.println("mapimage: "+mapImage.getHeight());
        mapIcon=new ImageIcon(mapImage);
        System.out.println("image: " + mapIcon.getIconWidth());
        mapLabel=new JLabel(mapIcon);
        frame.getContentPane().add(mapLabel,BorderLayout.CENTER);
        frame.getContentPane().add(new JScrollPane(mapLabel), BorderLayout.CENTER);
        frame.setVisible(true);       
    }
    public void drawMap(Map map,Vector<Point2D> vector){
    }
    public int run(){
         //System.out.println("RUN");
         //System.exit(-1);
         while(actions==0){
             try{
            Thread.sleep(300);
             }catch(InterruptedException e) {}

             
         }
         
         if(actions==1){
            //questa è play
            
            if(log==null){
                String message = "selezionare un log prima di premere play.";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
                actions=0;
                playButton.setEnabled(true);
                return(-1);
            }
            
            System.out.println("log:" +log.size());
            
            //BufferedImage mapImage=map.getMapImage();
            
             Graphics2D g2d = mapImage.createGraphics();
              
             g2d.setColor(Color.BLACK);
              
             Iterator<Pose> it= log.iterator();
        
             while(it.hasNext()){
                Pose p= it.next();
                Point2D puntoImmagine=map.convert(p);
                g2d.fillOval((int)(puntoImmagine.getX()), (int)(puntoImmagine.getY()), 10, 10);
             }
         
          frame.revalidate();
              frame.repaint();
         }
         return 0;
    }
    
 public void actionPerformed(ActionEvent e) {
              
            
       
     
              String command= e.getActionCommand();
              System.out.println("command: " + command);
              if(command.equals("play")){
                  playButton.setEnabled(false);
                  stopButton.setEnabled(true);
                  nextButton.setEnabled(true);
                  actions= 1;
              }else if(command.equals("stop")){
                  playButton.setEnabled(true);
                  stopButton.setEnabled(false);
                  nextButton.setEnabled(true);
                  actions= 2;
              }else if(command.equals("next")){
                  playButton.setEnabled(true);
                  stopButton.setEnabled(true);
                  nextButton.setEnabled(true);
                  actions= 3;
              }
                if(command=="map"){
                mapChooser();
                
                }
                if(command=="log")
                fileChooser();
                
    }
 public void mapChooser() {
        
        
        try {
        
        JFileChooser fileChooser = new JFileChooser("./dati");
        int n = fileChooser.showOpenDialog(Framework.this);
        if (n == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            System.out.println("name: "+f);
            mapname=f.toString();
            MapReader mr = new MapReader(mapname);
            map = mr.getMap();
            addMap();

/*
        
        
        
        System.out.println("***");
        System.out.println(map.toString());
        
        mapIcon=new ImageIcon(f.toString());
        //LA DIRECTORY FUNZOINA F NOOOOOOOO
        System.out.println("image: " + mapIcon.getIconWidth());
        mapLabel=new JLabel(mapIcon);
        frame.getContentPane().add(mapLabel,BorderLayout.CENTER);
        frame.getContentPane().add(new JScrollPane(mapLabel), BorderLayout.CENTER);
        frame.setVisible(true);*/
        }
        } catch (Exception ex) {}
    
      
    }
 
  public void fileChooser() {
        
        
        try {
        
        JFileChooser fileChooser = new JFileChooser("./Dati");
        int n = fileChooser.showOpenDialog(Framework.this);
        if (n == JFileChooser.APPROVE_OPTION) {
        File f = fileChooser.getSelectedFile();
        System.out.println("name: "+f);
        
        String nomefile= new String(f.toString());
        System.out.println(nomefile);
        LogReader lr= new LogReader(nomefile);
        if(lr.read())
        {
            System.out.println("LOG OK");
            
            
        }
        else{
           System.out.println("Errore chiudo"); 
           return;
        }
        
        log = lr.getVector();
        
        
        
        
        }
      } catch (Exception ex) {}
    
      
    }
 
 
 
}
