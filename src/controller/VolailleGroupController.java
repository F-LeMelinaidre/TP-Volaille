package controller;

import entity.VolailleGroupEntity;
import view.table.VolailleGroupTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VolailleGroupController implements IController
{

    private static VolailleGroupController INSTANCE = null;

    public static VolailleGroupController getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new VolailleGroupController();
        }
        return INSTANCE;
    }

    @Override
    public void read() {
        System.out.println("Volaille Group Read");
        Map<String, VolailleGroupEntity> volailleList = VolailleGroupEntity.getVolailleGroupMap();
        List<VolailleGroupEntity> listData           = new ArrayList<>(volailleList.values());
        VolailleGroupTable volailleGroupTable = new VolailleGroupTable(listData);
        volailleGroupTable.render();
    }

    @Override
    public void create() {
        System.out.println("Volaille Group Create");
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
