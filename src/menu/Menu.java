package menu;

import controller.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {

    protected static App app;
    protected MenuRenderer menuRenderer = new MenuRenderer();
    protected Scanner sc = new Scanner(System.in);
    protected List<String> options = new ArrayList<>();
    protected int choice;

    public static void initAppInstance(App appInstance) {
        app = appInstance;
    }
    public abstract Menu display();
    public abstract void setChoice(int choice);


}
