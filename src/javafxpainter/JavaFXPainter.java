/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter;

import javafxpainter.controller.PainterMenubar;
import javafxpainter.controller.PainterToolBar;
import javafxpainter.view.ElementTable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafxpainter.view.GraphPane;

/**
 *
 * @author Administrator
 */
public class JavaFXPainter extends Application {

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox(new PainterMenubar(), new PainterToolBar(),
                new SplitPane(new ScrollPane(new GraphPane()), new ElementTable()));

        Scene scene = new Scene(root, 1000, 600);

        primaryStage.setTitle(Messages.Painter.getMess());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void stop() throws Exception {
    }

    public static void main(String[] args) {
        Application.launch(JavaFXPainter.class, args);
    }

}
