package view;

import javax.swing.*;
import java.awt.*;
import Persistance.MyFile;

public class View {
    ImageIcon raton = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/raton1.jpeg");
    ImageIcon elefante = new ImageIcon("C:/Users/willi/Programacion/Proyectos/CoinTrack/src/view/elefante.png");

    public String readWaste(String message) {
        ImageIcon icon;
        Image image = raton.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);

        JLabel label = new JLabel();
        label.setIcon(icon);
        String input= JOptionPane.showInputDialog(null, message, "NUEVO GASTO", JOptionPane.PLAIN_MESSAGE, icon, null, null).toString();
        return input;
    }

    public String readIncome(String message) {
        ImageIcon icon;
        Image image = elefante.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);

        JLabel label = new JLabel();
        label.setIcon(icon);
        String input= JOptionPane.showInputDialog(null, message, "NUEVO INGRESO", JOptionPane.PLAIN_MESSAGE, icon, null, null).toString();
        return input;
    }

    public int deleteItem(String message){
        return readIntGraphicInput(message);
    }

    public int readIntGraphicInput(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }


}

