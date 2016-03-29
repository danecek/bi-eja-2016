/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.system.data;

import bi.eja.system.model.Zakaznik;
import java.util.Map;
import javax.ejb.Singleton;

@Singleton
public class Zakaznici {

    Map<Long, Zakaznik> zakaznici;

}
