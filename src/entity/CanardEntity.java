package entity;

import asset.VolailleType;

public class CanardEntity extends VolailleEntity {


    public CanardEntity(String groupId, String entryDate, double weight, int age) {
        super(groupId, entryDate, weight, age, VolailleType.CANARD);
    }

}
