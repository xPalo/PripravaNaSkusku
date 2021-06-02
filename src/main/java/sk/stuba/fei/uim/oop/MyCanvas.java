package sk.stuba.fei.uim.oop;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener, ActionListener
{
    private JButton plusButton;
    private JButton useckaButton;
    private Choice colorChoice;
    private JLabel colorLabel;
    private MyCanvas myCanvas;

    private boolean wannaPlus;
    private boolean wannaUsecka;

    private HashSet<PlusShape> plusObjects;
    @Setter
    private Color currentColor;
    private PlusShape currentPlus;

    int xpos = 0, ypos = 0;

    public MyCanvas(JButton plusButton, JButton useckaButton, Choice colorChoice, JLabel colorLabel)
    {
        super();
        this.plusButton = plusButton;
        this.useckaButton = useckaButton;
        this.colorChoice = colorChoice;
        this.colorLabel = colorLabel;
        this.wannaPlus = false;
        this.wannaUsecka = false;
        this.plusButton.addActionListener(this);
        this.useckaButton.addActionListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.currentColor = Color.RED;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.plusButton)
        {
            this.wannaUsecka = false;
            this.wannaPlus = true;
        }
        else if (e.getSource() == this.useckaButton)
        {
            this.wannaPlus = false;
            this.wannaUsecka = true;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (this.wannaPlus)
        {
            if (this.plusObjects == null)
            {
                this.plusObjects = new HashSet<>();
            }
            this.xpos = e.getX();
            this.ypos = e.getY();
            this.currentPlus = new PlusShape(this.currentColor, xpos, ypos, 1, 1, this.getBackground());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (this.currentPlus != null)
        {
            this.plusObjects.add(this.currentPlus);
            this.repaint();
            this.currentPlus = null;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        if (this.currentPlus != null)
        {
            this.currentPlus.width = e.getX() - xpos;
            this.currentPlus.height = e.getY() - ypos;
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) { }

    public void paint(Graphics g)
    {
        if (this.plusObjects != null)
        {
            for (PlusShape p : this.plusObjects)
            {
                p.setColor(this.currentColor);
                p.drawPlus(g);
            }
        }
        if (this.currentPlus != null)
        {
            this.currentPlus.drawPlus(g);
        }
    }
}
