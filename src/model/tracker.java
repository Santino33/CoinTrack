package model;

import Persistance.MyFile;
import model.User;

import java.util.ArrayList;

public class tracker {

    String pathFile = "C:/Users/willi/Programacion/Proyectos/CoinTrack";

    MyFile file = new MyFile(pathFile);

    public void loadUserData(MyFile movFile){
        movFile.openFile('r');
        String input = "";
        String [] userData;
        int notRead = 0;
        while((input = movFile.read()) != null){
            if (notRead < 3){
                notRead++;
            }
            else {
                userData = input.split(";");
                if (Integer.parseInt(userData[2]) > 0){
                Income income = new Income(Short.parseShort(userData[0]), userData[1],Integer.parseInt(userData[2]));
                addIncome(income);
                }
            }
        }
    }


