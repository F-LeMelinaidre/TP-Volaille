import asset.VolailleType;
import controller.App;
import entity.VolailleGroupEntity;
import menu.Menu;
import menu.MenuManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //TODO
        //  Modifier les tarifs
        //  Modifier un lot de volaille
        //  Sortir un lot de volaille
        //  Exporter la liste des lots Excel
        //  Exporter un Lot PDF
        //  Créer/Exporter un historique des tarifs
        //  Créer/Exporter les lots sorties
        //  Supression de lot (garder une trace)
        //  Simuler la prise de poids par semaine et afficher les lots à sortir une fois le poid d'abatage atteint

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