package GUI;

import GUI.ActionListeners.CreateArrayListener;

import javax.swing.*;
import java.awt.*;

public class CreateArrayPanel extends JPanel {

    private JSlider s1;
    private ArrayDrafter drafter;

    CreateArrayPanel(ArrayDrafter drafter)
    {
        super(new GridLayout(2,1));
        this.drafter = drafter;

        createComponents();

    }

    private void createComponents()
    {
        //setMaximumSize(new Dimension(getWidth()/2, 400));
        s1 = new JSlider(JSlider.HORIZONTAL,10,300, 155);

        s1.setMinorTickSpacing(2);
        s1.setMajorTickSpacing(10);
       // s1.setPaintTicks(true);
        //s1.setPaintLabels(true);

        CreateArrayListener CAL = new CreateArrayListener(s1,drafter);
        s1.addChangeListener(CAL);
        JLabel label = new JLabel("Move slider to create and resize random array");
        add(label);
        add(s1);

    }
}
