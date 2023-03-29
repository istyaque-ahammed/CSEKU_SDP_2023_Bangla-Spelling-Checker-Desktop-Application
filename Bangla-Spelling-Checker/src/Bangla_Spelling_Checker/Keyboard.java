package Bangla_Spelling_Checker;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Keyboard extends JFrame implements ActionListener {
    char[] ch = { '\u09BE', '\u09BF', '\u09C0', '\u09C1', '\u09C2', '\u09C3', '\u09C7', '\u09C8', '\u09CB', '\u09CC',
            '\u0981' };
    String letter[] = { "ক", "খ", "গ", "ঘ", "ঙ", "চ", "ছ", "জ", "ঝ", "ঞ", "ট", "ঠ", "ড", "ঢ", "ণ", "ত", "থ", "দ", "ধ",
            "ন", "প", "ফ", "ব", "ভ", "ম", "য", "র", "ল", "শ", "ষ", "স", "হ", "ড়", "ঢ়", "য়", "ং", "ঃ", "্‌", "অ", "আ",
            "ই", "ঈ", "উ", "ঊ", "ঋ", "এ", "ঐ", "ও", "ঔ", "Space", "ৎ" };
    String jukto[]= {"ক্ষ","ঙ্ক","ঙ্গ","ঞ্ছ","ঞ্চ","জ্ঞ","ণ্ড","হ্ম","ষ্ণ","ত্ত","ঞ্জ"};
    JButton[] kar = new JButton[11];
    JButton[] juktoButton=new JButton[11];
    JButton[] lbuttons = new JButton[51];
    JLabel[] labels = new JLabel[26];
    Container c;
    JPanel contentPane;
    static String s = "";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Keyboard frame = new Keyboard();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    void buttons() {

        int m = 10, n = 20, o = 50, p = 50;
        Font f = new Font("kalpurush", Font.BOLD, 17);
        for (int j = 0; j < 11; j++) {
            kar[j] = new JButton();
            kar[j].setFont(f);
            kar[j].setBackground(Color.gray);
            kar[j].setText(Character.toString(ch[j]));
            if (j >= 0 && j <= 10) {
                m += 50;
            }
            if (j == 0)
                m = 10;
            kar[j].setBounds(m, n, o, p);
            c.add(kar[j]);
            kar[j].addActionListener(this);

        }

        int left = 10, top = 70, width = 50, height = 50, i;

        for (i = 0; i <= 50; i++) {
            lbuttons[i] = new JButton();
            lbuttons[i].setBackground(Color.gray);
            if (i >= 1 && i <= 10) {
                left += 50;
                top = 70;
            }
            if (i >= 11 && i <= 21) {
                left += 50;
                top = 70 + 50;
            }
            if (i >= 22 && i <= 32) {
                left += 50;
                top = 70 + 50 + 50;
            }

            if (i >= 33 && i <= 43) {
                left += 50;
                top = 70 + 50 + 100;
            }
            if (i >= 44 && i <= 50) {
                left += 50;
                top = 70 + 50 + 150;
            }
            if (i == 0 || i == 11 || i == 22 || i == 33 || i == 44)
                left = 10;
            if (i == 49) {
                width = 150;
                left = 310;
            }
            if (i == 50) {
                left = 260;
                width = 50;
            }
            lbuttons[i].setBounds(left, top, width, height);
            lbuttons[i].setText(letter[i]);
            lbuttons[i].setFont(f);
            c.add(lbuttons[i]);
            lbuttons[i].addActionListener(this);
        }
        int m1 = 10, n1 = 320, o1 = 50, p1 = 50;
        for (int j = 0; j < 11; j++) {
            juktoButton[j] = new JButton();
            juktoButton[j].setFont(f);
            juktoButton[j].setBounds(m1, n1, o1, p1);
            juktoButton[j].setBackground(Color.gray);
            juktoButton[j].setText(jukto[j]);
            if (j >= 0 && j <= 10) {
                m1 += 50;
            }
            c.add(juktoButton[j]);
            juktoButton[j].addActionListener(this);

        }
    }

    public Keyboard() {
        setTitle("KeyBoard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        c = this.getContentPane();
        buttons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i <= 10; i++) {
            if (e.getSource() == kar[i]) {
                s = kar[i].getText();
            }
        }
        for (int i = 0; i < 49; i++) {
            if (e.getSource() == lbuttons[i]) {
                s = letter[i];
            }
        }
        if (e.getSource() == lbuttons[50]) {
            s = letter[50];
        }
        if (e.getSource() == lbuttons[49]) {
            s = " ";
        }
        TextEditor.text.append(s);
    }
}
