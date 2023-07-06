package model;

import Persistance.MyFile;

import java.util.ArrayList;

public class tracker {
    ArrayList<Income> incomesList = new ArrayList<Income>();
    ArrayList<Waste> wastesList = new ArrayList<Waste>();

    public tracker(ArrayList<Income> incomesList, ArrayList<Waste> wastesList) {
        this.incomesList = incomesList;
        this.wastesList = wastesList;
    }

    public void addIncome(Income income) { incomesList.add(income);}
    public void addWaste(Waste waste) {wastesList.add(waste);}

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
}
