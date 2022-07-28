/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jonathan
 */
public class Gui extends JFrame{
    final JTextArea pokeName=null;
    final JButton button=null;
    ImageIcon image;
    IArbolBusqueda<String,Pokemon> arbol;
    
    public void Media() throws IOException, LineUnavailableException{
        try {
            AudioInputStream audioInputStream=AudioSystem.
                    getAudioInputStream(
                    new File("C:/Users/JY/Documents/NetBeansProjects/2022/ED2_ProyectoBST/img/audio/101-opening.wav").getAbsoluteFile());
            Clip clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
    
    public void editSound() throws IOException, LineUnavailableException{
        try {
            AudioInputStream audioInputStream=AudioSystem.
                    getAudioInputStream(
                    new File("C:/Users/JY/Documents/NetBeansProjects/2022/ED2_ProyectoBST/img/audio/edit-8bit.wav").getAbsoluteFile());
            Clip clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
    
    public void quitSound() throws IOException, LineUnavailableException{
        try {
            AudioInputStream audioInputStream=AudioSystem.
                    getAudioInputStream(
                    new File("C:/Users/JY/Documents/NetBeansProjects/2022/ED2_ProyectoBST/img/audio/quit-8-bit.wav").getAbsoluteFile());
            Clip clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
    
    public void saveSound() throws IOException, LineUnavailableException{
        try {
            AudioInputStream audioInputStream=AudioSystem.
                    getAudioInputStream(
                    new File("C:/Users/JY/Documents/NetBeansProjects/2022/ED2_ProyectoBST/img/audio/save-8-bit.wav").getAbsoluteFile());
            Clip clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
    
    
    public Gui() throws IOException, LineUnavailableException{
        
        JPanel jp=new JPanel();
        
        image=new ImageIcon("C:/Users/JY/Downloads/pokedex.png");
        JLabel img=new JLabel(image);
        
        img.setSize(500,390);
        img.setLocation(0,0);
        
        //ImageIcon imgPokemon=new ImageIcon("C:/Users/JY/Downloads/charmanderIcon.png");
        
        JLabel pokImg=new JLabel();
        pokImg.setSize(100,90);
        pokImg.setLocation(90, 130);
        
       
        //para pokemones
        JTextField textFieldPoke=new JTextField("");
        textFieldPoke.setEnabled(true);
        textFieldPoke.setEditable(true);
        textFieldPoke.setColumns(10);
        textFieldPoke.setBackground(new Color(95,196,128,255));
        textFieldPoke.setForeground(Color.WHITE);
        textFieldPoke.setFont(new java.awt.Font("Tahoma", 1, 11));
        textFieldPoke.setDisabledTextColor(Color.RED);
        textFieldPoke.setBorder(new LineBorder(new Color(95,196,128,255)));
        textFieldPoke.setBounds(70, 315, 70, 30);
        textFieldPoke.setVisible(true);
        
        Media();
        
        //level
        final JTextField Lvl=new JTextField("LVL");
        Lvl.setColumns(10);
        Lvl.setBackground(new Color(34,196,234,255));
        Lvl.setForeground(Color.WHITE);
        Lvl.setOpaque(false);
        Lvl.setEditable(false);
        Lvl.setFont(new java.awt.Font("Tahoma", 1, 11));
        Lvl.setBorder(BorderFactory.createEmptyBorder());
        Lvl.setDisabledTextColor(Color.RED);
        Lvl.setBounds(307, 205, 25, 20);
        Lvl.setEnabled(true);
        Lvl.setVisible(true);
        
        final JTextField LvlIn=new JTextField("");
        LvlIn.setColumns(10);
        LvlIn.setBackground(new Color(34,196,234,255));
        LvlIn.setForeground(Color.WHITE);
        Lvl.setOpaque(false);
        LvlIn.setEditable(false);
        LvlIn.setFont(new java.awt.Font("Tahoma", 1, 11));
        LvlIn.setBorder(BorderFactory.createEmptyBorder());
        LvlIn.setDisabledTextColor(Color.RED);
        LvlIn.setBounds(307, 228, 25, 20);
        LvlIn.setEnabled(true);
        //LvlIn.setVisible(true);
        
        //cp
        final JTextField cp=new JTextField("CP");
        cp.setColumns(10);
        cp.setBackground(new Color(34,196,234,255));
        cp.setForeground(Color.WHITE);
        //Lvl.setOpaque(false);
        //cp.setEditable(false);
        cp.setFont(new java.awt.Font("Tahoma", 1, 11));
        cp.setBorder(BorderFactory.createEmptyBorder());
        cp.setDisabledTextColor(Color.RED);
        cp.setBounds(340, 205, 25, 20);
        cp.setEnabled(true);
        cp.setVisible(true);
        
        
        final JTextField cpIn=new JTextField("");
        cpIn.setColumns(10);
        cpIn.setBackground(new Color(34,196,234,255));
        cpIn.setForeground(Color.WHITE);
        //Lvl.setOpaque(false);
        cpIn.setEditable(false);
        cpIn.setFont(new java.awt.Font("Tahoma", 1, 11));
        cpIn.setBorder(BorderFactory.createEmptyBorder());
        cpIn.setDisabledTextColor(Color.RED);
        cpIn.setBounds(340, 228, 25, 20);
        cpIn.setEnabled(true);
        cpIn.setVisible(true);
        
        //ID
        final JTextField id=new JTextField("ID#");
        id.setColumns(10); 
        id.setBackground(new Color(34,196,234,255));
        id.setForeground(Color.WHITE);
        //Lvl.setOpaque(false);
        id.setEditable(false);
        id.setFont(new java.awt.Font("Tahoma", 1, 11));
        id.setBorder(BorderFactory.createEmptyBorder());
        id.setDisabledTextColor(Color.RED);
        id.setBounds(370, 205, 25, 20);
        id.setEnabled(true);
        id.setVisible(true);
        
        final JTextField idIn=new JTextField("");
        idIn.setColumns(10);
        idIn.setBackground(new Color(34,196,234,255));
        idIn.setForeground(Color.WHITE);
        //Lvl.setOpaque(false);
        idIn.setEditable(false);
        idIn.setFont(new java.awt.Font("Tahoma", 1, 11));
        idIn.setBorder(BorderFactory.createEmptyBorder());
        idIn.setDisabledTextColor(Color.RED);
        idIn.setBounds(370, 228, 25, 20);
        idIn.setEnabled(true);
        //idIn.setVisible(true);
        
        //attk
        final JTextField atk=new JTextField("ATK");
        atk.setColumns(10);
        atk.setBackground(new Color(34,196,234,255));
        atk.setForeground(Color.WHITE);
        //Lvl.setOpaque(false);
        atk.setEditable(false);
        atk.setFont(new java.awt.Font("Tahoma", 1, 11));
        atk.setBorder(BorderFactory.createEmptyBorder());
        atk.setDisabledTextColor(Color.RED);
        atk.setBounds(405, 205, 25, 20);
        atk.setEnabled(true);
        atk.setVisible(true);
        
        final JTextField atkIn=new JTextField("");
        atkIn.setColumns(10);
        atkIn.setBackground(new Color(34,196,234,255));
        atkIn.setForeground(Color.WHITE);
        //Lvl.setOpaque(false);
        atkIn.setEditable(false);
        atkIn.setFont(new java.awt.Font("Tahoma", 1, 11));
        atkIn.setBorder(BorderFactory.createEmptyBorder());
        atkIn.setDisabledTextColor(Color.RED);
        atkIn.setBounds(405, 228, 25, 20);
        atkIn.setEnabled(true);
        //atkIn.setVisible(true);
        
        //DEF
        final JTextField def=new JTextField("DEF");
        def.setColumns(10);
        def.setBackground(new Color(34,196,234,255));
        def.setForeground(Color.WHITE);
        //Lvl.setOpaque(false);
        def.setEditable(false);
        def.setFont(new java.awt.Font("Tahoma", 1, 11));
        def.setBorder(BorderFactory.createEmptyBorder());
        def.setDisabledTextColor(Color.RED);
        def.setBounds(435, 205, 25, 20);
        def.setEnabled(true);
        def.setVisible(true);
        
        
        final JTextField defIn=new JTextField("");
        defIn.setColumns(10);
        defIn.setBackground(new Color(34,196,234,255));
        defIn.setForeground(Color.WHITE);
        //Lvl.setOpaque(false);
        defIn.setEditable(false);
        defIn.setFont(new java.awt.Font("Tahoma", 1, 11));
        defIn.setBorder(BorderFactory.createEmptyBorder());
        defIn.setDisabledTextColor(Color.RED);
        defIn.setBounds(435, 228, 25, 20);
        defIn.setEnabled(true);
        //defIn.setVisible(true);
        
        // save
        final JTextField sav=new JTextField();
        sav.setColumns(10);
        sav.setBackground(Color.WHITE);
        sav.setForeground(Color.BLACK);
        //Lvl.setOpaque(false);
        //sav.setEditable(false);
        sav.setFont(new java.awt.Font("Tahoma", 1, 11));
        sav.setBorder(BorderFactory.createEmptyBorder());
        sav.setDisabledTextColor(Color.RED);
        sav.setBounds(306, 273, 29, 20);
        sav.setEnabled(true);
        sav.setVisible(false);
        
        //edit
        final JTextField edt=new JTextField();
        edt.setColumns(10);
        edt.setBackground(Color.WHITE);
        edt.setForeground(Color.BLACK);
        //Lvl.setOpaque(false);
        edt.setEditable(false);
        edt.setFont(new java.awt.Font("Tahoma", 1, 11));
        edt.setBorder(BorderFactory.createEmptyBorder());
        edt.setDisabledTextColor(Color.RED);
        edt.setBounds(340, 273, 28, 20);
        edt.setEnabled(true);
        //edt.setVisible(true);
        
        
        //quit
        final JTextField qt=new JTextField();
        qt.setColumns(10);
        qt.setBackground(Color.WHITE);
        qt.setForeground(Color.BLACK);
        //Lvl.setOpaque(false);
        qt.setEditable(false);
        qt.setFont(new java.awt.Font("Tahoma", 1, 11));
        qt.setBorder(BorderFactory.createEmptyBorder());
        qt.setDisabledTextColor(Color.RED);
        qt.setBounds(340, 273, 28, 20);
        qt.setEnabled(true);
        //qt.setVisible(true);
        
        //MENSAJE
        final JTextField msg=new JTextField("");
        msg.setColumns(10);
        msg.setBackground(Color.WHITE);
        msg.setForeground(Color.BLACK);
        msg.setFont(new java.awt.Font("Tahoma", 1, 30));
        msg.setDisabledTextColor(Color.RED);
        msg.setBorder(new LineBorder(Color.WHITE));
        msg.setBounds(60, 145, 100, 50);
        msg.setEnabled(true);
        msg.setVisible(false);
        
        
        //type1
        final JTextField tp1=new JTextField();
        tp1.setColumns(10);
        tp1.setBackground(new Color(8,64,53,255));
        tp1.setForeground(Color.WHITE);
        //bLvl.setOpaque(false);
        tp1.setEditable(false);
        tp1.setFont(new java.awt.Font("Tahoma", 1, 14));
        tp1.setBorder(BorderFactory.createEmptyBorder());
        tp1.setDisabledTextColor(Color.RED);
        tp1.setBounds(308, 320, 55, 20);
        tp1.setEnabled(true);
        tp1.setVisible(true);
        
        //type2
        final JTextField tp2=new JTextField();
        tp2.setColumns(10);
        tp2.setBackground(new Color(8,64,53,255));
        tp2.setForeground(Color.WHITE);
        //bLvl.setOpaque(false);
        tp2.setEditable(false);
        tp2.setFont(new java.awt.Font("Tahoma", 1, 14));
        tp2.setBorder(BorderFactory.createEmptyBorder());
        tp2.setDisabledTextColor(Color.RED);
        tp2.setBounds(393, 320, 55, 20);
        tp2.setEnabled(true);
        tp2.setVisible(true);
        
        //ABB
        final JTextField abb=new JTextField("ABB");
        abb.setColumns(10);
        abb.setBackground(new Color(8,64,53,255));
        abb.setForeground(Color.WHITE);
        //bLvl.setOpaque(false);
        abb.setEditable(false);
        abb.setFont(new java.awt.Font("Tahoma", 1, 11));
        //abb.setBorder(BorderFactory.createEmptyBorder());
        abb.setDisabledTextColor(Color.RED);
        abb.setBounds(305, 375, 28, 20);
        abb.setEnabled(true);
        abb.setVisible(true);
        
        //AVL
        final JTextField avl=new JTextField("AVL");
        avl.setColumns(10);
        avl.setBackground(new Color(8,64,53,255));
        avl.setForeground(Color.WHITE);
        //bLvl.setOpaque(false);
        avl.setEditable(false);
        avl.setFont(new java.awt.Font("Tahoma", 1, 11));
        //avl.setBorder(BorderFactory.createEmptyBorder());
        avl.setDisabledTextColor(Color.RED);
        avl.setBounds(340, 375, 28, 20);
        avl.setEnabled(true);
        avl.setVisible(true);
        
        //AMV
        final JTextField amv=new JTextField("AMV");
        amv.setColumns(10);
        amv.setBackground(new Color(8,64,53,255));
        amv.setForeground(Color.WHITE);
        //bLvl.setOpaque(false);
        amv.setEditable(false);
        amv.setFont(new java.awt.Font("Tahoma", 1, 11));
        //amv.setBorder(BorderFactory.createEmptyBorder());
        amv.setDisabledTextColor(Color.RED);
        amv.setBounds(390, 375, 28, 20);
        amv.setEnabled(true);
        amv.setVisible(true);
        
        //AB
        final JTextField ab=new JTextField("ARB");
        ab.setColumns(10);
        ab.setBackground(new Color(8,64,53,255));
        ab.setForeground(Color.WHITE);
        //bLvl.setOpaque(false);
        ab.setEditable(false);
        ab.setFont(new java.awt.Font("Tahoma", 1, 11));
        //ab.setBorder(BorderFactory.createEmptyBorder());
        ab.setDisabledTextColor(Color.RED);
        ab.setBounds(420, 375, 28, 20);
        ab.setEnabled(true);
        ab.setVisible(true);
        
        
        
        jp.add(img);
        jp.add(pokImg);
        
        jp.add(textFieldPoke);
        
        
        
        add(Lvl);
        add(LvlIn);
        
        add(cp);
        add(cpIn);
        
        add(id);
        add(idIn);
        
        
        add(atk);
        add(atkIn);
        
        add(def);
        add(defIn);
        
        add(sav);
        add(edt);
        add(qt);
        add(msg);
        
        
        add(abb);
        add(avl);
        add(amv);
        add(ab);
        
        add(tp1);
        add(tp2);
        
        this.add(jp);
        
        //pokImg.setLayout(null);
        
        jp.setLayout(null);
        
        
        
        abb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                arbol = new ArbolBinarioBusqueda<>();
                CrearArray array = new CrearArray();
                arbol = array.CrearArray();
                abb.setBackground(Color.red);
                avl.setBackground(new Color(8,64,53,255));
                amv.setBackground(new Color(8,64,53,255));
                ab.setBackground(new Color(8,64,53,255));
            }
        });
        
        avl.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                arbol = new AVL<>();
                CrearArray array = new CrearArray();
                arbol = array.CrearArray();
                avl.setBackground(Color.red);
                abb.setBackground(new Color(8,64,53,255));
                amv.setBackground(new Color(8,64,53,255));
                ab.setBackground(new Color(8,64,53,255));
            }
        });
        
        amv.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                arbol = new ArbolMViasBusqueda<>();
                CrearArray array = new CrearArray();
                arbol = array.CrearArray();
                amv.setBackground(Color.red);
                avl.setBackground(new Color(8,64,53,255));
                abb.setBackground(new Color(8,64,53,255));
                ab.setBackground(new Color(8,64,53,255));
            }
        });
        
