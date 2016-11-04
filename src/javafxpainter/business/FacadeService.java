/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter.business;

import java.util.Collection;
import javafxpainter.model.MyElement;

public interface FacadeService {

    static FacadeService service = new FacadeServiceDefault();

    static FacadeService getService() {
        return service;
    }

    void create(MyElement elm);

    Collection<MyElement> all();

}
