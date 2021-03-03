package LamgarrajNote;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.io.*;
import java.util.Scanner;

/*************************************************************
 * *  @author= lamgarraj mohamed                            **
 * *  @date= 23/01/2021                                     **
 * *  @Master= web intelligence and data science            **
 * *  @project= editeur de texte en java                    **
 * ***********************************************************
 * *             @class: open                               **
 * *  ici vous trouver les methodes responsable d'ouverture **
 * *     des fichier texte                                  **
 * **********************************************************/
public class open {

   private JTextPane t;
    private JFrame f;
    save s;
    public open(JTextPane t,JFrame f){
        this.t=t;
         this.f=f;
    }


    protected void lireFichier(JTextPane tt)
    {     JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        int response = fileChooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            Scanner fileIn = null;

            try {
                fileIn = new Scanner(file);
                if(file.isFile()) {
                    while(fileIn.hasNextLine()) {
                        String line = fileIn.nextLine()+"\n";
                        StyledDocument document = (StyledDocument) tt.getDocument();
                        document.insertString(document.getLength(), line, null);
                        tt.setDocument(document);
                    }
                }
            } catch (FileNotFoundException | BadLocationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            finally {
                fileIn.close();
            }
        }
    }


    public void openfile(JTextPane t)
    {
        String contenu = t.getText();
        s=new save(f);
        if (contenu.isEmpty())
        {
            lireFichier(t);

        }
        else
        {
            int res = JOptionPane.showOptionDialog(f,"vous avez quelque chose n'est pas encore enregitré : ","attention!",JOptionPane.NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new Object[]{"Enregistrer","Continuer sans enregistrer"},null);
            if (res == 0)
            {
                s.enregistrerFichier(contenu);
                lireFichier(t);

            }
            if (res == 1)
            {lireFichier(t);

            }
        }
    }
}
