package entity;

import asset.VolailleType;

public class PouletEntity extends VolailleEntity {


    public PouletEntity(String groupId, String entryDate, double weight, int age) {
        super(groupId, entryDate, weight, age, VolailleType.POULET);
    }

}
