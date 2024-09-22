package entity;

import asset.VolailleType;
import util.DateConverter;
import util.IdManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class VolailleGroupEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    private static Map<String, VolailleGroupEntity> volailleGroupMap = new HashMap<>();
    private String idGroup;
    private String entryDate;
    private VolailleType groupsType;
    private int quantityItems;
    private int entryAge;
    private double averageWeight;


    public VolailleGroupEntity(String entryDate, VolailleType groupsType, int quantityItems, int entryAge,
                               double averageWeight) {

        this.entryDate     = entryDate;
        this.groupsType    = groupsType;
        this.quantityItems = quantityItems;
        this.entryAge      = entryAge;
        this.averageWeight = averageWeight;

        IdManager.initCounters(getVolailleGroupMap(), VolailleGroupEntity::getEntryCalendarDate,
                               VolailleGroupEntity::getIdGroup);

        this.idGroup = IdManager.generateId(groupsType.getId(), this.getEntryCalendarDate());

        this.addVolailleGroupList();

        this.createVolailleList();

    }

    public VolailleGroupEntity(String idGroup, String entryDate, VolailleType groupsType, int quantityItems,
                               int entryAge, double averageWeight) {
        this.idGroup       = idGroup;
        this.entryDate     = entryDate;
        this.groupsType    = groupsType;
        this.quantityItems = quantityItems;
        this.entryAge      = entryAge;
        this.averageWeight = averageWeight;

        this.addVolailleGroupList();

        this.createVolailleList();
    }

    public String getIdGroup() {
        return this.idGroup;
    }

    public String getEntryDate() {
        return this.entryDate;
    }

    public Calendar getEntryCalendarDate() {
        return DateConverter.StringToCalendar(this.entryDate, "dd/MM/yyyy");
    }

    public VolailleType getGroupsType() {
        return this.groupsType;
    }

    public int getQuantityItems() {
        return this.quantityItems;
    }

    public int getEntryAge() {
        return this.entryAge;
    }

    public String getCurrentAge() {
        Calendar entryDate = this.getEntryCalendarDate();
        LocalDate localDateEntry = DateConverter.CalendarToLocalDate(entryDate);
        LocalDate currentDate = LocalDate.now();

        long daysBetween = ChronoUnit.DAYS.between(localDateEntry, currentDate);
        long weeks = (daysBetween / 7) + this.entryAge;
        long days = daysBetween % 7;

        return weeks + " semaines et " + days + " jours";
    }

    public double getAverageWeight() {
        return this.averageWeight;
    }


    public static void setVolailleGroupMap(Map<String, VolailleGroupEntity> data) {
        volailleGroupMap = data;
    }

    public static Map<String, VolailleGroupEntity> getVolailleGroupMap() {
        return volailleGroupMap;
    }

    private void addVolailleGroupList() {
        Map<String, VolailleGroupEntity> volailleGroupMap = getVolailleGroupMap();
        volailleGroupMap.put(this.idGroup, this);
    }

    private void createVolailleList() {

        for (int i = 0; i < quantityItems; i++) {
            switch (this.groupsType) {
                case CANARD:
                    CanardEntity canard = new CanardEntity(this.idGroup, this.entryDate, this.averageWeight,
                                                           this.entryAge);
                    VolailleEntity.addToVolailleMap(canard);
                    break;
                case POULET:
                    PouletEntity poulet = new PouletEntity(this.idGroup, this.entryDate, this.averageWeight,
                                                           this.entryAge);
                    VolailleEntity.addToVolailleMap(poulet);
                    break;
                default:
                    //TODO EXCEPTION
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "VolailleGroupEntity{" + "idGroup='" + idGroup + '\'' + ", entryDate='" + entryDate + '\'' + ", " + "groupsType=" + groupsType.name() + ", quantityItems=" + quantityItems + ", entryAge=" + entryAge + ", averageWeight=" + averageWeight + '}';
    }
}