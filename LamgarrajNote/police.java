package LamgarrajNote;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
/*************************************************************
 * *  @author= lamgarraj mohamed                            **
 * *  @date= 24/01/2021                                     **
 * *  @Master= web intelligence and data science            **
 * *  @project= editeur de texte en java                    **
 * ***********************************************************
 * *             @class: police                             **
 * *  ici vous trouver les methodes responsable de          **
 * *  modification de style et coleur du text                **
 * *                                                        **
 * **********************************************************/
public class police {


    //**************************** changer police de part selectioné ******************************
       void changeStyle(JTextPane t,JComboBox f) {
        StyledDocument doc = (StyledDocument) t.getDocument();
        int selectionEnd = t.getSelectionEnd();
        int selectionStart = t.getSelectionStart();
        if (selectionStart == selectionEnd) {
            return;
        }
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        Font font = new Font((String) f.getSelectedItem(), Font.BOLD, 18);
        StyleConstants.setFontFamily(asNew,font.getFamily());
        doc.setCharacterAttributes(selectionStart, t.getSelectedText()
                .length(), asNew, true);

    }

    //**************************** changer color de part selectionée ******************************
        void textcolor(JTextPane t,JButton b) {
        StyledDocument doc = (StyledDocument) t.getDocument();
        int selectionEnd = t.getSelectionEnd();
        int selectionStart = t.getSelectionStart();
        JColorChooser colorChooser = new JColorChooser();
        if (selectionStart == selectionEnd) {
            return;
        }
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        Color colr = colorChooser.showDialog(null, "Choose a color", Color.black);
        StyleConstants.setForeground(asNew, colr);
          b.setBackground(colr);
        doc.setCharacterAttributes(selectionStart, t.getSelectedText()
                .length(), asNew, false);

    }
    //**************************** italique selected******************************
    void italicStyle(JTextPane t) {
        StyledDocument doc = (StyledDocument) t.getDocument();
        int selectionEnd = t.getSelectionEnd();
        int selectionStart = t.getSelectionStart();
        if (selectionStart == selectionEnd) {
            return;
        }
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setItalic(asNew, true);
        doc.setCharacterAttributes(selectionStart, t.getSelectedText()
                .length(), asNew, false);

    }
    //**************************** gras selected******************************
   void BoldStyle(JTextPane t) {
        StyledDocument doc = (StyledDocument) t.getDocument();
        int selectionEnd = t.getSelectionEnd();
        int selectionStart = t.getSelectionStart();
        if (selectionStart == selectionEnd) {
            return;
        }
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setBold(asNew, true);
        doc.setCharacterAttributes(selectionStart, t.getSelectedText()
                .length(), asNew, false);
    }

    //**************************** souligné   auuu si selected ******************************
    void soulignéStyle(JTextPane t) {

        StyledDocument doc = (StyledDocument) t.getDocument();
        int selectionEnd = t.getSelectionEnd();
        int selectionStart = t.getSelectionStart();
        if (selectionStart == selectionEnd) {
            return;
        }
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();

        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setUnderline(asNew, true);   //(a, b);(asNew, !StyleConstants.isBold(as));
        doc.setCharacterAttributes(selectionStart, t.getSelectedText()
                .length(), asNew, true);

    }
}
