package view;

import javax.swing.*;
import java.awt.*;
import Persistance.MyFile;

public class View {

    ImageIcon login = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/login.png");
    ImageIcon exit = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/logout.png");


    private ImageIcon scaleImage(ImageIcon myImage){
        ImageIcon icon;
        Image image = myImage.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);

        JLabel label = new JLabel();
        label.setIcon(icon);
        return icon;
    }

    public String readGraphicWaste(String message) {
        ImageIcon raton = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/raton1.jpeg");
        String input= JOptionPane.showInputDialog(null, message, "NUEVO GASTO", JOptionPane.PLAIN_MESSAGE, scaleImage(raton), null, null).toString();
        return input;
    }

    public String readGraphicIncome(String message) {
        ImageIcon elefante = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/elefante.png");
        String input= JOptionPane.showInputDialog(null, message, "NUEVO INGRESO", JOptionPane.PLAIN_MESSAGE, scaleImage(elefante), null, null).toString();
        return input;
    }

    public int deleteGraphicMovement(){
        ImageIcon delete = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/logout.png");
        String input= JOptionPane.showInputDialog(null, "Digite el id del elemento(ingreso o gasto) que desea eliminar ", "BORRAR MOVIMIENTO", JOptionPane.PLAIN_MESSAGE, scaleImage(delete), null, null).toString();
        return Integer.parseInt(input);
    }

    public String[] registerGraphicUser(){
        ImageIcon register = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/nuevoUsuario.png");
        String [] fields = new String[1];
        fields[0]= JOptionPane.showInputDialog(null, "Digite un nombre de usuario valido ", "REGISTRAR USUARIO", JOptionPane.PLAIN_MESSAGE, scaleImage(register), null, null).toString();
        fields[1]= JOptionPane.showInputDialog(null, "Cree una contraseña", "REGISTRAR USUARIO", JOptionPane.PLAIN_MESSAGE, scaleImage(register), null, null).toString();
        return fields;
    }

    public String[] loginGraphicUser(){
        ImageIcon logo = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/logoInicial.png");
        String [] fields = new String[1];
        fields[0]= JOptionPane.showInputDialog(null, "Digite su nombre de usuario ", "INCIO DE SESION", JOptionPane.PLAIN_MESSAGE, scaleImage(logo), null, null).toString();
        fields[1]= JOptionPane.showInputDialog(null, "Escriba su contraseña ", "INICIO DE SESION", JOptionPane.PLAIN_MESSAGE, scaleImage(logo), null, null).toString();
        return fields;
    }

    public boolean exitGraphicApp(){
        ImageIcon exit = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/logout.png");
        String answer= JOptionPane.showInputDialog(null, "¿Deseas salir de la aplicacion (y/Y) / (n/N)", "SALIR AL HOME", JOptionPane.PLAIN_MESSAGE, scaleImage(exit), null, null).toString();
        answer = answer.toLowerCase();
        if (answer == "y") return true;
        else return false;
    }

    public int readIntGraphicInput(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }
    public String readGraphicInput(String message) {
        return JOptionPane.showInputDialog(message);
    }



}

