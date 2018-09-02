import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(900, 100, 400, 400);

        JTextArea textLook = new JTextArea();


        JTextField textWrite = new JTextField();
        textWrite.setPreferredSize(new Dimension(200,30));

        JButton button = new JButton("Отправить");
        button.setPreferredSize(new Dimension(120,30));
        button.setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(100,40));
        panel.setLayout(new BorderLayout());
        panel.add(textWrite, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);

        add(textLook);

        JScrollPane scroll = new JScrollPane(textLook,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);




        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String text =  textWrite.getText();
                    textLook.append(text + "\n");
                    textWrite.setText("");
            }
        };

        textWrite.addActionListener(listener);
        button.addActionListener(listener);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(Color.GRAY);
            }
        };
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setBackground(Color.ORANGE);
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu mFile = new JMenu("Меню");
        JMenu mEdit = new JMenu("Справка");
        JMenuItem mFileNew = new JMenuItem("Новый");
        JMenuItem mFileExit = new JMenuItem("Выход");
        menuBar.add(mFile);
        menuBar.add(mEdit);
        mFile.add(mFileNew);
        mFile.addSeparator();
        mFile.add(mFileExit);
        mFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setJMenuBar(menuBar);

        setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        new MyWindow();
    }
}
