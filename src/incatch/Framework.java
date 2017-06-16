package incatch;

import java.util.Vector;
import java.util.*;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.geom.Point2D;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.lang.Math;

import java.awt.geom.Ellipse2D;

public class Framework extends JPanel implements ActionListener{
    //Variabile d'istanza
    private ImageIcon mapIcon;
    private BufferedImage mapImage;
    private JLabel mapLabel;
    private JFrame frame;
    private JButton playButton,
                    stopButton,
                    nextButton,
                    mapButton,
                    logButton,
                    graphButton,
                    riconoscimentiButton;
    private JPanel buttonPanel,progressPanel;
    private String mapname;
    //actions
    //0 standby
    //1 play
    //2 stop
    //3 next
    private int actions;
    private Vector<Pose> log;
    private Map map;
    
    private GraphDraw graphFrame;
    
    public Framework(){
        JFrame.setDefaultLookAndFeelDecorated(false);
        frame = new JFrame("IntcatchDEMO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //stand by
        actions = 0;
        log = null;
        
    }
    
    public void addButton(){
        //play
        ImageIcon playButtonIcon = new ImageIcon("images/play.png");
        playButton = new JButton(playButtonIcon);
        playButton.setActionCommand("play");
        playButton.addActionListener(this);
        buttonPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(playButton);
        //stop
        ImageIcon stopButtonIcon = new ImageIcon("images/stop.png");
        stopButton = new JButton(stopButtonIcon);
        stopButton.setActionCommand("stop");
        stopButton.addActionListener(this);
        buttonPanel.add(stopButton);
        //next
        ImageIcon nextButtonIcon = new ImageIcon("images/next.png");
        nextButton = new JButton(nextButtonIcon);
        nextButton.setActionCommand("next");
        nextButton.addActionListener(this);
        buttonPanel.add(nextButton);
        //button map
        ImageIcon mapButtonIcon = new ImageIcon("images/map.png");
        mapButton = new JButton(mapButtonIcon);
        mapButton.setActionCommand("map");
        mapButton.addActionListener(this);
        buttonPanel.add(mapButton);
        //button images
        ImageIcon logButtonIcon = new ImageIcon("images/log.png");
        logButton = new JButton(logButtonIcon);
        logButton.setActionCommand("log");
        logButton.addActionListener(this);
        buttonPanel.add(logButton);
        //graph button
        ImageIcon graphButtonIcon = new ImageIcon("images/graph.png");
        graphButton = new JButton(graphButtonIcon);
        graphButton.setActionCommand("graph");
        graphButton.addActionListener(this);
        buttonPanel.add(graphButton);
        //riconoscimenti button
        ImageIcon riconoscimentiButtonIcon = new ImageIcon("images/rico.png");
        riconoscimentiButton = new JButton(riconoscimentiButtonIcon);
        riconoscimentiButton.setActionCommand("rico");
        riconoscimentiButton.addActionListener(this);
        buttonPanel.add(riconoscimentiButton);
        //altro
        frame.getContentPane().add(buttonPanel,BorderLayout.NORTH);
        frame.setVisible(true);
        frame.repaint();  
        mapButton.setEnabled(false);
        graphButton.setEnabled(false);
    }
    
    public void addMap(){
        mapImage= map.getMapImage();
        mapIcon=new ImageIcon(mapImage);
        mapLabel=new JLabel(mapIcon);
        frame.getContentPane().add(mapLabel,BorderLayout.CENTER);
        frame.getContentPane().add(new JScrollPane(mapLabel), BorderLayout.CENTER);
        frame.setVisible(true);       
    }
    
    public void drawMap(Map map,Vector<Point2D> vector){
    //drawMap
    }
    
    public int run(){
         while(actions==0){
            try{
                Thread.sleep(300);
            }
            catch(InterruptedException e) {}
        }    
        if(log==null){
            
            //condizione valida se il log non viene caricato
            if(actions==1){
                String message = "selezionare un log prima di premere play.";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
                actions=0;
                playButton.setEnabled(true);
                return(-1);
            }     
            if(actions==2){
            //condizione valida se attivo stop prima di play
                if(actions==0){
                String message = "selezionare prima play di stop!";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
                actions=0;
                return(-1);
                }
            }
            if(actions==3){
            //condizione valida se attivo stop prima di play
                if(actions==0){
                String message = "selezionare il LOG!";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
                actions=0;
                return(-1);
                }
            }
        }
        else{
            mapButton.setEnabled(false);
            
        }
                Graphics2D g2d = mapImage.createGraphics();
                g2d.setColor(Color.RED); 
                Iterator<Pose> it= log.iterator();
                
                while(it.hasNext()){
                    while((actions==1)&&(it.hasNext())){
                        Pose p = it.next();
                        Point2D puntoImmagine = map.convert(p);
                        g2d.fillOval((int)(puntoImmagine.getX()), (int)(puntoImmagine.getY()), 3, 3);
                        frame.revalidate();
                        frame.repaint();
                   }
                    while(actions==2){
                            stopButton.setEnabled(false);
                            try{
                                Thread.sleep(30);
                            }
                            catch(InterruptedException e){}
                    }
                    if(actions==3){
                        actions=0;
                        while((actions==0)&&(it.hasNext())){
                            Pose p = it.next();
                            Point2D puntoImmagine = map.convert(p);
                            g2d.fillOval((int)(puntoImmagine.getX()), (int)(puntoImmagine.getY()), 3, 3);
                            frame.revalidate();
                            frame.repaint();
                            actions=2;
                        }  
                    }
                }
                
            System.out.println("Log complete");
            actions=2;
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

        }
        else if(command.equals("next")){
            playButton.setEnabled(true);
            stopButton.setEnabled(true);
            nextButton.setEnabled(true);
            actions= 3;
        }
        else if(command.equals("map")){
            mapChooser();
            graphButton.setEnabled(true);
            mapButton.setEnabled(false);
        }
        else if(command.equals("log")){
            fileChooser();
            mapButton.setEnabled(true);  
            logButton.setEnabled(false);
        }
        else if(command.equals("graph")){
            createGraph();
        }
        else if(command.equals("rico")){
            rico();
        }
    }
 
