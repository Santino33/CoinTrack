package model;

import Persistance.MyFile;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class tracker {

    HashMap<String, User> users = new HashMap<String, User>();

    public void registerUser(String username, String password) throws IllegalArgumentException{
        if (!users.containsKey(username)){
            ArrayList<Income> incomeList = new ArrayList<Income>();
            ArrayList<Waste> wastesList = new ArrayList<Waste>();
            users.put(username, new User(username, password, incomeList, wastesList ));
        }
        else throw new IllegalArgumentException("El nombre de usuario no está disponible");
    }

    public boolean login(String username, String password) throws IllegalArgumentException {
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        User user = users.get(username);
        if (user.getPassword().equals(password)) {
            return true;  // La contraseña es correcta
        } else {
            throw new IllegalArgumentException("La contraseña no es correcta");
        }
    }



    /*
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

     */
    }


