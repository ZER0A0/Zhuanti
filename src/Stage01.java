import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Stage01 extends JFrame {
    public Stage01() {
        initComp();
    }
    private int foot = 0 , direction = 0 , jlock = 0;

    private ImageIcon Character_RN = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_RN.png");
    private ImageIcon Character_LN = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_LN.png");
    private ImageIcon Character_R1 = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_R1.png");
    private ImageIcon Character_L1 = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_L1.png");
    private ImageIcon Character_R2 = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_R2.png");
    private ImageIcon Character_L2 = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_L2.png");
    private ImageIcon Character_RJ = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_RJ.png");
    private ImageIcon Character_LJ = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_LJ.png");
    private ImageIcon Character_RD = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_RD.png");
    private ImageIcon Character_LD = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_LD.png");
    private ImageIcon Character_RA = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_RA.png");
    private ImageIcon Character_LA = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Character_LA.png");
    private ImageIcon Hat = new ImageIcon("D:\\Download\\GitHub\\Zhuanti\\Image\\Hat.png");

    private JLabel jlbCharacter = new JLabel(Character_RN);
    private int Chw = 0 , Chh = 565;

    private JLabel jlbHat = new JLabel(Hat);
    private int Haw , Hah , Hatime , Halock = 0;

    private Timer t1 , t2 , t3 , t4 , t5 , t6;

    private int sw = getToolkit().getScreenSize().width;
    private int sh = getToolkit().getScreenSize().height;
    private int fw = 1200, fh = 800;

    private void initComp() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(sw / 2 - fw / 2, sh / 2 - fh / 2, fw, fh);
        this.setLayout(null);

        jlbCharacter.setBounds(Chw, Chh, 200, 200);
        this.add(jlbCharacter);

        jlbHat.setBounds(Chw , Chh , 85 , 28);
        this.add(jlbHat);
        jlbHat.setVisible(false);

        t1 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbCharacter.setBounds(Chw , Chh -= 20 , 200, 200);
                if(Chh == 405){t1.stop() ; t2.start();}
            }
        });
        t2 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbCharacter.setBounds(Chw , Chh += 20 , 200, 200);
                if(Chh == 565){t2.stop();
                if(direction == 0){jlbCharacter.setIcon(Character_RN);}
                else if(direction == 1){jlbCharacter.setIcon(Character_LN);}
                jlock = 0;}
            }
        });
        t3 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat.setBounds(Haw += 40 , Hah , 85 , 28);
                Hatime += 1;
                if(Hatime == 10){t3.stop() ; t4.start();}
            }
        });
        t4 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat.setBounds(Haw -= 40 , Hah , 85 , 28);
                Hatime += 1;
                if(Hatime == 20){t4.stop() ; jlbHat.setVisible(false) ; Halock = 0;}
            }
        });
        t5 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat.setBounds(Haw -= 40 , Hah , 85 , 28);
                Hatime += 1;
                if(Hatime == 10){t5.stop() ; t6.start();}
            }
        });
        t6 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat.setBounds(Haw += 40 , Hah , 85 , 28);
                Hatime += 1;
                if(Hatime == 20){t6.stop() ; jlbHat.setVisible(false) ; Halock = 0;}
            }
        });

        this.addKeyListener(new KeyMonitor());
    }

    private class KeyMonitor extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    direction = 1;
                    jlbCharacter.setBounds(Chw -= 40 , Chh, 200, 200);
                    if(foot == 0 && jlock == 0){jlbCharacter.setIcon(Character_L2) ; foot = 1;}
                    else if(foot == 1 && jlock == 0){jlbCharacter.setIcon(Character_L1) ; foot = 0;}
                    else if(jlock == 1){jlbCharacter.setIcon(Character_LJ);}
                    break;
                case KeyEvent.VK_RIGHT :
                    direction = 0;
                    jlbCharacter.setBounds(Chw += 40 , Chh, 200, 200);
                    if(foot == 0 && jlock == 0){jlbCharacter.setIcon(Character_R2) ; foot = 1;}
                    else if(foot == 1 && jlock == 0){jlbCharacter.setIcon(Character_R1) ; foot = 0;}
                    else if(jlock == 1){jlbCharacter.setIcon(Character_RJ);}
                    break;
                case KeyEvent.VK_UP :
                    if(jlock == 0){
                    if(direction == 0){jlbCharacter.setIcon(Character_RJ);}
                    else if(direction == 1){jlbCharacter.setIcon(Character_LJ);}
                    t1.start();
                    jlock = 1;}
                break;
                case KeyEvent.VK_DOWN :
                    if(direction == 0 && jlock == 0){jlbCharacter.setIcon(Character_RD);}
                    else if(direction == 1 && jlock == 0){jlbCharacter.setIcon(Character_LD);}
                    break;
                case KeyEvent.VK_Z :
                    if(Halock == 0){
                    if(direction == 0){t3.start() ; Haw = Chw + 120;}
                    else if(direction == 1){t5.start() ; Haw = Chw;}
                    Hah = Chh + 60;
                    jlbHat.setBounds(Haw , Hah , 85 , 28);
                    jlbHat.setVisible(true);
                    Hatime = 0;
                    Halock = 1;
                    if(direction == 0 && jlock == 0){jlbCharacter.setIcon(Character_RA);}
                    else if(direction == 1 && jlock == 0){jlbCharacter.setIcon(Character_LA);}
                    break;}
            }
        }
    }
}