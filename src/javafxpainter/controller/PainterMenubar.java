/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter.controller;

import javafx.scene.control.MenuBar;

/**
 *
 * @author Administrator
 */
public class PainterMenubar extends MenuBar {

    public PainterMenubar() {
        super(new FileMenu());
    }
    
}
