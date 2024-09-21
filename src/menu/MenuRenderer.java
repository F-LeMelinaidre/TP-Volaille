package menu;

import asset.DoubleTableBorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRenderer
{

    private static enum Border
    {CORNER, LINE, TOP, MIDDLE, BOTTOM, LEFT, RIGHT, NONE}

    private static enum Direction
    {TOP, MIDDLE, BOTTOM}

    private static enum Justify
    {LEFT, CENTER, RIGHT}

    private static Scanner sc = null;

    private String title = null;
    private ArrayList<String> options;
    private int width = 0;
    private int padding = 1;

    public MenuRenderer() {}

    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Créé la liste de menu
     * Ajoute au texte de inputOptions les index de selection
     *
     * @param inputOptions Liste des options du menu
     */
    public void setOptions(List<String> inputOptions) {
        this.options = new ArrayList<>();

        int nbChoice = inputOptions.size();
        for (int i = 0; i < nbChoice; i++) {
            String option = "[" + i + "] " + inputOptions.get(i);

            this.options.add(option);
            this.setMaxWidth(option.length());
        }

    }

    /**
     * Initialise la largeur maximum du menu en y ajoutant un padding
     *
     * @param currentWidth Largeur de la chaine de caratère
     */
    private void setMaxWidth(int currentWidth) {
        currentWidth += this.padding * 2;
        this.width = Math.max(currentWidth, this.width);
    }

    public void render() {
        System.out.println(this.createHeader(this.title));

        for (String option : this.options) {
            System.out.println(this.createLine(option, Justify.LEFT));
        }

        System.out.println(this.createSeparator(Direction.BOTTOM));
        System.out.print("Choisissez une option : ");
        width = 0;
    }

    /**
     * Créé l'entête du menu
     *
     * @return StringBuilder
     */
    private StringBuilder createHeader(String title) {
        StringBuilder header = new StringBuilder();
        this.setMaxWidth(title.length());

        header.append(this.createSeparator(Direction.TOP)).append("\n");
        header.append(this.createLine(title, Justify.CENTER)).append("\n");
        header.append(this.createSeparator(Direction.MIDDLE));

        return header;
    }

    /**
     * Créé les lignes du menu
     *
     * @param text
     * @return StringBuilder
     */
    private StringBuilder createLine(String text, Justify justify) {
        StringBuilder line = new StringBuilder();

        line.append(DoubleTableBorder.V.getSymbol());
        line.append(this.justifyText(text, justify));
        line.append(DoubleTableBorder.V.getSymbol());

        return line;
    }

    /**
     * @param text
     * @param justify
     * @return
     */
    private String justifyText(String text, Justify justify) {

        int paddingLeft = this.padding;
        int paddingRight = width - text.length() - 1;


        if (justify == Justify.CENTER) {

            paddingLeft = (width - text.length()) / 2;
            paddingRight = (text.length() % 2 == 0) ? paddingLeft : paddingLeft + 1;

        } else if (justify == Justify.RIGHT) {

            paddingRight = padding;
            paddingLeft = width - text.length() - 1;

        }

        return String.format("%" + paddingLeft + "s%s%" + paddingRight + "s", "", text, "");
    }

    /**
     * Créé une ligne séparatrice
     *
     * @param direction Direction du trait TOP MIDDLE BOTTOM pour l'orientation des extrémitées
     *                  exemple TOP => ┌ ┐
     * @return StringBuilder
     */
    private StringBuilder createSeparator(Direction direction) {
        StringBuilder separator = new StringBuilder();

        separator.append(this.getBorderSymbol(direction, true));
        separator.append(DoubleTableBorder.H.getSymbol().repeat(this.width));
        separator.append(this.getBorderSymbol(direction, false));

        return separator;
    }

    /**
     * Récupère le symbole suivant l'orientation et son extrémité
     *
     * @param direction    TOP BOTTOM MIDDLE
     * @param isCornerLeft true false
     * @return String
     */
    private String getBorderSymbol(Direction direction, boolean isCornerLeft) {
        String symbol = "";

        switch (direction) {
            case TOP:
                symbol = isCornerLeft ? DoubleTableBorder.TOP_LEFT.getSymbol() : DoubleTableBorder.TOP_RIGHT.getSymbol();
                break;
            case MIDDLE:
                symbol = isCornerLeft ? DoubleTableBorder.MIDDLE_LEFT.getSymbol() : DoubleTableBorder.MIDDLE_RIGHT.getSymbol();
                break;
            case BOTTOM:
                symbol = isCornerLeft ? DoubleTableBorder.BOTTOM_LEFT.getSymbol() : DoubleTableBorder.BOTTOM_RIGHT.getSymbol();
                break;
            default:
                // TODO logJ
                break;
        }

        return symbol;
    }
}