package model;

import Persistance.MyFile;

import java.util.ArrayList;
import java.util.HashMap;

public class tracker {

    HashMap<String, User> users = new HashMap<String, User>();
    String userName;
    String usersFilePath = "C:/Users/willi/Programacion/Proyectos/CoinTrack/data/users.csv";
    MyFile usersFile = new MyFile(usersFilePath);
    String incomesFilepath = "C:/Users/willi/Programacion/Proyectos/CoinTrack/data/incomes_" + userName +".csv";
    MyFile incomesFile = new MyFile(incomesFilepath);
    String wastesFilepath =  "C:/Users/willi/Programacion/Proyectos/CoinTrack/data/wastes_" + userName +".csv";
    MyFile wastesFile = new MyFile(wastesFilepath);
    public tracker(){

    }

    public void registerUser(String username, String password) throws IllegalArgumentException{
        if (!users.containsKey(username)){
            ArrayList<Income> incomeList = new ArrayList<Income>();
            ArrayList<Waste> wastesList = new ArrayList<Waste>();
            users.put(username, new User(username, password, incomeList, wastesList ));

            //Crear archivos CSV para guardar los movimientos
            this.incomesFilepath = "C:/Users/willi/Programacion/Proyectos/CoinTrack/data/incomes_" + username +".csv";
            this.wastesFilepath =  "C:/Users/willi/Programacion/Proyectos/CoinTrack/data/wastes_" + username +".csv";
            MyFile incomesFile = new MyFile(incomesFilepath);
            MyFile wastesFile = new MyFile(wastesFilepath);
            incomesFile.openFile('w');
            wastesFile.openFile('w');
        }
        else throw new IllegalArgumentException("El nombre de usuario no está disponible");
    }

    public boolean login(String username, String password) throws IllegalArgumentException {
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        User user = users.get(username);
        if (user.getPassword().equals(password)) {
            this.userName = username;
            return true;  // La contraseña es correcta
        } else {
            throw new IllegalArgumentException("La contraseña no es correcta");
        }
    }

    public ArrayList loadUserIncomesData(){
        incomesFile.openFile('r');
        String input = "";
        String [] incomesData;
        ArrayList<Income> incomesList = new ArrayList<Income>();

        while ((input = incomesFile.read()) != null){
            incomesData = input.split(";");
            Income income = new Income(Short.parseShort(incomesData[0]), incomesData[1], Integer.parseInt(incomesData[2]));
            incomesList.add(income);
        }
        incomesFile.closeFile();
        return incomesList;
    }

    public ArrayList loadUserWastesData(){
        wastesFile.openFile('r');
        String input = "";
        String [] wastesData;
        ArrayList<Waste> wastesList = new ArrayList<Waste>();

        while ((input = incomesFile.read()) != null){
            wastesData = input.split(";");
            Waste waste = new Waste(Short.parseShort(wastesData[0]), wastesData[1], Integer.parseInt(wastesData[2]));
            wastesList.add(waste);
        }
        wastesFile.closeFile();
        return wastesList;
    }

    public void loadUsers(){
        usersFile.openFile('r');
        String input = "";
        String [] fields;
        while ((input = usersFile.read()) !=null){
            fields = input.split(";");
            String username = fields[0];
            String password = fields[1];
            User user = new User(username, password, loadUserIncomesData(), loadUserWastesData());
            users.put(username, user);
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


