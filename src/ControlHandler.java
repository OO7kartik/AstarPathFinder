import javax.swing.*;
import java.awt.*;

public class ControlHandler {
    private Frame frame;
    private JButton run;


    public ControlHandler(Frame frame) {
        this.frame = frame;


        // setup button
        run = new JButton();
        run.setText("run");
        run.setName("run");
        run.setFocusable(false);
        run.addActionListener(frame);
        run.setMargin(new Insets(0, 0, 0, 0));
        run.setVisible(true);
    }
}
