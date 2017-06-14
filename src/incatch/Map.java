/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incatch;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author CCIAA
 */
public class Map extends JPanel {
    
    private String nomeconfig;
    
    public Map(String n)
    {
        nomeconfig=n;
        nomeconfig=nomeconfig.concat("config.txt");
        System.out.println("fileconfig: "+ nomeconfig);
  
    }
    
}
