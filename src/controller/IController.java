package controller;

import asset.VolailleType;
import menu.MenuRenderer;

public interface IController<T> {

    public boolean read();
    boolean readAll(T type);
    public void create();
    public void create(T type);
    public void update();
    public void write();
    public void delete();
    public void csvExport(T type);

}
