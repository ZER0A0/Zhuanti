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
    private int foot = 0 , direction = 0 , jlock = 0 , dlock = 0;

    private ImageIcon Character_RN = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_RN.png");
    private ImageIcon Character_LN = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_LN.png");
    private ImageIcon Character_R1 = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_R1.png");
    private ImageIcon Character_L1 = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_L1.png");
    private ImageIcon Character_R2 = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_R2.png");
    private ImageIcon Character_L2 = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_L2.png");
    private ImageIcon Character_RJ = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_RJ.png");
    private ImageIcon Character_LJ = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_LJ.png");
    private ImageIcon Character_RD = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_RD.png");
    private ImageIcon Character_LD = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_LD.png");
    private ImageIcon Character_RA = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_RA.png");
    private ImageIcon Character_LA = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Character_LA.png");
    private ImageIcon Hat1 = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Hat.png");
    private ImageIcon Hat2 = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Hat.png");
    private ImageIcon Hat3 = new ImageIcon("C:\\Users\\USER\\Desktop\\GitHub\\Zhuanti\\Image\\Hat.png");

    private JLabel jlbCharacter = new JLabel(Character_RN);
    private int Chw = 0 , Chh = 565;

    private JLabel jlbHat1 = new JLabel(Hat1);
    private JLabel jlbHat2 = new JLabel(Hat2);
    private JLabel jlbHat3 = new JLabel(Hat3);
    private int Haw1 , Hah1 , hatime1 , halock1 = 0;
    private int Haw2 , Hah2 , hatime2 , halock2 = 0;
    private int Haw3 , Hah3 , hatime3 , halock3 = 0;

    private Timer jumput , jumpdt;
    private Timer rightatt1 , leftatt1;
    private Timer rightatt2 , leftatt2;
    private Timer rightatt3 , leftatt3;

    private int sw = getToolkit().getScreenSize().width;
    private int sh = getToolkit().getScreenSize().height;
    private int fw = 1200, fh = 800;

    private void initComp() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(sw / 2 - fw / 2, sh / 2 - fh / 2, fw, fh);
        this.setLayout(null);

        jlbCharacter.setBounds(Chw, Chh, 200, 200);
        this.add(jlbCharacter);

        jlbHat1.setBounds(Chw , Chh , 85 , 28);
        jlbHat2.setBounds(Chw , Chh , 85 , 28);
        jlbHat3.setBounds(Chw , Chh , 85 , 28);
        this.add(jlbHat1);
        this.add(jlbHat2);
        this.add(jlbHat3);
        jlbHat1.setVisible(false);
        jlbHat2.setVisible(false);
        jlbHat3.setVisible(false);

        jumput = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbCharacter.setBounds(Chw , Chh -= 20 , 200, 200);
                if(Chh == 405){jumput.stop() ; jumpdt.start();}
            }
        });
        jumpdt = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbCharacter.setBounds(Chw , Chh += 20 , 200, 200);
                if(Chh == 565){jumpdt.stop();
                if(direction == 0){jlbCharacter.setIcon(Character_RN);}
                else if(direction == 1){jlbCharacter.setIcon(Character_LN);}
                jlock = 0;}
            }
        });
        rightatt1 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat1.setBounds(Haw1 += 40 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 10){rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = 0;
                    if(jlock == 0 && dlock == 0){
                        if(direction == 0){jlbCharacter.setIcon(Character_RN);}
                        else if(direction == 1){jlbCharacter.setIcon(Character_LN);}}}
            }
        });
        leftatt1 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat1.setBounds(Haw1 -= 40 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 10){leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = 0;
                    if(jlock == 0 && dlock == 0){
                        if(direction == 0){jlbCharacter.setIcon(Character_RN);}
                        else if(direction == 1){jlbCharacter.setIcon(Character_LN);}}}
            }
        });
        rightatt2 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat2.setBounds(Haw2 += 40 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 10){rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = 0;
                    if(jlock == 0 && dlock == 0){
                        if(direction == 0){jlbCharacter.setIcon(Character_RN);}
                        else if(direction == 1){jlbCharacter.setIcon(Character_LN);}}}
            }
        });
        leftatt2 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat2.setBounds(Haw2 -= 40 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 10){leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = 0;
                    if(jlock == 0 && dlock == 0){
                        if(direction == 0){jlbCharacter.setIcon(Character_RN);}
                        else if(direction == 1){jlbCharacter.setIcon(Character_LN);}}}
            }
        });
        rightatt3 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat3.setBounds(Haw3 += 40 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 10){rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = 0;
                    if(jlock == 0 && dlock == 0){
                        if(direction == 0){jlbCharacter.setIcon(Character_RN);}
                        else if(direction == 1){jlbCharacter.setIcon(Character_LN);}}}
            }
        });
        leftatt3 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat3.setBounds(Haw3 -= 40 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 10){leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = 0;
                    if(jlock == 0 && dlock == 0){
                        if(direction == 0){jlbCharacter.setIcon(Character_RN);}
                        else if(direction == 1){jlbCharacter.setIcon(Character_LN);}}}
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
                    dlock = 0;
                    if(Chw - 40 >= 0){
                    jlbCharacter.setBounds(Chw -= 40 , Chh, 200, 200);}
                    if(foot == 0 && jlock == 0){jlbCharacter.setIcon(Character_L2) ; foot = 1;}
                    else if(foot == 1 && jlock == 0){jlbCharacter.setIcon(Character_L1) ; foot = 0;}
                    else if(jlock == 1){jlbCharacter.setIcon(Character_LJ);}
                    break;
                case KeyEvent.VK_RIGHT :
                    direction = 0;
                    dlock = 0;
                    if(Chw + 40 <= 1000){
                    jlbCharacter.setBounds(Chw += 40 , Chh, 200, 200);}
                    if(foot == 0 && jlock == 0){jlbCharacter.setIcon(Character_R2) ; foot = 1;}
                    else if(foot == 1 && jlock == 0){jlbCharacter.setIcon(Character_R1) ; foot = 0;}
                    else if(jlock == 1){jlbCharacter.setIcon(Character_RJ);}
                    break;
                case KeyEvent.VK_UP :
                    if(jlock == 0){dlock = 0;
                    if(direction == 0){jlbCharacter.setIcon(Character_RJ);}
                    else if(direction == 1){jlbCharacter.setIcon(Character_LJ);}
                    jumput.start();
                    jlock = 1;}
                    break;
                case KeyEvent.VK_DOWN :
                    if(dlock == 0 && jlock == 0){
                    if(direction == 0 && jlock == 0){jlbCharacter.setIcon(Character_RD);}
                    else if(direction == 1 && jlock == 0){jlbCharacter.setIcon(Character_LD);}
                    dlock = 1;}
                    break;
                case KeyEvent.VK_Z :
                    if(halock1 == 0){
                        if(direction == 0){rightatt1.start() ; Haw1 = Chw + 120;}
                        else if(direction == 1){leftatt1.start() ; Haw1 = Chw;}
                        if(dlock == 0){Hah1 = Chh + 60;}
                        else if(dlock == 1){Hah1 = Chh + 120;}
                        jlbHat1.setBounds(Haw1 , Hah1 , 85 , 28);
                        jlbHat1.setVisible(true);
                        if(direction == 0 && jlock == 0 && dlock == 0){jlbCharacter.setIcon(Character_RA);}
                        else if(direction == 1 && jlock == 0 && dlock == 0){jlbCharacter.setIcon(Character_LA);}
                        hatime1 = 0;
                        halock1 = 1;}
                    else if(halock1 == 1 && halock2 == 0){
                        if(direction == 0){rightatt2.start() ; Haw2 = Chw + 120;}
                        else if(direction == 1){leftatt2.start() ; Haw2 = Chw;}
                        if(dlock == 0){Hah2 = Chh + 60;}
                        else if(dlock == 1){Hah2 = Chh + 120;}
                        jlbHat2.setBounds(Haw2 , Hah2 , 85 , 28);
                        jlbHat2.setVisible(true);
                        if(direction == 0 && jlock == 0 && dlock == 0){jlbCharacter.setIcon(Character_RA);}
                        else if(direction == 1 && jlock == 0 && dlock == 0){jlbCharacter.setIcon(Character_LA);}
                        hatime2 = 0;
                        halock2 = 1;}
                    else if(halock1 == 1 && halock2 == 1 && halock3 == 0){
                        if(direction == 0){rightatt3.start() ; Haw3 = Chw + 120;}
                        else if(direction == 1){leftatt3.start() ; Haw3 = Chw;}
                        if(dlock == 0){Hah3 = Chh + 60;}
                        else if(dlock == 1){Hah3 = Chh + 120;}
                        jlbHat3.setBounds(Haw3 , Hah3 , 85 , 28);
                        jlbHat3.setVisible(true);
                        if(direction == 0 && jlock == 0 && dlock == 0){jlbCharacter.setIcon(Character_RA);}
                        else if(direction == 1 && jlock == 0 && dlock == 0){jlbCharacter.setIcon(Character_LA);}
                        hatime3 = 0;
                        halock3 = 1;}
                    break;
            }
        }
    }
}