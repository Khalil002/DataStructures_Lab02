package UI;

import com.kingaspx.util.RoundFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import keeptoo.KGradientPanel;

/*
 * @Group #9
 */
public class Toast {

    public static int LONG_DELAY = 3500; // 3.5 seconds
    public static int SHORT_DELAY = 2000; // 2 seconds

    private static void smoothJFrame(JDialog dialog) {
        new Thread() {
            @Override
            public void run() {
                double opacidade = 0.1;
                Locale.setDefault(new Locale("en", "US"));
                DecimalFormat df = new DecimalFormat("#.#");

                while (opacidade <= 1.0) {
                    try {
                        opacidade += 0.1;
                        Thread.sleep(100);
                        dialog.setOpacity(Float.valueOf(df.format(opacidade)));

                        if (Float.valueOf(df.format(opacidade)) == 1.0) {
                            break;
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }.start();
    }

    public static class ToastSuccessful extends JDialog {

        int miliseconds;

        public ToastSuccessful(String jFrameTitle, String title, String msg, int time) {
            this.miliseconds = time;

            KGradientPanel kGradientPanel1 = new keeptoo.KGradientPanel();
            KGradientPanel backgroudPanel = new keeptoo.KGradientPanel();
            JLabel logoWhatsapp_lbl = new javax.swing.JLabel();
            JLabel campoMsg_txt = new javax.swing.JLabel();
            JLabel campoTitulo = new javax.swing.JLabel();
            JLabel jLabel1 = new javax.swing.JLabel();
            JSeparator jSeparator1 = new javax.swing.JSeparator();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setUndecorated(true);
            setOpacity(0.0f);
            smoothJFrame(this);

            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            kGradientPanel1.setkEndColor(new java.awt.Color(62, 213, 140));
            kGradientPanel1.setkFillBackground(false);
            kGradientPanel1.setkStartColor(new java.awt.Color(64, 142, 105));
            kGradientPanel1.setOpaque(false);
            kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 100));

            backgroudPanel.setBackground(new java.awt.Color(255, 255, 255));
            backgroudPanel.setkEndColor(new java.awt.Color(255, 255, 255));
            backgroudPanel.setkStartColor(new java.awt.Color(255, 255, 255));
            backgroudPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            logoWhatsapp_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            logoWhatsapp_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_notification_15px.png"))); // NOI18N
            backgroudPanel.add(logoWhatsapp_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 20, 40));

            campoMsg_txt.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
            campoMsg_txt.setForeground(new java.awt.Color(75, 75, 75));
            backgroudPanel.add(campoMsg_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 410, 20));

            campoTitulo.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
            campoTitulo.setText(title); //Change Title
            backgroudPanel.add(campoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 20));

            jLabel1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(181, 181, 181));
            jLabel1.setText(jFrameTitle);
            backgroudPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

            jSeparator1.setBackground(new java.awt.Color(234, 234, 234));
            jSeparator1.setForeground(new java.awt.Color(234, 234, 234));
            backgroudPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 430, 10));

            getContentPane().add(backgroudPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 100));

            setBounds(0, 0, 450, 100);

            setAlwaysOnTop(true);

            new RoundFrame().corner(this, 450, 100, 10, 10);
            campoMsg_txt.setText(msg);

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int y = dim.height / 2 - getSize().height / 2;
            int half = y / 2;
            setLocation(dim.width / 2 - getSize().width / 2, y + half);

            setVisible(true);

            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(miliseconds);
                        dispose();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

}
