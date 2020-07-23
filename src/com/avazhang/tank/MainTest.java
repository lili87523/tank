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
        while(true){
            Thread.sleep(50);
            tf.repaint();
        }

    }
}
