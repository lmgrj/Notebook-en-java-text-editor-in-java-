package LamgarrajNote;

import javax.swing.*;
import java.io.File;
/*************************************************************
 * *  @author= lamgarraj mohamed                            **
 * *  @date= 25/01/2021                                     **
 * *  @Master= web intelligence and data science            **
 * *  @project= editeur de texte en java                    **
 * ***********************************************************
 * *            @class: photo                               **
 * *  ici vous trouver les methodes responsable de l'ajoute **
 * *     d'une image dans le text                           **
 * **********************************************************/
public class photo {
    JTextPane textPane;
    JFrame frame;
    public photo(JFrame frame, JTextPane textPane){
        this.frame=frame;
        this.textPane=textPane;
    }
    private boolean isImage(File fil)
    {
        String name=fil.getName();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".gif");
    }


    void addimg(JTextPane t){

        ImageIcon icon;
        JFileChooser jf=new JFileChooser();
        int option=jf.showOpenDialog(frame);
        if(option==JFileChooser.APPROVE_OPTION)
        {
            File file=jf.getSelectedFile();
            if(isImage(file))
            {
                icon=new ImageIcon(file.getAbsolutePath());
                t.insertIcon(icon);
            }
            else
                JOptionPane.showMessageDialog(frame,"The file is not an image.","attention!",JOptionPane.ERROR_MESSAGE);
        }

   }



}