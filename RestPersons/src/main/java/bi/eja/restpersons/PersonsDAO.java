/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.restpersons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author danecek
 */
public class PersonsDAO {

    public static final PersonsDAO inst = new PersonsDAO();

    Map<Integer, Person> persons = new HashMap<>();

    private PersonsDAO() {
        create(new Person(1, "Tom"));
    }

    public List<Person> getAll() {
        return new ArrayList<>(persons.values());
    }

    public void create(Person p) {
        persons.put(p.getId(), p);
    }

    public Person get(int id) {
        return persons.get(id);
    }

}
