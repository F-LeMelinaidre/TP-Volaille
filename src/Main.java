import asset.VolailleType;
import controller.App;
import entity.VolailleGroupEntity;
import menu.IMenuHandler;
import menu.MainMenuHandler;
import menu.MenuRenderer;
import menu.NavigationManager;
import view.table.VolailleGroupTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("        +&-");
        System.out.println("      _.-^-._    .--.");
        System.out.println("   .-'   _   '-. |__|");
        System.out.println("  /     |_|     \\|  |");
        System.out.println(" /               \\  |");
        System.out.println("/|     _____     |\\ |");
        System.out.println(" |    |==|==|    |  |");
        System.out.println(" |    |--|--|    |  |---|---|---|---|---|");
        System.out.println(" |    |--|--|    |  |---|---|---|---|---|");
        System.out.println(" |    |==|==|    |  |---|---|---|---|---|");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
/*
        MenuRenderer menu = new MenuRenderer();

        IMenuHandler currentHandler = new MainMenuHandler(menu);

        while (true) {
            currentHandler.handleMenu();
            currentHandler = NavigationManager.getCurrentHandler();
        }*/
        App app = App.getInstance();
        app.run();
        /*VolailleGroupEntity group1 = new VolailleGroupEntity("12/05/2023", VolailleType.POULET, 50, 8, 0.5);
        VolailleGroupEntity group2 = new VolailleGroupEntity("14/05/2023", VolailleType.CANARD, 35, 5, 0.5);
        VolailleGroupEntity group3 = new VolailleGroupEntity("14/05/2023", VolailleType.POULET, 20, 6, 0.6);
        VolailleGroupEntity group4 = new VolailleGroupEntity("14/05/2023", VolailleType.POULET, 35, 5, 0.3);

        Map<String, VolailleGroupEntity> volailleList = VolailleGroupEntity.getVolailleGroupMap();

        List<VolailleGroupEntity> listData           = new ArrayList<>(volailleList.values());
        VolailleGroupTable        volailleGroupTable = new VolailleGroupTable(listData);
        volailleGroupTable.render();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ajouter un lot");
        System.out.println("Saisissez la date d'entrée:");
        String date = sc.nextLine();

        System.out.println("Saisissez la categorie :");
        for (int i = 1; i <= VolailleType.values().length; i++) {
            System.out.println(i + " : " + VolailleType.getById(i));
        }
        boolean      next = false;
        VolailleType type = null;
        while (! next) {
            System.out.println("Saisissez votre choix :");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 0 && choice <= VolailleType.values().length) {
                next = true;
                type = VolailleType.getById(choice);
            }
        }
        sc.nextLine();
        System.out.println("Saisissez ne nombre d'individus :");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Saisissez l'age d'entrée :");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Saisissez le poid moyen :");
        double poid = sc.nextDouble();
        sc.nextLine();
        System.out.println(date + " " + type + " " + quantity + " " + age + " " + Double.toString(poid));*/
    }
}