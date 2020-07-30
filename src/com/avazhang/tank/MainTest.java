package com.avazhang.tank;

public class MainTest {
    public static void main(String[] args) throws Exception {
//        Frame f = new Frame();
//        f.setSize(800, 500);
//        f.setResizable(false);
//        f.setTitle("tank war");
//        f.setVisible(true);
//        f.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                //super.windowClosing(e);
//                System.exit(0);
//            }
//        });
        TankFrame tf = new TankFrame();
        //initiate enemy tanks
        for(int i = 0; i < 5; i++){
            tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
        }
       // CopyTankFrame ctf = new CopyTankFrame();
        while(true){
            Thread.sleep(50);
            tf.repaint();
        }

    }
}
