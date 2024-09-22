package asset;

public enum VolailleType {

    CANARD (1, "Canards"/*3.60*/),
    POULET (2, "Poulets"/*2.15*/);

    private int id;
    private String Name;

    /*private final double poidsAbbatage;
    private double prixKilo = 0.0;*/

    VolailleType(int id, String label/*double poidsAbbatage*/) {
        this.id = id;
        this.Name = label;

        /*this.poidsAbbatage = poidsAbbatage;*/
    }

    public static VolailleType getById(int id) {
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
    public String getName() { return Name; }

    /*public double getPoidsAbbatage() {
        return poidsAbbatage;
    }

    public double getPrixKilo() {
        return prixKilo;
    }

    public void setPrixKilo(double prixKilo) {
        this.prixKilo = prixKilo;
    }

    public static ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        for (VolailleType type : VolailleType.values()) {
            names.add(type.name());
        }
        return names;
    }*/

}
