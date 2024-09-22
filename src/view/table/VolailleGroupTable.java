package view.table;

import entity.VolailleEntity;
import entity.VolailleGroupEntity;

import java.util.List;

public class VolailleGroupTable extends Table<VolailleGroupEntity> {
    public VolailleGroupTable(List<VolailleGroupEntity> dataList) {
        super(dataList);
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"Groupe Id", "Categorie", "Date d'entrée", "Nb d'individus", "Age d'entrée", "Age", "Poid moyen"};
    }

    @Override
    protected String[] getValues(VolailleGroupEntity volailleGroup) {
        return new String[]{
                volailleGroup.getIdGroup(),
                volailleGroup.getGroupsType().toString(),
                volailleGroup.getEntryDate(),
                Integer.toString(volailleGroup.getQuantityItems()),
                Integer.toString(volailleGroup.getEntryAge()) + " semaines",
                volailleGroup.getCurrentAge(),
                Double.toString((volailleGroup.getAverageWeight())) + " Kg"
        };
    }
}
