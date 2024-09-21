package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {

    protected MenuRenderer menuRenderer = new MenuRenderer();
    protected Scanner sc = new Scanner(System.in);
    protected List<String> options = new ArrayList<>();
    protected int choice;

    public abstract Menu display();
    public abstract void setChoice(int choice);


}
