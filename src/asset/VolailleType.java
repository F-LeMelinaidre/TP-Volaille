package asset;

import java.util.ArrayList;

public enum VolailleType {
    CANARD (1, 3.60),
    POULET (2, 2.15);

    private int id;
    private final double poidsAbbatage;
    private double prixKilo = 0.0;

    VolailleType(int id, double poidsAbbatage) {
        this.id = id;
        this.poidsAbbatage = poidsAbbatage;
    }

    public int getId() { return id; }
    public double getPoidsAbbatage() {
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
    }

}
