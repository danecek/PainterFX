/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter;

/**
 *
 * @author Administrator
 */
public enum Messages {

    Elements, Graph, Painter, Exit, File, Create_Rectangle, Invalid;

    public String getMess(Object... pars) {
        return name();
    }

}
