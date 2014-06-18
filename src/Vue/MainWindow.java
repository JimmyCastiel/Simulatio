/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Model.Signalisations.CouleurFeu;
import Model.Signalisations.Feu;
import Model.Signalisations.Panneau;
import Vue.Signalisations.VueFeu;
import Vue.Signalisations.VuePanneau;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 8460P
 */
public class MainWindow extends CircuFrame{
    
    /*** MODEL ***/
    
    /*** ELEMENTS ***/
    //Menus et items
    private JMenuBar 	menuBar;
    private JMenu 	menuFile;
    private JMenuItem 	itemImport;
    private JMenuItem 	itemImportXml;
    private JMenuItem 	itemExportToXml;
    private JSeparator 	menuSeparator;    
    private JMenuItem 	itemExit;
    
    private JMenu 	menuEdit;
    private JMenuItem 	itemDelete;
    private JSeparator 	menuSeparator3;
    private JMenuItem 	itemSave;

    private JMenu 	menuOptions;
    private JMenuItem 	itemPreferences;
    
    private JMenu 	menuAbout;
    private JMenuItem 	itemAbout;
    
    //Barre d'outils
    private JToolBar 	toolBar;
    private JButton 	buttonImport;
    private JButton 	buttonImportXml;
    private JButton 	buttonExportToXml;
    private JButton 	buttonDelete;
    private JButton 	buttonSave;
    private JButton 	buttonPreferences;
    
    //Carte
    private JPanel carteContainer;
    private boolean isMapEmpty;
    
    //Gestion
    private JPanel panelGestion;
    private JLabel listeRoutes;
    private JLabel listePanneaux;
    private JLabel listeLimitationsDeVitesse;
    private JLabel fluxCirculation;   
    private JLabel frequenceDesFeux;   
    private String [] routes;
    private String [] panneaux;
    private String [] limitationsDeVitesse;
    private JComboBox listeDeroulanteDeRoutes;
    private JComboBox listeDeroulanteDePanneaux;
    private JComboBox listeDeroulanteDeLimitationsDeVitesse;
    private JSlider slideFluxCirculation;
    private JSlider slideFrequenceDesFeux;
    
    //Panel Principal
    private JPanel panelSimulation;
    
    // SplitPane pour la carte et le panel de gestion 
    private JSplitPane 		verSplitPane;
    
    //
    private boolean carteVide = true;
    private String dernierChemin;
    
    //Test
    private Feu f;
    private VueFeu vf;
    private VuePanneau vp;
    private Panneau p;
    
    /*** MAINWINDOW SINGLETON ***/
    private static MainWindow INSTANCE = new MainWindow();
    
    public static MainWindow getInstance() {
            if (INSTANCE == null) { 
                    INSTANCE = new MainWindow();	
            }
            return INSTANCE;
    }
    
    private MainWindow() {
        initializeContent();
//        go();
        initializeEvents();
        setVisible(true);
    }
    
