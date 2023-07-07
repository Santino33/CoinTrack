package model;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
    String username;
    String password;
    ArrayList<Income> incomesList = new ArrayList<Income>();
    ArrayList<Waste> wastesList = new ArrayList<Waste>();

    public User(String username, String password, ArrayList<Income> incomesList, ArrayList<Waste> wastesList) {
        this.username = username;
        this.password = password;
        this.incomesList = incomesList;
        this.wastesList = wastesList;
    }


    public void addIncome(Income income) { incomesList.add(income);}

    public void addWaste(Waste waste) {wastesList.add(waste);}

    public void deleteMovement(int movementId) throws IllegalArgumentException {
        boolean deleted = false;

        Iterator<Income> iterator = incomesList.iterator();
        while (iterator.hasNext()) {
            Movement movement = iterator.next();
            if (movement.getId() == movementId) {
                iterator.remove();
                deleted = true;
                break;  // Salir del bucle una vez que se haya eliminado el elemento
            }
        }

        if (!deleted) {
            Iterator<Waste> iterator1 = wastesList.iterator();
            while (iterator1.hasNext()) {Movement movement = iterator1.next();
                if (movement.getId() == movementId) {
                    iterator1.remove();
                    deleted = true;
                    break;  // Salir del bucle una vez que se haya eliminado el elemento
                }
            }
        }

        if (!deleted) {
            throw new IllegalArgumentException("El id del movimiento indicado no se encontró: " + movementId);
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Income> getIncomesList() {
        return incomesList;
    }

    public void setIncomesList(ArrayList<Income> incomesList) {
        this.incomesList = incomesList;
    }

    public ArrayList<Waste> getWastesList() {
        return wastesList;
    }

    public void setWastesList(ArrayList<Waste> wastesList) {
        this.wastesList = wastesList;
    }
}


