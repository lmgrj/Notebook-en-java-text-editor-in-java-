package LamgarrajNote;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*************************************************************
 * *  @author= lamgarraj mohamed                            **
 * *  @date= 25/01/2021                                     **
 * *  @Master= web intelligence and data science            **
 * *  @project= editeur de texte en java                    **
 * ***********************************************************
 * *             @class: qlqtraitement                      **
 * *  ici vou trouver quelque methodes qui permet de fair   **
 * *  des traitement sur le text te que chercher un chaine  **
 * *  de caracteres des le text ou la remplacer...          **
 * *     !! changer le path d'icon !!                       **
 * *                                                        **
 * **********************************************************/
public class qlqtraitement {
                                                  // changer le phath de l'image
    private ImageIcon logo = new ImageIcon("C:\\Users\\moham\\IdeaProjects\\cour\\src\\text_editor\\files\\lamgarraj.jpg");

    //****************** rechercher un String ***************************************
    void recherch(JFrame f,JTextPane t){

        JTextField motARechercher = new JTextField();
        if (t.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(f,"La zone de texte est vide!"," Recherche",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            int choix = JOptionPane.showOptionDialog(f, new Object[]{"Tapez le motif à rechercher ",motARechercher},"Rechercher", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, logo, new String[]{"Rechercher","Annuler"},null);
            if (choix == 0)
            {
                if (motARechercher.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(f,"Alert!! taper un motif à rechercher dans la zone de texte...!!!"," Recherche",JOptionPane.INFORMATION_MESSAGE);
                    do{
                        JOptionPane.showOptionDialog(f, new Object[]{"Tapez le motif à rechercher ",motARechercher},"Rechercher", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, logo, new String[]{"Rechercher","Annuler"},null);
                    }while(motARechercher.getText().isEmpty());
                }
                if(!motARechercher.getText().isEmpty())
                {
                    Pattern motif = Pattern.compile(motARechercher.getText());
                    Matcher macther = motif.matcher(t.getText());
                    while (macther.find())
                    {
                        Highlighter lumière = t.getHighlighter();
                        Highlighter.HighlightPainter colorateur = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
                        try {
                            lumière.addHighlight(macther.start(), macther.end(), colorateur);
                        }catch(BadLocationException ex) {
                            JOptionPane.showMessageDialog(f, "Erreur Interne","Erreur",JOptionPane.ERROR_MESSAGE);}
                    }
                }
            }
        }
    }

    //****************** remplacer un String ***************************************

      void remplacer(JFrame f,JTextPane t) {
          JTextField replace = new JTextField();
          JTextField remplacant = new JTextField();
          if (t.getText().isEmpty()) {
              JOptionPane.showMessageDialog(f, "La zone de texte est vide", " Recherche", JOptionPane.INFORMATION_MESSAGE);
          } else {
              int choix = JOptionPane.showOptionDialog(f, new Object[]{"Tapez le motif à remplacer ", replace, "Remplacer par", remplacant}, "Remplacer", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, logo, new String[]{"Remplacer", "Annuler"}, null);
              if (choix == 0) {
                  while (replace.getText().isEmpty() || remplacant.getText().isEmpty()) {
                      JOptionPane.showMessageDialog(f, "Alert!! vous devez remplir tous les champs...!!!", " Recherche", JOptionPane.INFORMATION_MESSAGE);
                      JOptionPane.showOptionDialog(f, new Object[]{"Tapez le motif à remplacer ", replace, "Remplacer par", remplacant}, "Remplacer", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, logo, new String[]{"Remplacer", "Annuler"}, null);
                  }
                  if (!replace.getText().isEmpty() && !remplacant.getText().isEmpty()) {
                      String mot = null;
                      Pattern motif = Pattern.compile(replace.getText());
                      Matcher macther = motif.matcher(t.getText());
                      while (macther.find()) {
                          mot = macther.replaceAll(remplacant.getText());
                      }
                      t.setText(mot);
                  }
              }
          }
      }

    //****************** compter le nembre d'pparition d'un String ***************************************
      void  compter(JFrame f, JTextPane t){

          int compteur = 0;
          JTextField motACompter = new JTextField();
          if (t.getText().isEmpty())
          {
              JOptionPane.showMessageDialog(f,"La zone de texte est vide"," Recherche",JOptionPane.INFORMATION_MESSAGE);
          }
          else
          {
              int choix = JOptionPane.showOptionDialog(f, new Object[]{"Tapez le motif à compter ",motACompter},"Rechercher", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, logo, new String[]{"Compter","Annuler"},null);
              if (choix == JOptionPane.OK_OPTION)
              {
                  while (motACompter.getText().isEmpty())
                  {
                      JOptionPane.showMessageDialog(f,"alert!!  taper un motif à rechercher dans la zone de texte...!!!"," Recherche",JOptionPane.INFORMATION_MESSAGE);
                      JOptionPane.showOptionDialog(f, new Object[]{"Tapez le motif à rechercher ",motACompter},"Rechercher", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, logo, new String[]{"Rechercher","Annuler"},null);

                  }
                  if (!motACompter.getText().isEmpty())
                  {
                      Pattern motif = Pattern.compile(motACompter.getText());
                      Matcher macther = motif.matcher(t.getText());
                      while (macther.find())
                      {
                          compteur++;
                      }
                      if(compteur == 0)
                      {
                          JOptionPane.showMessageDialog(f, "le motif : "+motACompter.getText()+" n'apparait pas!!!","Résultat",JOptionPane.INFORMATION_MESSAGE);
                      }
                      else
                      {

                          JOptionPane.showMessageDialog(f, "Le motif : "+motACompter.getText()+" ; Apparait "+compteur+" fois dans le texte","Résultat de la recherche", JOptionPane.INFORMATION_MESSAGE);
                      }
                  }
              }
          }
      }

}
