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
    ArrayList<Income> incomesList = new ArrayList<Income>();
    String wastesFilepath =  "C:/Users/willi/Programacion/Proyectos/CoinTrack/data/wastes_" + userName +".csv";
    MyFile wastesFile = new MyFile(wastesFilepath);
    ArrayList<Waste> wastesList = new ArrayList<Waste>();
    public tracker(){

    }

    public void registerUser(String username, String password) throws IllegalArgumentException{
        if (!users.containsKey(username)){
            users.put(username, new User(username, password, incomesList, wastesList ));

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

    //Metodos para cargue de usuarios y listas de los usuarios
    public void loadUserIncomesData(){
        incomesFile.openFile('r');
        String input = "";
        String [] incomesData;

        while ((input = incomesFile.read()) != null){
            incomesData = input.split(";");
            Income income = new Income(Short.parseShort(incomesData[0]), incomesData[1], Integer.parseInt(incomesData[2]));
            this.incomesList.add(income);
        }
        incomesFile.closeFile();
    }

    public void loadUserWastesData(){
        wastesFile.openFile('r');
        String input = "";
        String [] wastesData;

        while ((input = incomesFile.read()) != null){
            wastesData = input.split(";");
            Waste waste = new Waste(Short.parseShort(wastesData[0]), wastesData[1], Integer.parseInt(wastesData[2]));
            this.wastesList.add(waste);
        }
        wastesFile.closeFile();
    }

    public void loadUsers(){
        usersFile.openFile('r');
        String input = "";
        String [] fields;
        while ((input = usersFile.read()) !=null){
            fields = input.split(";");
            String username = fields[0];
            String password = fields[1];
            User user = new User(username, password, incomesList, wastesList);
            this.users.put(username, user);
        }
    }

    //Metodos para escritura de archivos

    public void recordIncomesData(){
        StringBuilder outputBuilder = new StringBuilder();
        //Recorrer la lista de ingresos para llenar el StringBuilder
        for (Income income : this.incomesList) {
            outputBuilder.append(income.getId()).append(";");
            outputBuilder.append(income.getName()).append(";");
            outputBuilder.append(income.getValue()).append(";");
            outputBuilder.append(System.lineSeparator());
        }
        //Crear un string y darle el StringBuilder como valor
        String output = outputBuilder.toString();

        //Guardar el string en el archivo
        incomesFile.openFile('w');
        incomesFile.record(output);
        incomesFile.closeFile();
    }

    public void recordWastesData(){

        StringBuilder outputBuilder = new StringBuilder();
        //Recorrer la lista de ingresos para llenar el StringBuilder
        for (Waste waste : this.wastesList) {
            outputBuilder.append(waste.getId()).append(";");
            outputBuilder.append(waste.getName()).append(";");
            outputBuilder.append(waste.getValue()).append(";");
            outputBuilder.append(System.lineSeparator());
        }
        //Crear un string y darle el StringBuilder como valor
        String output = outputBuilder.toString();

        //Guardar el string en el archivo
        incomesFile.openFile('w');
        incomesFile.record(output);
        incomesFile.closeFile();
    }

    public void recordUsers(){
        //Crear stringBuilder
        StringBuilder usersBuilder = new StringBuilder();
        //Recorrer el Hashmap para obtener el username y contraseña
        for (int i =0; i<users.size(); i++){
            usersBuilder.append(users.get(i).getUsername()).append(";");
            usersBuilder.append(users.get(i).getPassword()).append(";");
            usersBuilder.append(System.lineSeparator());
        }
        //Crear un string y darle el StringBuilder como valor
        String usersUpdated = usersBuilder.toString();
        //Guardar
        usersFile.openFile('w');
        usersFile.record(usersUpdated);
        usersFile.closeFile();
    }

    public int getCurrentBalance(){
        int currentBalance = 0;
        //Recorrer todos los valores de cada ingreso del usuario
        for (int i = 0; i < users.get(userName).getIncomesList().size(); i++){
            currentBalance += users.get(userName).getIncomesList().get(i).getValue();
        }
        for (int i = 0; i < users.get(userName).getWastesList().size(); i++){
            currentBalance -= users.get(userName).getWastesList().get(i).getValue();
        }
        return currentBalance;
    }

    }


