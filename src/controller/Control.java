package controller;

import model.Tracker;
import view.View;
import model.Tracker;

import java.util.ArrayList;

public class Control {

    private View view = new View();
    private Tracker tracker = new Tracker();
    short currentMaxId = tracker.getMaxId();

    public void menu() {
        int option = 0;
        try{
            option = view.showPrincipalInterface();
        }
        catch (IllegalArgumentException e) {
            view.showGraphicMessage("Opcion invalida");
            menu();
        }

        do{
            switch (option){
                case 1: addIncome();
                    break;
                case 2: addWaste();
                    break;
                case 3: deleteMovement();
                    break;
                case 4: showIncomesData();
                    break;
                case 5: showWastesData();
                    break;
                case 6: exit();
                    break;
                default:
                    this.view.showGraphicMessage("Opcion invalida");
            }
        } while(option < 1 || option > 6);
    }

    public void addIncome(){
        String name= view.readGraphicIncome("Ingrese el nombre del nuevo ingreso");
        int value = Integer.parseInt(view.readGraphicIncome("¿Cual sera el valor del nuevo ingreso?"));
        tracker.addIncome(currentMaxId, name, value);
    }

    public void addWaste(){
        String name= view.readGraphicIncome("Ingrese el nombre del nuevo gasto");
        int value = Integer.parseInt(view.readGraphicIncome("¿Cual sera el valor del nuevo gasto?"));
        tracker.addWaste(currentMaxId, name, value);
    }

    public void deleteMovement(){
        short id = view.deleteGraphicMovement();
        try {
            tracker.deleteMovement(id);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            menu();
        }

    }

    public void showIncomesData(){
        view.showGraphicMessageBuilder(tracker.getIncomesTable());
    }

    public void showWastesData(){
        view.showGraphicMessageBuilder(tracker.getWastesTable());
    }

    public void exit(){

    }


}


