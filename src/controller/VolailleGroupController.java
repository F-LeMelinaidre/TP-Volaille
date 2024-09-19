package controller;

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
