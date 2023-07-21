package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Persistance.MyFile;
import model.Movement;
import model.Tracker;

public class View {

    private Tracker tracker;
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

    public short deleteGraphicMovement(){
        ImageIcon delete = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/logout.png");
        String input= JOptionPane.showInputDialog(null, "Digite el id del elemento(ingreso o gasto) que desea eliminar ", "BORRAR MOVIMIENTO", JOptionPane.PLAIN_MESSAGE, scaleImage(delete), null, null).toString();
        return Short.parseShort(input);
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

    public int showPrincipalInterface() throws IllegalArgumentException{
        String title = " .d8888b.   .d88888b.  8888888 888b    888     88888888888 8888888b.         d8888  .d8888b.  888    d8P  \n" +
                "d88P  Y88b d88P\" \"Y88b   888   8888b   888         888     888   Y88b       d88888 d88P  Y88b 888   d8P   \n" +
                "888    888 888     888   888   88888b  888         888     888    888      d88P888 888    888 888  d8P    \n" +
                "888        888     888   888   888Y88b 888         888     888   d88P     d88P 888 888        888d88K     \n" +
                "888        888     888   888   888 Y88b888         888     8888888P\"     d88P  888 888        8888888b    \n" +
                "888    888 888     888   888   888  Y88888         888     888 T88b     d88P   888 888    888 888  Y88b   \n" +
                "Y88b  d88P Y88b. .d88P   888   888   Y8888         888     888  T88b   d8888888888 Y88b  d88P 888   Y88b  \n" +
                " \"Y8888P\"   \"Y88888P\"  8888888 888    Y888         888     888   T88b d88P     888  \"Y8888P\"  888    Y88b \n" +
                "                                                                                                          \n" +
                "                                                                                                          \n" +
                "                                                                                                          ";
        int currentBalance = (tracker.getCurrentBalance());
        String menu = "1. Agregar ingreso \n 2. Agregar gasto \n 3.Eliminar elemento \n 4.Mostrar todos los ingresos \n 5. Mostrar todos los gastos \n 6. Salir";
        int output = readIntGraphicInput(title + "\n" + "BALANCE ACTUAL\n" +currentBalance + "\n" + "\n" + "\n" + menu);

        if (!(output >0 && output <= 6)) throw new IllegalArgumentException();
        return output;
    }


    public int readIntGraphicInput(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }
    public String readGraphicInput(String message) {
        return JOptionPane.showInputDialog(message);
    }
    public void showGraphicMessage(String message) {
        JOptionPane.showMessageDialog((Component)null, message);
    }

    public void showGraphicMessageBuilder(StringBuilder message){JOptionPane.showMessageDialog((Component)null, message);}


}

