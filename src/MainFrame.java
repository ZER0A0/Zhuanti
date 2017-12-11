import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    public MainFrame(){
        initComp();
    }
    private JButton jbtStart = new JButton("Start");
    private JButton jbtExit = new JButton("Exit");

    private int sw = getToolkit().getScreenSize().width;
    private int sh = getToolkit().getScreenSize().height;
    private int fw = 900 , fh = 600;

    private void initComp(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(sw / 2 - fw / 2 , sh / 2 - fh / 2 , fw , fh);
        this.setLayout(null);

        jbtStart.setBounds(fw / 2 - 250 , fh / 2 + 50 , 200 , 100);
        jbtExit.setBounds(fw / 2 + 50, fh / 2 + 50 , 200 , 100);
        this.add(jbtStart);
        this.add(jbtExit);

        jbtStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stage01 S01 = new Stage01();
                S01.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jbtExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