        ab.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                arbol = new ArbolB<>();
                CrearArray array = new CrearArray();
                arbol = array.CrearArray();
                ab.setBackground(Color.red);
                avl.setBackground(new Color(8,64,53,255));
                amv.setBackground(new Color(8,64,53,255));
                abb.setBackground(new Color(8,64,53,255));
            }
        });
        
        qt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    quitSound();
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
                sav.setText("");
                sav.setVisible(false);
                qt.setText("");
                qt.setVisible(false);
                edt.setText("EDIT");
                edt.setVisible(true);
                
            }
        });
        
        edt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    editSound();
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
                edt.setText("");
                edt.setVisible(false);
                
                sav.setText("SAVE");
                sav.setVisible(true);
                sav.setEditable(false);
                
                qt.setText("QUIT");
                qt.setVisible(true);
                
                LvlIn.setEditable(true);
                cpIn.setEditable(true);
                atkIn.setEditable(true);
                //idIn.setEditable(true);
                defIn.setEditable(true);
                
                tp1.setVisible(false);
                tp2.setVisible(false);
            }
        });
        
        sav.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    saveSound();
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
                String name = textFieldPoke.getText();
                textFieldPoke.setText("");
                
                Pokemon pok = arbol.buscar(name);
                
                pok.setLevel(Integer.parseInt(LvlIn.getText()));
                pok.setCp(Integer.parseInt(cpIn.getText()));
                pok.setAtk(Integer.parseInt(atkIn.getText()));
                pok.setDef(Integer.parseInt(defIn.getText()));
                
                arbol.Insertar(name, pok);
                
                pokImg.setVisible(false);
                
                msg.setText("SAVE!");
                msg.setVisible(true);
                
                Timer timer=new Timer();
                timer.schedule(new TimerTask(){
                    @Override
                    public void run() {
                        sav.setVisible(false);
                        qt.setVisible(false);
                        LvlIn.setVisible(false);
                        cpIn.setVisible(false);
                        idIn.setVisible(false);
                        atkIn.setVisible(false);
                        defIn.setVisible(false);
                    }
                    
                }, 1000);
                timer.schedule(new TimerTask(){
                    @Override
                    public void run() {
                        
                        textFieldPoke.setText("");
                        msg.setVisible(false);
                        Lvl.setEditable(false);
                        Lvl.setVisible(true);
                        cp.setVisible(true);
                        id.setVisible(true);
                        atk.setVisible(true);
                        def.setVisible(true);
                    }
                    
                }, 1000);
                
            }
        });
        
        textFieldPoke.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                String name = textFieldPoke.getText();
                if (arbol != null && !textFieldPoke.getText().isEmpty()) {
                    System.out.println("Perdido foco");
                    Pokemon pok = arbol.buscar(name);
                    System.out.println(pok.getName());
                    
                    LvlIn.setText(Integer.toString(pok.getLevel()));
                    Lvl.setText("LVL");
                    Lvl.setVisible(true);
                    LvlIn.setVisible(true);
                    LvlIn.setEnabled(true);
                    
                    cpIn.setText(Integer.toString(pok.getCp()));
                    cp.setVisible(true);
                    cp.setEditable(false);
                    cpIn.setVisible(true);
                    cpIn.setEnabled(true);
                    
                    idIn.setText(Integer.toString(pok.getNumb()));
                    id.setVisible(true);
                    id.setEditable(false);
                    idIn.setVisible(true);
                    
                    atkIn.setText(Integer.toString(pok.getAtk()));
                    atk.setVisible(true);
                    atk.setEditable(false);
                    atkIn.setVisible(true);
                    
                    defIn.setText(Integer.toString(pok.getDef()));
                    def.setVisible(true);
                    def.setEditable(false);
                    defIn.setVisible(true);
                    //sav.setText("SAVE");
                    System.out.println(pok.getImage());
                    
                    tp1.setText(pok.getType1());
                    tp1.setVisible(true);
                    
                    tp2.setText(pok.getType2());
                    tp2.setVisible(true);
                    
                    pokImg.setIcon(new ImageIcon(pok.getImage()));
                    pokImg.setVisible(true);
                    //pokImg.setLocation(55, 100);
                    
                    edt.setText("EDIT");
                    edt.setEditable(false);
                    edt.setVisible(true);
                    edt.setEnabled(true);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(arbol==null){
                    System.out.println("Porfavor seleccione un tipo de arbol");
                }
                if (arbol != null) {
                    System.out.println(arbol.recorridoEnInOrden());
                }
            }
        });
        
        this.setSize(550,440);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
      
}
