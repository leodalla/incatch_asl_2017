package incatch;

import java.util.Vector;
import java.util.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Incatch {
    
    private static void createAndShowGUI() {
        //Use the Java look and feel.
        try {
            UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { }
        Framework framework = new Framework();
        framework.addButton();
        int code = framework.run();
        while(code<0){
            
            System.out.println("code: "+code);
            if(code==-2){
                framework = new Framework();
                framework.addButton();
            }
            code = framework.run();
        
        }  
    }
    
    public static void main(String[] args) {
        TestDijkstraAlgorithm dijkstra= new TestDijkstraAlgorithm();
        dijkstra.testExcute();
        System.exit(-1);
        createAndShowGUI();
    }
}
