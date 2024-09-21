package menu;

public enum TypeVolaille {


    CANARD (1, "Canards"),
    POULET (2, "Poulets");

    private int id;
    private String label;

    TypeVolaille(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static TypeVolaille getById(int id) {
        switch (id) {
            case 1:
                return CANARD;
            case 2:
                return POULET;
            default:
                throw new IllegalArgumentException("ID invalide : " + id);
        }
    }
    public int getId() { return id; }
    public String getLabel() { return label; }

}
