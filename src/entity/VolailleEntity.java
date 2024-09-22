package entity;

import asset.VolailleType;

import java.util.HashMap;
import java.util.Map;

public abstract class VolailleEntity
{

    private static Map<String, VolailleEntity> volailleMap = new HashMap<>();
    private static int idCounter = 0;
    private static String groupIdTmp = null;
    protected String id;
    protected String idGroup;
    protected String entryDate;
    protected double weight;
    protected int entryAge;
    protected VolailleType type;

    public VolailleEntity(String groupId, String entryDate, double weight, int entryAge, VolailleType type) {
        this.idGroup = groupId;
        this.entryDate = entryDate;
        this.weight = weight;
        this.entryAge = entryAge;
        this.type = type;

        this.id = this.generateId();
    }

    private String generateId() {

        if (groupIdTmp == null || groupIdTmp != this.idGroup) {
            groupIdTmp = this.idGroup;
            idCounter = 0;
        }

        return this.idGroup + String.format("%02d", this.idCounter++); //on incrémente apres
    }

    public static Map<String, VolailleEntity> getVolailleMap() {
        if (volailleMap == null) {
            volailleMap = new HashMap<String, VolailleEntity>();
        }
        return volailleMap;
    }

    public static void addToVolailleMap(VolailleEntity item) {
        volailleMap.put(item.id, item);
    }

    @Override
    public String toString() {
        return "VolailleEntity{" + "id='" + id + '\'' + ", idGroup='" + idGroup + '\'' + ", entryDate='" + entryDate +
               '\'' + ", weight=" + weight + ", age=" + entryAge + ", type=" + type.name() + '}';
    }
}
