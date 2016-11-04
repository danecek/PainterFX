/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpainter.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javafxpainter.model.MyElement;
import javafxpainter.model.MyElementId;

public class FacadeServiceDefault implements FacadeService {

    private final Map<MyElementId, MyElement> elems = new HashMap<>();

    @Override
    public void create(MyElement elm) {
        elems.put(elm.getId(), elm);
    }

    @Override
    public Collection<MyElement> all() {
        return elems.values();
    }

}
