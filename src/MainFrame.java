import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame{
    public MainFrame(){
        initComp();
    }
    private ImageIcon Hat = new ImageIcon("C:\\Users\\USER\\Desktop\\github\\Zhuanti\\Image\\Hat.png");

    private JLabel jlbStart = new JLabel("Start",JLabel.CENTER);
    private JLabel jlbExit = new JLabel("Exit",JLabel.CENTER);

    private JLabel jlbHat = new JLabel(Hat);
    private int Haw = 255 , Hah = 323;

    private int sw = getToolkit().getScreenSize().width;
    private int sh = getToolkit().getScreenSize().height;
    private int fw = 900 , fh = 600;

    private void initComp(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(sw / 2 - fw / 2 , sh / 2 - fh / 2 , fw , fh);
        this.setLayout(null);

        jlbStart.setBounds(fw / 2 - 250 , fh / 2 + 50 , 200 , 100);
        jlbExit.setBounds(fw / 2 + 50, fh / 2 + 50 , 200 , 100);
        jlbStart.setOpaque(true);
        jlbExit.setOpaque(true);
        jlbStart.setBackground(Color.GREEN);
        jlbExit.setBackground(Color.GREEN);
        jlbStart.setFont(new Font(null,0,40));
        jlbExit.setFont(new Font(null,0,40));
        this.add(jlbStart);
        this.add(jlbExit);

        jlbHat.setBounds(Haw , Hah , 85 , 28);
        this.add(jlbHat);

        this.addKeyListener(new KeyMonitor());

    }
    private class KeyMonitor extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    if(Haw == 555){jlbHat.setBounds(Haw -= 300, Hah , 85 , 28);}
                    break;
                case KeyEvent.VK_RIGHT :
                    if(Haw == 255){jlbHat.setBounds(Haw += 300, Hah , 85 , 28);}
                    break;
                case KeyEvent.VK_ENTER :
                    if(Haw == 255){
                        Stage01 S01 = new Stage01();
                        S01.setVisible(true);
                        MainFrame.this.setVisible(false); }
                    else System.exit(0);
            }
        }
    }
}