    private void initializeContent(){
        /*** WINDOW ***/
        //PARAMETRES
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(1000, 500);
        
        //CREATION MENUBAR
        this.menuBar = new JMenuBar();
        // Menu : File
        this.menuFile = new JMenu("File");
        // Item : File/Import
        this.itemImport = new JMenuItem("Import");
            //itemImport.setIcon(new ImageIcon()));
        // Item : File/Import XML File
        this.itemImportXml = new JMenuItem("ImportXML");
//        itemImportXml.setIcon();
        // Item : File/Export to xml
        this.itemExportToXml = new JMenuItem("ExportXML");
//        itemExportToXml.setIcon(new ImageIcon();
        this.itemExportToXml.setEnabled(false);
        // Separator : File/Separator
        this.menuSeparator = new JSeparator();
        this.menuSeparator.setForeground(SystemColor.controlHighlight);        
        // Item : File/Exit
        this.itemExit = new JMenuItem("Exit"); 
        // Menu : Edit
        this.menuEdit = new JMenu("Edit");
        // Item : Edit/Delete
        this.itemDelete = new JMenuItem("Delete Map");
//        itemDelete.setIcon();
        this.itemDelete.setEnabled(false); 
        // Separator : File/Separator
        this.menuSeparator3 = new JSeparator();
        this.menuSeparator3.setForeground(SystemColor.controlHighlight);        
        // Item : Edit/Save the tree
        this.itemSave = new JMenuItem("Save the map");
//        itemSave.setIcon(new ImageIcon());                
        this.itemSave.setEnabled(false);
        // Menu : Options
        this.menuOptions = new JMenu("Options");
        // Item : Options/Preferences
        this.itemPreferences = new JMenuItem("Preferences");
//        itemPreferences.setIcon(new ImageIcon());
        // Menu : About
        this.menuAbout = new JMenu("Help");
        // Item : About/About
        this.itemAbout = new JMenuItem("About");
        
        //AJOUT A LA MENUBAR
        this.menuFile.add(itemImport);
        this.menuFile.add(itemImportXml);
        this.menuFile.add(itemExportToXml);;
        this.menuFile.add(menuSeparator);
        this.menuFile.add(itemExit);
        this.menuEdit.add(itemDelete);
        this.menuEdit.add(menuSeparator3);
        this.menuEdit.add(itemSave);
        this.menuOptions.add(itemPreferences);
        this.menuAbout.add(itemAbout);
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(menuOptions);
        this.menuBar.add(menuAbout);

        this.setJMenuBar(menuBar);
        //CREATION de la toolbar
        this.toolBar = new JToolBar();
        this.toolBar.setFloatable(false);        
        // Button : Import
        this.buttonImport = new JButton("Import");
        this.buttonImport.setFocusable(false);
//        buttonImport.setIcon(new ImageIcon()));
        // Button : Import XML
        this.buttonImportXml = new JButton("Import XML");
        this.buttonImportXml.setFocusable(false);
//        buttonImportXml.setIcon(new ImageIcon())); 
        // Button : Export to xml
        this.buttonExportToXml = new JButton("ExportXML");
        this.buttonExportToXml.setFocusable(false);
//        buttonExportToXml.setIcon(new ImageIcon()));
        this.buttonExportToXml.setEnabled(false);        
        // Button : Delete
        this.buttonDelete = new JButton("Delete");
//        buttonDelete.setIcon(new ImageIcon()));
        this.buttonDelete.setFocusable(false);
        this.buttonDelete.setEnabled(false);     
        // Button : Preferences
        this.buttonPreferences = new JButton();
        this.buttonPreferences.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.buttonPreferences.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.buttonPreferences.setHorizontalAlignment(SwingConstants.RIGHT);
//        buttonPreferences.setIcon(new ImageIcon()));
        this.buttonPreferences.setFocusable(false);      
        
        //Ajout de la toolbar sur la fenetre
        this.toolBar.add(buttonImport);
        this.toolBar.add(buttonImportXml);
        this.toolBar.add(buttonExportToXml);
        this.toolBar.add(buttonDelete);
        this.toolBar.add(buttonPreferences);
        this.getContentPane().add(toolBar, BorderLayout.NORTH);    
        
        //Creation du container avec la carte
        this.carteContainer = new JPanel(new GridLayout());
        this.isMapEmpty = true;
        
        //Partie gestion simulation
        this.listeDeroulanteDeRoutes = new JComboBox();
        this.listeDeroulanteDeRoutes.setPreferredSize(new Dimension(20,10));
        this.listeDeroulanteDePanneaux = new JComboBox();
        this.listeDeroulanteDePanneaux.setPreferredSize(new Dimension(20,10));
        this.listeDeroulanteDeLimitationsDeVitesse = new JComboBox();
        this.listeDeroulanteDeLimitationsDeVitesse.setPreferredSize(new Dimension(20,10));
        this.slideFluxCirculation = new JSlider();
        this.slideFluxCirculation.setPreferredSize(new Dimension(20,10));
        this.slideFrequenceDesFeux = new JSlider();
        this.slideFrequenceDesFeux.setPreferredSize(new Dimension(20,10));
        this.listeRoutes = new JLabel("Les routes");
        this.listePanneaux = new JLabel("Les panneaux");
        this.listeLimitationsDeVitesse = new JLabel("Les limitations de vitesse");
        this.fluxCirculation = new JLabel("Flux de circulation");
        this.frequenceDesFeux = new JLabel("Fréquence des feux de signalisation");
        
        GridLayout g1 = new GridLayout(0,1);
        g1.setVgap(5);
        this.panelGestion = new JPanel(g1);
//        this.panelGestion.setBackground(Color.red);
        
        panelGestion.add(listeRoutes);
        panelGestion.add(listeDeroulanteDeRoutes);
        panelGestion.add(listePanneaux);
        panelGestion.add(listeDeroulanteDePanneaux);
        panelGestion.add(listeLimitationsDeVitesse);
        panelGestion.add(listeDeroulanteDeLimitationsDeVitesse);
        panelGestion.add(fluxCirculation);
        panelGestion.add(slideFluxCirculation);
        panelGestion.add(frequenceDesFeux);
        panelGestion.add(slideFrequenceDesFeux);
        
//        this.panelGestion.setPreferredSize(new Dimension(5,this.panelGestion.getPreferredSize().height));
        //Tests
        this.carteContainer = new JPanel();
        f = new Feu(0,1000);
//        vf = new VueFeu(f);
        String s = "Cedez-le-passage";
        p = new Panneau(s);
        vp = new VuePanneau(p);
//        this.carteContainer.add(vf);
        this.carteContainer.add(vp);
        this.carteContainer.setBackground(Color.blue);
        // CREATION splitpanes
        this.verSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelGestion, carteContainer);
        this.verSplitPane.setResizeWeight(0.5);
        this.getContentPane().add(verSplitPane, BorderLayout.CENTER);
        
        
    }
    
    public void initializeEvents(){
        importFileEvent();
        exportToXMLEvent();
    }
    
    public void importFileEvent(){
        ActionListener importFile = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                repaint();
                if(estCarteVide()){
                    SwingUtilities.invokeLater(new Runnable(){
                        public void run(){
                            repaint();
                            File inFile = null;
                            JFileChooser fc = new JFileChooser(dernierChemin);
                            CircuFrame cf = new CircuFrame();
                            FileFilter filtre = new FileNameExtensionFilter("Fichiers .txt","txt");
                            fc.setMultiSelectionEnabled(false);
                            fc.setAcceptAllFileFilterUsed(false);
                            fc.setFileFilter(filtre);
                            fc.setDialogTitle("Fichier source pour la carte");
                            int fboolean = fc.showOpenDialog(cf);
                            if(fboolean == JFileChooser.APPROVE_OPTION){
                                inFile = fc.getSelectedFile();
 //                               this.dernierChemin = fc.getCurrentDirectory().getAbsolutePath();
                            }
                        }
                    });
                }
            }
        };
        buttonImport.addActionListener(importFile);
        itemImport.addActionListener(importFile);    
        
        // --- Importation drag and drop
        
//        this.carteContainer.setDropTarget(new DropTarget(){
//            public synchronized void drop(DropTargetDropEvent dtde){
//                if(dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)){
//                    dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
//                    Transferable t = dtde.getTransferable();
//                    
//                }
//            }
//            
//        }
                
                
//                )
        
    }
    
    public void exportToXMLEvent(){
        ActionListener export = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                repaint();
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        repaint();
// Creation de la classe qui va gérer l'export XML
                    }
                });
            }
        };
        buttonExportToXml.addActionListener(export);
        itemImportXml.addActionListener(export);
        
    }
    
    
    public boolean estCarteVide(){
        if(carteVide){
            return true;
        }
        else if(JOptionPane.showConfirmDialog(null,
                                              "Vider la carte",
                                              "Toutes les doonées de la carte seront supprimées. Les données non sauvegardées seront perdues.Voulez-vous continuer?",
                                              JOptionPane.YES_NO_OPTION,
                                              JOptionPane.WARNING_MESSAGE)
                 == JOptionPane.OK_OPTION){
            effacerCarte();
            return true;
        }
        return false;                                    
    }
    
    public void effacerCarte(){
        
    }
    
    public void go(){

    }
}
