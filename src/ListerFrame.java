import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListerFrame extends JFrame{
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel displayPnl;
    JPanel searchPnl;
    JLabel titleLbl;

    JButton directoryBtn;
    JButton quitBtn;

    static JTextArea displayTA;
    JScrollPane scroller;

    static ArrayList<String> allDirects = new ArrayList<>();
    public ListerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTitlePanel();
        mainPnl.add(titlePnl, BorderLayout.NORTH);

        createSearchPanel();
        mainPnl.add(searchPnl, BorderLayout.CENTER);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void createTitlePanel()
    {
        titlePnl = new JPanel();
        titlePnl.setLayout(new GridLayout(2, 1));
        titleLbl = new JLabel("File Lister", JLabel.CENTER);
        titleLbl.setFont(new Font("Courier", Font.BOLD,30));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);


        titlePnl.add(titleLbl);

    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();

        displayPnl.setLayout(new GridLayout(1, 1));
        displayTA = new JTextArea(20, 80);
        displayTA.setEditable(false);
        displayTA.setFont(new Font("Courier New", Font.PLAIN, 12));
        scroller = new JScrollPane(displayTA);

        displayPnl.add(scroller);

    }
    private void createSearchPanel()
    {
        searchPnl = new JPanel();

        searchPnl.setLayout(new GridLayout(2, 1));

        directoryBtn = new JButton("Choose Directory");
        directoryBtn.addActionListener((ActionEvent ae) ->{
            FileFinder finder = new FileFinder(FileChooser.getFile());
            allDirects = finder.find(".txt");
            for (int i = 0; i < allDirects.size(); i++){
                displayTA.append(allDirects.get(i) + "\n");

            }

        });


        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });


        searchPnl.add(directoryBtn);
        searchPnl.add(quitBtn);
    }

}
