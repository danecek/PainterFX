/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter.view;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafxpainter.business.FacadeService;
import javafxpainter.model.MyElement;
import javafxpainter.model.MyElementId;
import javafxpainter.model.MyRectangle;

public class Presenter {

    ObservableList<Node> ol;
    private Rectangle newRect;
    static int counter;

    public Presenter(ObservableList<Node> ol) {
        this.ol = ol;
    }

    void createRect(double refX, double refY) {
        newRect = new Rectangle(refX, refY, 1, 1);
        ol.add(newRect);
    }

    Rectangle gr(MyRectangle mr) {
        return new Rectangle(mr.getRefX(), mr.getRefY(), mr.getWidth(), mr.getHeight());
    }

    void finish() {
        FacadeService.getService().create(new MyRectangle(new MyElementId(counter++),
                newRect.getX(), newRect.getY(), newRect.getWidth(),
                newRect.getArcHeight()
        ));
    }

    void setDim(double x, double y) {
        double width = x - newRect.getX();
        double height = y - newRect.getY();
        newRect.setWidth(width);
        newRect.setHeight(height);
    }

    void refresh() {
        ol.clear();
        for (MyElement me : FacadeService.getService().all()) {
            ol.add(gr((MyRectangle) me));
        }
    }

}
