package GUI;

import javax.swing.*;
import java.awt.*;

public class ArrayOptionPanel extends JPanel {
    private CreateArrayPanel CAP;
    ArrayDrafter drafter;
    private AlgorithmPanel AP;
    public ArrayOptionPanel(ArrayDrafter drafter)
    {
        super(new GridLayout(1,2));
        this.CAP = new CreateArrayPanel(drafter);
        this.AP = new AlgorithmPanel(drafter);
        createComponents();
    }
    private void createComponents()
    {
        add(CAP);
        add(AP);
    }
}
