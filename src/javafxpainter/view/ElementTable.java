/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter.view;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxpainter.Messages;
import javafxpainter.MyObservable;
import javafxpainter.business.FacadeService;
import javafxpainter.model.MyElement;

public class ElementTable extends TitledPane implements Observer {
    
    ObservableList<MyElement> elems = FXCollections.observableArrayList();
    
    public ElementTable() {
        MyObservable.INST.addObserver(this);
        setText(Messages.Elements.getMess());
        setContent(createContent());
    }
    
    private Node createContent() {
        TableView tv = new TableView();
        TableColumn<MyElement, Double> xCol = new TableColumn<>("X");
        TableColumn<MyElement, Double> yCol = new TableColumn<>("Y");
        xCol.setCellValueFactory(new PropertyValueFactory<>("refX"));
        yCol.setCellValueFactory(new PropertyValueFactory<>("refY"));
        tv.getColumns().addAll(xCol, yCol);
        tv.setItems(elems);
        return tv;
    }
    
    @Override
    public void update(Observable o, Object o1) {
        Collection<MyElement> all = FacadeService.getService().all();
        System.out.println(all);
        elems.setAll(all);
    }
    
}
