package ru.vsu.cs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static ru.vsu.cs.util.FileUtils.fillMapWithDuplicatedFiles;
import static ru.vsu.cs.util.FileUtils.getDuplicateFiles;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTextField pathTextField;
    private JButton selectDirectoryButton;
    private JButton showDuplicatesButton;
    private JRadioButton defaultMapRadioButton;
    private JRadioButton customMapRadioButton;
    private JTextArea outputTextArea;

    public FrameMain() {
        super("Application 'no duplicates'");
        this.setContentPane(panelMain);
        this.setBounds(100, 100, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        configureRadioButtons(Arrays.asList(defaultMapRadioButton, customMapRadioButton));

        pathTextField.setText(new File("").getAbsolutePath());
        outputTextArea.setEditable(false);

        selectDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    pathTextField.setText(chooser.getSelectedFile().getPath());
                }
            }
        });

        showDuplicatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextArea.setText("");
                String pathTField = pathTextField.getText();
                Path path = Paths.get(pathTField);
                if (Files.exists(path) && Files.isDirectory(path)) {
                    Map<String, List<String>> duplicateFilesMap;
                    if (defaultMapRadioButton.isSelected()) {
                        duplicateFilesMap = new HashMap<>();
                    }
                    else {
                        duplicateFilesMap = new SimpleHashMap<>(10000);
                    }
                    fillMapWithDuplicatedFiles(new File(pathTField), duplicateFilesMap);
                    List<List<String>> filesList = getDuplicateFiles(duplicateFilesMap);
                    for (List<String> duplicate: filesList) {
                        outputTextArea.append("-------------------------\n");
                        for (String filePath: duplicate) {
                            outputTextArea.append(filePath);
                            outputTextArea.append("\n");
                        }
                        outputTextArea.append("-------------------------\n");
                    }
                }
            }
        });
    }

    private static void configureRadioButtons(List<AbstractButton> btns) {
        ButtonGroup btnGroup = new ButtonGroup();
        for (AbstractButton btn: btns) {
            btnGroup.add(btn);
        }
    }
}
