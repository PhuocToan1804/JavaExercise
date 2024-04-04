package JavaEx.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class BaiTapView extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    JMenuItem openMenuItem;
    JMenuItem saveMenuItem;
    JMenuItem newMenuItem;
    public BaiTapView() {
        setTitle("Text Editor");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setupMenuBar();
        setupTextArea();

        setVisible(true);
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        newMenuItem = new JMenuItem("New");

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(newMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        fileChooser = new JFileChooser();
    }

    private void setupTextArea() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JMenuItem getNewMenuItem() { return newMenuItem; }
    public JTextArea getTextArea() {
        return textArea;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public JMenuItem getOpenMenuItem() {
        return openMenuItem;
    }
}