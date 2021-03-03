package LamgarrajNote;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*************************************************************
 * *  @author= lamgarraj mohamed                            **
 * *  @date= 22/01/2021                                     **
 * *  @Master= web intelligence and data science            **
 * *  @project= editeur de texte en java                    **
 * ***********************************************************
 * *             @class: Principal                          **
 * *  c la classe principale de notre editeur de text ,ici  **
 * *  vous trouvez la fonction @main et tout les composante **
 * *  graphique qui constituent notre interface graphique   **
 * *  et la connection entre le graphique et le code service**
 * *                                                        **
 * **********************************************************/
public class Principal extends JFrame implements ActionListener,WindowListener{
JMenuBar menuB;
JMenu outil,police,image,rech,rempl,compt,effac;
JMenuItem enregistrer,ouvrir,nouveu,soulign,gras,itlique,ajoutimg,reche, remplacer,compte,effacer;
JPanel panel;
JSpinner fontSizeSpinner;
JButton color;
JComboBox fontbox;
JToolBar tb;
JScrollPane scrollPane;
protected JTextPane T;

save saaving;
open opening;
photo imge;
police edit;
qlqtraitement traitement;



    public Principal(){
        super();
        // icon de mon bloc note  changer le path avec le path sur votre machine (lamgarraj.jpg)
        Image icone = Toolkit.getDefaultToolkit().getImage("C:\\Users\\moham\\IdeaProjects\\cour\\src\\LamgarrajNote\\files\\lamgarraj.jpg");
        setIconImage(icone);
        //     gerer close exeption **************
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener( this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        panel = new JPanel() ;
        menuB=new JMenuBar();
        saaving=new save(this);
        opening=new open(T,this);
        imge=new photo(this,T);
        edit=new police();
        traitement=new qlqtraitement();

        //*********************  MENU  *****************************************

        outil=new JMenu("home");
        rech=new JMenu("chercher");rempl=new JMenu("remplacer");
        compt=new JMenu("compter");effac=new JMenu("effecer");
        police=new JMenu("format");image=new JMenu("image");

        //*********************** menu items ***************************************
        enregistrer=new JMenuItem("enregistrer"); ouvrir=new JMenuItem("ouvrir");
        nouveu=new JMenuItem("nouveau");gras=new JMenuItem("gras");
        soulign=new JMenuItem("souligner");
        itlique=new JMenuItem("italique");
        ajoutimg=new JMenuItem("ajouter image");
        reche=new JMenuItem("chercher");
        remplacer =new JMenuItem("remplacer");
        compte=new JMenuItem("compter");effacer=new JMenuItem("efacer");

        /*********************  fonts  **************************************/
        fontbox=new JComboBox(fonts);
        fontbox.setSelectedItem("Arial");
        fontbox.addActionListener(this);

        /************************** /size/  *****************************/
        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                T.setFont(new Font(T.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));
            }

        });

/*************************** toolbare  // ltaht  **********************************************/
        tb = new JToolBar();
        tb.setRollover(true);
        color=new JButton("color");
       color.addActionListener(this);
        tb.add(color);
        tb.addSeparator();
        tb.add(fontSizeSpinner);
        tb.add(fontbox);

 /************************* menu bar costumizing  ********************************/
        menuB.add(outil);menuB.add(police);menuB.add(rech);
        menuB.add(rempl);menuB.add(compt);menuB.add(effac);
        menuB.add(image);
       // menuB.add(fontBox);
        outil.add(enregistrer);
        outil.add(ouvrir); outil.add(nouveu);rempl.add(remplacer);effac.add(effacer);
        rech.add(reche);compt.add(compte);
        police.add(soulign);
        police.add(gras);
        police.add(itlique);
        image.add(ajoutimg);

        /************************ zone tesxt  ******************************/
         T = new JTextPane() ;
        T.setFont(new Font("Arial",Font.PLAIN,14));
        scrollPane = new JScrollPane(T);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500,500));

        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      //  T.setSize(500,500); dimention dyal scroll pan suufisant



        compte.addActionListener(this);
        effacer.addActionListener(this);
        ouvrir.addActionListener(this);
        nouveu.addActionListener(this);
        ajoutimg.addActionListener(this);
        remplacer.addActionListener(this);
        reche.addActionListener(this);
        enregistrer.addActionListener(this);
        soulign.addActionListener(this);
        gras.addActionListener(this );
        itlique.addActionListener(this);
        setTitle("LamgarrajNote");
        setVisible(true);
        setSize(500, 500);
        getContentPane().add(menuB);
        //getContentPane().add(T);  zdt scrollpan automatiquement rani zdt l elemnt li attaché lih
        getContentPane().add(tb,BorderLayout.SOUTH);
        getContentPane().add(scrollPane);
        this.setJMenuBar(menuB);

    }



