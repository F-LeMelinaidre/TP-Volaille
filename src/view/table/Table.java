package view.table;

import asset.SimpleTableBorder;

import java.util.List;

/**
 * Class abstraite générique représentant une table de données à afficher.
 *
 * @param <T> Le type des éléments contenus dans la table.
 */
public abstract class Table<T> {

    private enum Direction {TOP, MIDDLE, BOTTOM}

    protected List<T> dataList;
    protected String[] columnNames;
    protected Object[] rows;
    private int[] columnWidths;

    /**
     * @param dataList Tableau d'objet (instance de class)
     */
    public Table(List<T> dataList) {
        this.dataList = dataList;
        this.columnNames = this.getColumnNames();
        this.rows = this.getDataListValues();
        this.columnWidths = this.calculateColumnWidths();
    }

    public void render() {
        if (dataList == null || dataList.isEmpty()) {
            System.out.println("Aucun élément à afficher.");
        } else {
            System.out.println(this.createSeparator(Direction.TOP));
            System.out.println(this.createRow(columnNames));
            System.out.println(this.createSeparator(Direction.MIDDLE));

            for (Object row : rows ) {
                System.out.println(this.createRow((String[]) row));
            }

            System.out.println(this.createSeparator(Direction.BOTTOM));
        }
    }

    /**
     *
     * @param values Tableau de valeurs
     * @return retourne les valeurs séparées par un │
     */
    private StringBuilder createRow (String[] values) {
        StringBuilder row = new StringBuilder();
        row.append(SimpleTableBorder.V.getSymbol());

        for (int i = 0; i < values.length; i++) {
            int width = this.columnWidths[i] + 2;
            row.append(String.format("%-" + width + "s", " " + values[i] + " "));
            row.append(SimpleTableBorder.V.getSymbol());
        }
        return row;
    }


    /**
     *
     * @param direction Represente la position de la bordure Haute Central ou Basse
     * @return retourne une bordure de la largeur total du tableau
     */
    private StringBuilder createSeparator(Direction direction) {
        StringBuilder separator = new StringBuilder();
        String line = SimpleTableBorder.H.getSymbol();
        String left, middle, right;

        left = getBorderSymbol(direction, "left");
        middle = getBorderSymbol(direction, "middle");
        right = getBorderSymbol(direction, "right");

        separator.append(left);
        for (int i = 0; i < columnWidths.length; i++) {
            int width = columnWidths[i] + 2;
            separator.append(line.repeat(width));
            if (i < columnWidths.length - 1) {
                separator.append(middle);
            }
        }
        separator.append(right);

        return separator;
    }

    /**
     *
     * @param direction Represente la position de la bordure Haute Central ou Basse
     * @param position Represente les extremités de la cellule
     * @return
     */
    private String getBorderSymbol(Direction direction, String position) {
        switch (direction) {
            case TOP:
                return switch (position) {
                    case "left" -> SimpleTableBorder.TOP_LEFT.getSymbol();
                    case "middle" -> SimpleTableBorder.MIDDLE_TOP.getSymbol();
                    case "right" -> SimpleTableBorder.TOP_RIGHT.getSymbol();
                    default -> SimpleTableBorder.H.getSymbol();
                };
            case MIDDLE:
                return switch (position) {
                    case "left" -> SimpleTableBorder.MIDDLE_LEFT.getSymbol();
                    case "middle" -> SimpleTableBorder.MIDDLE.getSymbol();
                    case "right" -> SimpleTableBorder.MIDDLE_RIGHT.getSymbol();
                    default -> SimpleTableBorder.H.getSymbol();
                };
            case BOTTOM:
                return switch (position) {
                    case "left" -> SimpleTableBorder.BOTTOM_LEFT.getSymbol();
                    case "middle" -> SimpleTableBorder.MIDDLE_BOTTOM.getSymbol();
                    case "right" -> SimpleTableBorder.BOTTOM_RIGHT.getSymbol();
                    default -> SimpleTableBorder.H.getSymbol();
                };
            default:
                return SimpleTableBorder.H.getSymbol();
        }
    }

    /**
     * Ajuste la largeur des colonnes du tableau
     *
     * @return widths Tableau des largeurs de colonnes
     */
    private int[] calculateColumnWidths() {
        int numColumns = columnNames.length;
        int[] widths = new int[numColumns];

        // Premier calcul de largeur de colonnes avec le nom des colonnes
        for (int i = 0; i < numColumns; i++) {
            widths[i] = columnNames[i].length();
        }

        // Ajuste la largeur des colonnes en fonction de la valeur à afficher la plus large
        for (Object row : rows) {
            String[] values = (String[]) row;
            for (int i = 0; i < values.length; i++) {
                widths[i] = Math.max(widths[i], values[i].length());
            }
        }

        return widths;
    }


    /**
     * Recupere les noms de colonne du tableau via la methode getColumns()
     *
     * @return Tableau des noms de colonnes
     */
    protected abstract String[] getColumnNames();

    /**
     * Recupere les valeurs à afficher dans le tableau via la methode getValues()
     *
     * @return Tableau d'objet (instance de class) contenant un tableau String[] des valeur à afficher
     */
    protected Object[] getDataListValues() {
        // stream() (similaire à une boucle)
        // Crée un flux à partir de dataList, contenant des objets
        // map()
        // Remplace chaque objet par un tableau de chaînes de caractères, des valeurs à afficher (getValues)
        // toArray()
        // Transforme le flux (la liste) en un tableau d'objets où chaque objet est un tableau de chaînes de caractères
        return dataList.stream()
                .map(this::getValues)
                .toArray(Object[]::new);
    }

    /**
     * Methode ou l on appel les getters de l'objet pour l affichage des valeurs
     * @param item Instance de l'objet
     * @return
     */
    protected abstract String[] getValues(T item);


}
