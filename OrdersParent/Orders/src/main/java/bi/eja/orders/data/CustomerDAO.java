package bi.eja.orders.data;

import bi.eja.orders.model.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Named
public class CustomerDAO {

    @PersistenceContext
    EntityManager em;

    public Customer find(String username) {
        return em.find(Customer.class, username);
    }

    public List<Customer> getCustomers() {
        TypedQuery<Customer> tq = em.createNamedQuery("getCustomers", Customer.class);
        return tq.getResultList();
    }

    public void createCustomer(Customer cust) {
        em.persist(cust);
    }

    public void delete(String customerUsername) {
        em.remove(find(customerUsername));
    }

    public boolean exists(String customerUsername) {
        return find(customerUsername)!=null;
    }

}
