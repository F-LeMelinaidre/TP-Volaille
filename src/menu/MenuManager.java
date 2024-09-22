package menu;

import controller.App;

public class MenuManager
{
    public static void init(App app) {
        Menu.initAppInstance(app);
    }

    public static final MainMenu MAIN_MENU = new MainMenu();
    public static final VolailleMenu VOLAILLE_MENU = new VolailleMenu();
    public static final SubMenu SUB_ACTION = new SubMenu();
}
