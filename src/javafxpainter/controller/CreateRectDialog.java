/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter.controller;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafxpainter.Messages;
import javafxpainter.MyObservable;
import javafxpainter.business.FacadeService;
import javafxpainter.model.MyElementId;
import javafxpainter.model.MyRectangle;

public class CreateRectDialog extends Dialog<ButtonType> {

    ValidationTF xtf = new ValidationTF(this);
    ValidationTF ytf = new ValidationTF(this);
    ValidationTF widthtf = new ValidationTF(this);
    ValidationTF heighttf = new ValidationTF(this);
    Label errorLabel = new Label();
    private double x;
    private double y;
    private double w;
    private double h;

    Node createContent() {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(5));
        gp.setHgap(5);
        gp.setVgap(5);
        gp.add(xtf, 0, 0);
        gp.add(ytf, 0, 1);
        gp.add(widthtf, 0, 2);
        gp.add(heighttf, 0, 3);
        return gp;
    }

    public CreateRectDialog() {
        setTitle(Messages.Create_Rectangle.getMess());
        this.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        getDialogPane().setContent(new VBox(createContent(), errorLabel));
        validate();
    }

    void ok() {
        FacadeService.service.create(new MyRectangle(new MyElementId(0), x, y, w, h));
        MyObservable.INST.changed();
    }

    void execute() {
        Optional<ButtonType> btn = showAndWait();
        if (btn.orElse(ButtonType.CANCEL) == ButtonType.OK) {
            ok();
        }
    }

    void validate() {
        errorLabel.setText("");
        try {
            x = Double.parseDouble(xtf.getText());
            y = Double.parseDouble(ytf.getText());
            h = Double.parseDouble(heighttf.getText());
            w = Double.parseDouble(widthtf.getText());
        } catch (NumberFormatException nfe) {
            errorLabel.setText(Messages.Invalid.getMess());
        }
    }

}