/*****************************"""""""""  Reponse au cliqueq """""""""""""""********************************/

    public void actionPerformed(ActionEvent e) {

        //****************** enregistrer ******************************

        if(e.getSource()== enregistrer){

            {
                String contenu = T.getText();
                if(contenu.isEmpty())
                { JOptionPane.showMessageDialog(this, "Vous n'avez rien saisi,il n'y a rien à enregistrer", "notif", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    saaving.enregistrerFichier(contenu);
                }
            }
        }
        
        ///******************** ouvrir file ************************************

        if(e.getSource()==ouvrir) {
               opening.openfile(T);

        }
        ////**************************** nouveaux text **********************************
        if (e.getSource() == nouveu )
        {
            String contenu = T.getText();
            if (contenu.isEmpty())
            {
                T.setText("");
            }
            else
            {
                int res = JOptionPane.showOptionDialog(this,"La zone de  texte n'est pas vide voulez vous  : ","Attention!",JOptionPane.NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new Object[]{"Enregistrer","Continuer sans enregistrer"},null);
                if (res == 0)
                {
                    saaving.enregistrerFichier(contenu);
                }
                if (res == 1)
                {
                    T.setText("");
                }
            }
        }
        ///******************************* add image **********************************
        if (e.getSource()==ajoutimg) {
            imge.addimg(T);
        }

        ////**********:::::::::::::: color dyal text kolo aussi khas ghir selected ::::::::::::::::::::::::::*************************
      /*  if(e.getSource()==color) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = colorChooser.showDialog(null, "Choose a color", Color.black);

            T.setForeground(color);
        }
*/

      /*  /////////////////////////////  font dyal text pan kolo ms khas ghi part sekected ///////////////////////////////
        if(e.getSource()==fontbox) {
            T.setFont(new Font((String)fontbox.getSelectedItem(),Font.PLAIN,T.getFont().getSize()));
        }*/


        //*************************  rechercher *****************************************:
        if (e.getSource()==reche)
        {
            traitement.recherch(this,T);

        }
        //*******************compter  **************************************
        if (e.getSource() == compte)
        {
            traitement.compter(this,T);

        }

        //************************* remplacer un elemnet *********************
        if (e.getSource() == remplacer)
        {
            traitement.remplacer(this,T);

        }

        //************************ effacer la zone du text **********************
        if (e.getSource() == effacer)
        {
            int choix = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment tout effacer?","Effacer le texte",JOptionPane.YES_NO_OPTION);
            if ( choix == JOptionPane.YES_OPTION)
            {
                T.setText("");
            }
        }


        //************************ font dyal selected text  **********************
        if (e.getSource() == fontbox) {
            edit.changeStyle(T, fontbox);
        }

        //************************ color dyal selected text  **********************
        if (e.getSource() == color) {
            edit.textcolor(T, color);
        }

        //************************   gras    ********************************************
        if (e.getSource() == gras) {
            edit.BoldStyle(T);
        }

        //************************ Italique  **********************
        if (e.getSource() == itlique) {
            edit.italicStyle(T);
        }

        //************************ fsouligné  **********************
        if (e.getSource() == soulign) {
            edit.soulignéStyle(T);
        }

    }

//****************** methodes de windowlistner **************************************************
    @Override
    public void windowOpened(WindowEvent e) {

    }
       // ************ si quiter et non ps encore enregistrer travaille *******************
    @Override
    public void windowClosing(WindowEvent a) {
        // TODO Auto-generated method stub
        if (!T.getText().isEmpty())
        {
            int alors = JOptionPane.showOptionDialog(this,"Voulez vous enregistrer les modifications avant de quittez?","Fermeture",JOptionPane.NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new Object[]{"enregistrer","Fermer sans enregistrer","Annuler"},null);
            if (alors == 0)
            {
                saaving.enregistrerFichier(T.getText());
                System.exit(0);
            }
            if (alors == 1)
            {
                System.exit(0);
            }
        }
        else
        {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


/*********************** main ***********************************************************/

    public static void main(String[] args){
        Principal p=new Principal();
        p.setVisible(true);
    }
/***************************  main *********************************************************/


}

