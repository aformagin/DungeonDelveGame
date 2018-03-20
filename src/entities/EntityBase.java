package entities;

import java.awt.*;

public interface EntityBase {
public void tick();
public void render(Graphics g);

public double getX();
public double getY();
}
