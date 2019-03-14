/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author sunse
 */
public class Validador {

    /**
     * Método para validar campos vazios na tela
     * @param txt objeto do tipo JTextField
     * @param lbl objeto do tipo JLabel
     */
    public static void CamposVazios(JTextField[] txt, JLabel[] lbl){
        
        boolean possuiCamposVazios = false;
        
        for(int i = 0; i < txt.length; i++){
            if(txt[i].getText().isEmpty()){
                txt[i].setBorder(new LineBorder(Color.RED));
                lbl[i].setForeground(Color.RED);
                possuiCamposVazios = true; 
            }
            else if(txt[i].getText().length() > 0){
                txt[i].setBorder(new LineBorder(new Color(109,109,109)));
                lbl[i].setForeground(Color.BLACK);
            }
        }
        
        if(possuiCamposVazios){
            JOptionPane.showMessageDialog(null,"Preencha os campos em vermelho!");
        }
    }
    
    /**
     * Método para validar campos do usuario e a senha
     * @param userTxt objeto do tipo JTextField
     * @param senhaTxt objeto do tipo JTextField
     * @param userLabel objeto do tipo JLabel
     * @param senhaLabel objeto do tipo JLabel
     */
    public static void ValidarUsuario(JTextField userTxt, JTextField senhaTxt, JLabel userLabel, JLabel senhaLabel){
        userTxt.setBorder(new LineBorder(Color.RED));
        userLabel.setForeground(Color.RED);
        senhaTxt.setBorder(new LineBorder(Color.RED));
        senhaLabel.setForeground(Color.RED);
        
    }
    
    /**
     * Método para validar campos que são digitados números inteiros
     * @param txt objeto do tipo JTextField
     * @param lbl objeto do tipo JLabel
     * @return <code>boolean</code> indicando true: sucesso, false: falha
     */
    public static boolean ValidarNumero(JTextField[] txt, JLabel[] lbl) {
        try {
            
            /*for(int i = 0; i < txt.length; i++){
                txt[i].setBorder(new LineBorder(new Color(109,109,109)));
                lbl[i].setForeground(Color.BLACK);
            }*/
            
            for(int i = 0; i < txt.length; i++){
                int valorConvertido = Integer.parseInt(txt[i].getText());
                txt[i].setBorder(new LineBorder(new Color(109,109,109)));
                lbl[i].setForeground(Color.BLACK);
            }
            return true;
            
        } catch (NumberFormatException e) {
            for(int i = 0; i < txt.length; i++){
                txt[i].setBorder(new LineBorder(Color.RED));
                lbl[i].setForeground(Color.RED);
            }
            
            //JOptionPane.showMessageDialog(null,"Digite somente inteiros!");
            return false;
            
        } catch (IllegalArgumentException e) {
            for(int i = 0; i < txt.length; i++){
                txt[i].setBorder(new LineBorder(Color.RED));
                lbl[i].setForeground(Color.RED);
            }
            return false;
        }
    }
}
