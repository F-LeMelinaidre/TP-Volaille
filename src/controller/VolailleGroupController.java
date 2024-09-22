package controller;

import asset.VolailleType;
import entity.VolailleGroupEntity;
import util.InputHelper;
import view.table.VolailleGroupTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VolailleGroupController implements IController
{

    private static VolailleGroupController INSTANCE = null;
    private InputHelper inputHelper = new InputHelper();

    public static VolailleGroupController getINSTANCE() {

        if (INSTANCE == null) {
            INSTANCE = new VolailleGroupController();
        }
        return INSTANCE;
    }

    @Override
    public boolean read() {

        boolean result = false;

        Map<String, VolailleGroupEntity> volailleList = VolailleGroupEntity.getVolailleGroupMap();
        String identifiant = inputHelper.inputMapHasKey(volailleList, "\nSaisissez un identifiant ");

        if (identifiant != null) {
            VolailleGroupEntity volailleGroup = volailleList.get(identifiant);

            System.out.println("     \nIdentifant du lot : " + volailleGroup.getIdGroup());
            System.out.println("       Date d'entrée : " + volailleGroup.getEntryDate());
            System.out.println("    Type de volaille : " + volailleGroup.getGroupsType());
            System.out.println("  Nombre d'individus : " + volailleGroup.getQuantityItems());
            System.out.println("        Age d'entrée : " + volailleGroup.getEntryAge());
            System.out.println("          Age actuel : " + volailleGroup.getCurrentAge());
            System.out.println("      Age poid moyen : " + volailleGroup.getAverageWeight() + "\n");

            result = true;
        }

        return result;
    }

    /**
     * @param id Type de volaille
     * @return
     */
    @Override
    public boolean readAll(int id) {

        Map<String, VolailleGroupEntity> volailleList = VolailleGroupEntity.getVolailleGroupMap();
        List<VolailleGroupEntity> dataList;

        VolailleType type = (id == 0) ? null : VolailleType.getById(id);
        if (id == 0) {
            dataList = new ArrayList<>(volailleList.values());
        } else {
            dataList = volailleList.values().stream().filter(entity -> entity.getGroupsType().equals(type))
                                   .collect(Collectors.toList());
        }


        String title = (id == 0) ? "Volailles" : type.getName();
        System.out.printf("%n%s%n", "Lots de " + title);

        VolailleGroupTable volailleGroupTable = new VolailleGroupTable(dataList);
        return volailleGroupTable.render();
    }

    @Override
    public void create() {

    }

    @Override
    public void create(VolailleType type) {
        VolailleType volailleType = (type != null) ? type
                                                   : inputHelper.inputToEnum(VolailleType.class,
                                                                             "\nSaisissez le type de volaille : ");

        String entryDate = inputHelper.inputDate("dd/MM/yyyy", "\nSaisissez la date d'entrée ");
        int quantity = inputHelper.inputInteger("\nSaisissez le nombre d'individus : ");
        int entryAge = inputHelper.inputInteger("\nSaisissez l'âge moyen (semaines) : ");
        double entryWeight = inputHelper.inputDouble("\nSaisissez le poids moyen (Kg) : ");

        VolailleGroupEntity volaille = new VolailleGroupEntity(entryDate, volailleType, quantity, entryAge, entryWeight);

        Map<String, VolailleGroupEntity> volailleList = VolailleGroupEntity.getVolailleGroupMap();
        List<VolailleGroupEntity> dataList = volailleList.values().stream()
                                                         .filter(entity -> entity.getGroupsType().equals(volailleType))
                                                         .collect(Collectors.toList());
        VolailleGroupTable volailleGroupTable = new VolailleGroupTable(dataList);
        volailleGroupTable.render();
    }

    @Override
    public void update() {

    }

    @Override
    public void write() {

    }

    @Override
    public void delete() {
        System.out.println("Volaille Group Delete");
    }


}
