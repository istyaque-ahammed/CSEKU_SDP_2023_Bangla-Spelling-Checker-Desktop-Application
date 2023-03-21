package Bangla_Spelling_Checker;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
public class introduction extends JFrame {
    JFrame frame,demo;
    JLabel image = new JLabel(new ImageIcon("src\\Images\\Logo.png"));
    JLabel text = new JLabel("শুদ্ধ বাংলা বানান চর্চা");
    JProgressBar progressBar = new JProgressBar();
    JLabel message = new JLabel();
    introduction() {
        //create GUI
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setBounds(350, 25, 650, 680);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
        image.setBounds(55, 25, 550, 400);
        frame.add(image);
        frame.getRootPane().setBorder(
                BorderFactory.createMatteBorder(4, 2, 1, 3, Color.white)
        );

        progressBar.setBounds(125, 450, 400, 28);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.DARK_GRAY);
        progressBar.setForeground(Color.gray);
        progressBar.setValue(0);
        frame.add(progressBar);
        message.setBounds(235, 475, 200, 40);
        message.setForeground(Color.white);
        message.setFont(new Font("Kalpurush", Font.BOLD, 20));
        frame.add(message);
        text.setFont(new Font("Kalpurush", Font.PLAIN, 40));
        text.setBounds(180, 510, 600, 75);
        text.setForeground(Color.white);
        frame.add(text);
        running();

    }
    //Loading Bar
    public void running() {
        int i = 0;
        while (i <= 100) {
            try {
                Thread.sleep(75);
                progressBar.setValue(i);
                message.setText("দয়া করে অপেক্ষা করুন");
                i++;
                if (i >= 50) {
                    i = i + 2;
                }
                else if(i >= 75) {
                    i = i + 4;
                }
                if (i == 100) {
                    frame.dispose();
                    TextEditor home_page = new TextEditor();
                    home_page.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}