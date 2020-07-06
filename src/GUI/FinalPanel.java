package GUI;

import javax.swing.*;
import java.awt.*;

public class FinalPanel extends JPanel {
    private ArrayOptionPanel AOP;
    private ArrayDrafter drafter;

    public FinalPanel(ArrayDrafter drafter)
    {
        super(new GridLayout(2,1));
        this.drafter = drafter;
        this.AOP = new ArrayOptionPanel(drafter);
        createComponents();
    }
    private void createComponents()
    {

        add(AOP);
        add(drafter);
    }
}
