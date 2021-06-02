package sk.stuba.fei.uim.oop;

import lombok.Setter;

import java.awt.*;

public class PlusShape extends Rectangle
{
    @Setter
    private Color color;
    private Color background;

    public PlusShape(Color color, int x, int y, int width, int height, Color background)
    {
        super(x, y, width, height);
        this.color = color;
        this.background = background;
    }

    public void drawPlus(Graphics g)
    {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
        g.setColor(this.background);
        g.fillRect(this.x, this.y, 1+this.width/3, 1+this.height/3);
        g.setColor(this.background);
        g.fillRect(this.x, this.y + 2*this.height/3, 1+this.width/3, 1+this.height/3);
        g.setColor(this.background);
        g.fillRect(this.x + 2*this.width/3, this.y, 1+this.width/3, 1+this.height/3);
        g.setColor(this.background);
        g.fillRect(this.x + 2*this.width/3, this.y + 2*this.height/3, 1+this.width/3, 1+this.height/3);
    }
}
