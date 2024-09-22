import asset.VolailleType;
import controller.App;
import entity.VolailleGroupEntity;
import menu.Menu;
import menu.MenuManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        header();
        App app = new App();
        app.run();

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