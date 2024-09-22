package controller;

import entity.VolailleGroupEntity;
import menu.Menu;
import menu.MenuManager;
import util.fileManager.BinarieFile;

import java.io.IOException;
import java.util.Map;

public class App
{

    private Menu currentMenu;

    public App() {
        MenuManager.init(this);
        this.currentMenu = MenuManager.MAIN_MENU;
        this.loadBinaryData();
    }

    public void run() {
        while (true) {
            currentMenu = currentMenu.display();
        }
    }

    private void loadBinaryData() {
        System.out.println("Chargement des données...");

        BinarieFile<VolailleGroupEntity> bf = new BinarieFile<>("volaille_list");

        try {
            Map<String, VolailleGroupEntity> data = bf.readFile();
            if (data != null) {
                System.out.println("Données chargées");
                VolailleGroupEntity.setVolailleGroupMap(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        System.out.println("Enregistrement des données...");

        //TODO Modifier les execptions avec log4J2
        BinarieFile<VolailleGroupEntity> bf = new BinarieFile<>("volaille_list");

        try {
            bf.writeFile(VolailleGroupEntity.getVolailleGroupMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("A bientôt !");
        System.exit(0);
    }

}