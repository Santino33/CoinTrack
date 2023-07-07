package model;

import java.util.ArrayList;

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
        for (int i = 0; i < incomesList.size(); i++) {
            if (incomesList.get(i).getId() == movementId) {
                incomesList.remove(incomesList.get(i));
                deleted = true;
            }
        }

        if (deleted == false){
            for (int i = 0; i < wastesList.size(); i++) {
                if (wastesList.get(i).getId() == movementId) {
                    wastesList.remove(wastesList.get(i));
                    deleted = true;
                }
            }
        }

        if (deleted == false) throw new IllegalArgumentException("El id del movimiento indicado no se econtró "+movementId);
    }

}


