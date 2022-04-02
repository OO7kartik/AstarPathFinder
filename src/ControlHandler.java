import javax.swing.*;
import java.awt.*;

public class ControlHandler {
    private Frame frame;
    private JButton run;

    public ControlHandler(Frame frame) {
        this.frame = frame;

        // setup run button
        run = new JButton();
        run.setText("run");
        run.setName("run");
        run.setFocusable(false);
        run.addActionListener(frame);
        run.setMargin(new Insets(0, 0, 0, 0));
        run.setVisible(true);
    }

    public JButton getRunButton() {
        return run;
    }

    public void setPositions() {
        run.setBounds(116, frame.getHeight() - 88, 52, 22);
    }

    public void addAll() {
        frame.add(run);
    }
}
