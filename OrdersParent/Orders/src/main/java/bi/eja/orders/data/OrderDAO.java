package bi.eja.orders.data;

import bi.eja.orders.model.Order;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderDAO {

    @PersistenceContext
    EntityManager em;

    public Order find(int id) {
        return em.find(Order.class, id);
    }

    public void create(Order o) {
        em.persist(o);
    }

    public void update(Order order) {
        em.merge(order);
    }

    public void delete(Integer orderId) {
        em.remove(find(orderId));
    }

    public List<Order> getOrders() {
        return em.createNamedQuery("getOrders", Order.class).getResultList();
    }

    public List<Order> ordersByCustomer(String customerUsername) {
        return em.createNamedQuery("ordersByCustomer", Order.class).setParameter(1, customerUsername).getResultList();
    }

}
