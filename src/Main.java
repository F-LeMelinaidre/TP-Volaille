import asset.VolailleType;
import entity.VolailleGroupEntity;
import menu.Menu;
import menu.MenuManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        VolailleGroupEntity group1 = new VolailleGroupEntity("12/05/2023", VolailleType.POULET, 50, 8, 0.5);
        VolailleGroupEntity group2 = new VolailleGroupEntity("14/05/2023", VolailleType.CANARD, 35, 5, 0.5);
        VolailleGroupEntity group3 = new VolailleGroupEntity("14/05/2023", VolailleType.POULET, 20, 6, 0.6);
        VolailleGroupEntity group4 = new VolailleGroupEntity("14/05/2023", VolailleType.POULET, 35, 5, 0.3);

        header();
        Menu currentMenu = MenuManager.MAIN_MENU;

        while (true) {
            currentMenu = currentMenu.display();
        }
    }
    public static void header() {
        System.out.println();
        System.out.println("        +&-");
        System.out.println("      _.-^-._    ┌──┐");
        System.out.println("   .-'═══════'-. ╞══╡");
        System.out.println("  /     ┌─┐     \\│  │");
        System.out.println(" /══════└─┘══════\\  │");
        System.out.println("/╞═══════════════╡\\ │");
        System.out.println(" │    ╓──┬──╖    │  │");
        System.out.println(" │    ╠══╪══╣    │  │");
        System.out.println(" ╞════╣  │  ╠════╡  ├───╫───╫───╫───╫───╢");
        System.out.println(" │    ╠══╪══╣    │  ├───╫───╫───╫───╫───╢");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
}