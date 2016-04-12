/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient3;

/**
 *
 * @author danecek
 */
class OrdersException extends Exception {

    public OrdersException(RuntimeException ex) {
        super(ex);
    }
    
}
