package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainFrame extends JFrame implements ItemListener
{
    private JButton plusButton;
    private JButton useckaButton;
    private Choice colorChoice;
    private JLabel colorLabel;
    private MyCanvas myCanvas;
    private Color currentColor;

    public MainFrame()
    {
        this.setVisible(true);
        this.setSize(720, 640);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        var controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,4));

        this.plusButton = new JButton("Plus");
        this.useckaButton = new JButton("Usecka");
        this.colorChoice = new Choice();
        this.colorChoice.add("Red");
        this.colorChoice.add("Green");
        this.colorChoice.add("Blue");
        this.colorChoice.select(0);
        this.colorChoice.addItemListener(this);

        this.colorLabel = new JLabel();
        this.colorLabel.setHorizontalAlignment(JLabel.CENTER);
        this.colorLabel.setOpaque(true);
        this.colorLabel.setBackground(Color.RED);

        controlPanel.add(plusButton);
        controlPanel.add(useckaButton);
        controlPanel.add(colorChoice);
        controlPanel.add(colorLabel);

        this.myCanvas = new MyCanvas(this.plusButton, this.useckaButton, this.colorChoice, this.colorLabel);

        this.add(controlPanel, BorderLayout.NORTH);
        this.add(myCanvas, BorderLayout.CENTER);
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource() == this.colorChoice)
        {
            switch (colorChoice.getSelectedItem())
            {
                case "Red":
                    Color c = Color.RED;
                    this.currentColor = c;
                    this.colorLabel.setBackground(c);
                    this.myCanvas.setCurrentColor(c);
                    this.myCanvas.repaint();
                    break;
                case "Green":
                    c = Color.GREEN;
                    this.currentColor = c;
                    this.colorLabel.setBackground(c);
                    this.myCanvas.setCurrentColor(c);
                    this.myCanvas.repaint();
                    break;
                case "Blue":
                    c = Color.BLUE;
                    this.currentColor = c;
                    this.colorLabel.setBackground(c);
                    this.myCanvas.setCurrentColor(c);
                    this.myCanvas.repaint();
                    break;
            }
        }
    }
}
