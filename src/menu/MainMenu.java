package menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu implements IMenuHandler {

    private Menu menu;
    private ArrayList options = new ArrayList<String>(Arrays.asList("Tous afficher",
                                                                    "Afficher les Canards",
                                                                    "Afficher les Poulets"));

    public MainMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void handleMenu() {

    }
}
