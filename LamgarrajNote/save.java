package LamgarrajNote;

import javax.swing.*;
import java.io.*;
/*************************************************************
 * *  @author= lamgarraj mohamed                            **
 * *  @date= 23/01/2021                                     **
 * *  @Master= web intelligence and data science            **
 * *  @project= editeur de texte en java                    **
 * ***********************************************************
 * *             @class: save                               **
 * *  ici vous trouver les methodes responsable             **
 **   d'enregistrer le contenue de zone de texte dans       **
 **   un fihier .txt sur votre support du stockage          **
 **                                                         **
 * *                                                        **
 * **********************************************************/
public class save {
JFrame parent;
save(JFrame p){
    this.parent=p;
}
        public void actionPerformed(String phrase) {
            JFileChooser save = new JFileChooser();
            save.setDialogTitle("Enregistrer");
            save.setAcceptAllFileFilterUsed(true);
            int enregistre = save.showSaveDialog(parent);
            if (enregistre == JFileChooser.APPROVE_OPTION) {
                File fichier = save.getSelectedFile();
                if (!fichier.exists()) {
                    if (!save.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
                        save.getSelectedFile().getAbsolutePath().concat(".txt");
                    }
                    ecrireDansFichier(fichier, phrase);
                } else {
                    int resu = JOptionPane.showConfirmDialog(parent, "Le fichier existe déja voulez le vous vraiment le remplacer?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resu == JOptionPane.YES_OPTION) {
                        ecrireDansFichier(fichier, phrase);
                    }
                    if (resu == JOptionPane.NO_OPTION) {
                        save.showSaveDialog(parent);
                        File nFichier = save.getSelectedFile();
                        ecrireDansFichier(nFichier, phrase);
                    }
                }
            }

    }
    void ecrireDansFichier(File fichier, String texte)
    {
        try{
            FileWriter fiw =  new FileWriter(fichier);
            BufferedWriter bw = new BufferedWriter(fiw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(texte);
            pw.close();
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(parent, "fichier non trouvé!!!", "Erreur",JOptionPane.WARNING_MESSAGE );}
        catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "Erreur lors de la lecture du fichier", "Erreur",JOptionPane.WARNING_MESSAGE );}
    }
    protected void enregistrerFichier(String phrase)
    {
        JFileChooser save = new JFileChooser();
        save.setDialogTitle("Enregistrer");
        save.setAcceptAllFileFilterUsed(true);
        int enregistre = save.showSaveDialog(parent);
        if (enregistre == JFileChooser.APPROVE_OPTION)
        {
            File fichier = save.getSelectedFile();
            if (!fichier.exists())
            {
                if (!save.getSelectedFile().getAbsolutePath().endsWith(".txt"))
                {
                    save.getSelectedFile().getAbsolutePath().concat(".txt");
                }
                ecrireDansFichier(fichier,phrase);
            }
            else
            {
                int resu = JOptionPane.showConfirmDialog(parent, "Le fichier existe déja voulez le vous vraiment le remplacer?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if ( resu == JOptionPane.YES_OPTION)
                {
                    ecrireDansFichier(fichier,phrase);
                }
                if (resu == JOptionPane.NO_OPTION)
                {
                    save.showSaveDialog(parent);
                    File nFichier = save.getSelectedFile();
                    ecrireDansFichier(nFichier,phrase);
                }
            }
        }
    }


}
