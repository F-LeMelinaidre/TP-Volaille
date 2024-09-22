package controller;

import asset.VolailleType;
import menu.MenuRenderer;

public interface IController {

    public boolean read();

    public boolean readAll(int id);

    public void create();
    public void create(VolailleType type);
    public void update();
    public void write();
    public void delete();

}
