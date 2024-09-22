package controller;

import asset.VolailleType;
import entity.VolailleGroupEntity;
import util.InputHelper;
import util.fileManager.CsvFile;
import view.table.VolailleGroupTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VolailleGroupController implements IController<VolailleType>
{

    private static VolailleGroupController INSTANCE = null;
    private InputHelper inputHelper;
    private Map<String, VolailleGroupEntity> volailleList;

    public VolailleGroupController() {
        this.inputHelper = new InputHelper();
        this.volailleList = VolailleGroupEntity.getVolailleGroupMap();
    }

    public static VolailleGroupController getINSTANCE() {

        if (INSTANCE == null) {
            INSTANCE = new VolailleGroupController();
        }
        return INSTANCE;
    }

    @Override
    public boolean read() {

        boolean result = false;

        String identifiant = inputHelper.inputMapHasKey(volailleList, "\nSaisissez un identifiant ");

        if (identifiant != null) {
            VolailleGroupEntity volailleGroup = volailleList.get(identifiant);

            System.out.println("\n   Identifant du lot : " + volailleGroup.getIdGroup());
            System.out.println("       Date d'entrée : " + volailleGroup.getEntryDate());
            System.out.println("    Type de volaille : " + volailleGroup.getGroupsType());
            System.out.println("  Nombre d'individus : " + volailleGroup.getQuantityItems());
            System.out.println("        Age d'entrée : " + volailleGroup.getEntryAge() + " semaines");
            System.out.println("          Age actuel : " + volailleGroup.getCurrentAge());
            System.out.println("      Age poid moyen : " + volailleGroup.getAverageWeight() + "\n");

            result = true;
        }

        return result;
    }

    /**
     * @param type Type de volaille
     * @return
     */
    @Override
    public boolean readAll(VolailleType type) {

        List<VolailleGroupEntity> dataList = (type == null) ? new ArrayList<>(volailleList.values())
                                                            : volailleList.values().stream()
                                                                          .filter(entity -> entity.getGroupsType().equals(type))
                                                                          .collect(Collectors.toList());


        String title = (type == null) ? "Volailles" : type.getName();
        System.out.printf("%n%s%n", "Lots des " + title);

        VolailleGroupTable volailleGroupTable = new VolailleGroupTable(dataList);
        return volailleGroupTable.render();
    }

    @Override
    public void create() {

    }

    @Override
    public void create(VolailleType type) {

        VolailleType volailleType = (type != null) ? type : inputHelper.inputToEnum(VolailleType.class,
                                                                                    "\nSaisissez le type de volaille : ");

        String entryDate = inputHelper.inputDate("dd/MM/yyyy", "\nSaisissez la date d'entrée ");
        int quantity = inputHelper.inputInteger("\nSaisissez le nombre d'individus : ");
        int entryAge = inputHelper.inputInteger("\nSaisissez l'âge moyen (semaines) : ");
        double entryWeight = inputHelper.inputDouble("\nSaisissez le poids moyen (Kg) : ");

        VolailleGroupEntity volaille = new VolailleGroupEntity(entryDate, volailleType, quantity, entryAge,
                                                               entryWeight);

        this.readAll(type);
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

    @Override
    public void csvExport(VolailleType type) {
        List<VolailleGroupEntity> dataList = (type == null) ? new ArrayList<>(volailleList.values())
                                                            : volailleList.values().stream()
                                                                          .filter(entity -> entity.getGroupsType().equals(type))
                                                                          .toList();
        String fileName = (type == null) ? "Volailles" : type.getName();
        CsvFile csvFile = new CsvFile(fileName + "_list");
        try {
            csvFile.writeFile(dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.readAll(type);
    }


}
