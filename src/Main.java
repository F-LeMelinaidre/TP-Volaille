import asset.VolailleType;
import entity.VolailleEntity;
import entity.VolailleGroupEntity;
import view.table.VolailleGroupTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        VolailleGroupEntity group1 = new VolailleGroupEntity("12/05/2023", VolailleType.POULET, 50, 8, 0.5);
        VolailleGroupEntity group2 = new VolailleGroupEntity("14/05/2023", VolailleType.CANARD, 35, 5, 0.5);
        VolailleGroupEntity group3 = new VolailleGroupEntity("14/05/2023", VolailleType.POULET, 20, 6, 0.6);
        VolailleGroupEntity group4 = new VolailleGroupEntity("14/05/2023", VolailleType.POULET, 35, 5, 0.3);

        Map<String, VolailleGroupEntity> volailleList = VolailleGroupEntity.getVolailleGroupMap();

        List<VolailleGroupEntity> listData           = new ArrayList<>(volailleList.values());
        VolailleGroupTable        volailleGroupTable = new VolailleGroupTable(listData);
        volailleGroupTable.render();
    }
}