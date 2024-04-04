package JavaEx.Controller;

import JavaEx.Model.BaiTapModel;
import JavaEx.View.BaiTapView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BaiTapController {
    private BaiTapView view;
    private BaiTapModel model;

    public BaiTapController(BaiTapView view, BaiTapModel model) {
        this.view = view;
        this.model = model;
        controller();
    }

    public void controller() {
        view.getOpenMenuItem().addActionListener(e -> {
            int result = view.getFileChooser().showOpenDialog(view);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = view.getFileChooser().getSelectedFile();
                String content = model.loadFile(selectedFile);
                view.getTextArea().setText(content);
            }
        });

        view.getSaveMenuItem().addActionListener(e -> {
            int result = view.getFileChooser().showSaveDialog(view);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = view.getFileChooser().getSelectedFile();
                String text = view.getTextArea().getText();
                model.saveFile(selectedFile, text);
            }
        });

        view.getNewMenuItem().addActionListener(e -> {
            view.getTextArea().setText(""); // Xóa nội dung hiện tại
            view.getFileChooser().setSelectedFile(null); // Đặt file được chọn là null
        });
    }
}