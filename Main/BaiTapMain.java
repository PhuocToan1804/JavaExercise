package JavaEx.Main;

import JavaEx.Controller.BaiTapController;
import JavaEx.Model.BaiTapModel;
import JavaEx.View.BaiTapView;

import javax.swing.*;

public class BaiTapMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BaiTapView view = new BaiTapView();
            BaiTapModel model = new BaiTapModel();
            BaiTapController controller = new BaiTapController(view, model);
        });
    }
}