    public void mapChooser() {
        try {        
           JFileChooser fileChooser = new JFileChooser("./dati");
           int n = fileChooser.showOpenDialog(Framework.this);
           if (n == JFileChooser.APPROVE_OPTION) {
               File f = fileChooser.getSelectedFile();
               mapname=f.toString();
               MapReader mr = new MapReader(mapname);
               map = mr.getMap();
               addMap();
               }
               }
        catch (Exception ex) {
           } 
    }
    public void rico() {
        JOptionPane.showMessageDialog(frame,
    "Programma sviluppato da \nCarloBottaro, LeonardoDallaRiva e DomenicoBloisi",
    "CREDITI.",
    JOptionPane.PLAIN_MESSAGE);
    }
 
    public void fileChooser() {  
        try {       
        JFileChooser fileChooser = new JFileChooser("./Dati");
        int n = fileChooser.showOpenDialog(Framework.this);
        if (n == JFileChooser.APPROVE_OPTION) {
        File f = fileChooser.getSelectedFile();
        String nomefile= new String(f.toString());
        LogReader lr= new LogReader(nomefile);
        if(lr.read()){
             }
        else{
           System.out.println("Errore chiudo"); 
           return;
            }
        log = lr.getVector();
             }
             } 
        catch (Exception ex) {
             }
    }
    
    public void createGraph() {
        JProgressBar progressBar = new JProgressBar();
        progressPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        graphFrame = new GraphDraw("Graph");
        graphFrame.setSize((int)(mapImage.getWidth()),
                               (int)(mapImage.getHeight()));
        graphFrame.setVisible(true);
        graphFrame.add(progressPanel);
        progressPanel.add(progressBar);
       
        int cont=0;
        double temp_x=0,temp_y=0;
        
        double max=-1;
        //log is a vector of <Pose>
        Iterator<Pose> it = log.iterator();
        while(it.hasNext()) {
            Pose pose = it.next();
            Point2D point = map.convert(pose);
            double x = point.getX();
            double y = point.getY();
                        cont++;
                        //System.out.println("cont: "+ cont);
                        progressBar.setValue(cont);
                        progressBar.setVisible(true);
                       
            ArrayList<Node> nodes = graphFrame.getNodes();
            
            Node n = new Node(nodes.size(),
                        point.getX(),
                        point.getY(),
                        (int)x,
                        (int)y);
            
            temp_x=point.getX();
            temp_y=point.getY();
            Pose oldpose=null;
            
            for(int i=0;i<log.size();i++)
            {
                
                Pose p= log.get(i);
                if(oldpose==null)
                {
                    oldpose=p;
                }
                else
                {
                    Point2D p1 = map.convert(p);
                    Point2D p2 = map.convert(oldpose);
                    double d = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) +
                         Math.pow(p1.getY() - p2.getY(), 2));
                    
                    //System.out.println("d: "+ d);
                    if(max<d)
                    {
                        max=d;
                        System.out.println("max: "+ max);
                    }
                    oldpose=p;
                }
                
                
            }
            
            
            for (Node node : nodes) {
                
                
               // System.out.println(node.toString());
                double d = GraphDraw.distanceBetweenUTM( x, y, node.getX(), node.getY());
                       
                
                //System.out.println("d: "+ d);
                if(d < max && d > 0) {
                    graphFrame.addEdge(node.getIdx(), n.getIdx());
                }
            }
            graphFrame.addNode(n);
            
            //wait
            try{
                Thread.sleep(30);
            }
            catch(InterruptedException ie) {

            }
            
            graphFrame.revalidate();
            graphFrame.repaint();
        }
        
        System.out.println("finito" +max);
    }
}


