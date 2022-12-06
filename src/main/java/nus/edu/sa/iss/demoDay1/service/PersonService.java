package nus.edu.sa.iss.demoDay1.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import nus.edu.sa.iss.demoDay1.model.Person;
import java.util.List;
import java.util.ArrayList;

@Service
public class PersonService {
    private List<Person> persons = new ArrayList<>();
    public PersonService(){
        persons.add(new Person("Mark", "Kwan"));
        persons.add(new Person("Darryl", "Eddie"));

    }
    public List<Person> getPersons(){
        return this.persons;
    }

    public void addPerson(Person newPerson){
        // persons.add(newPerson);
        persons.add(new Person(newPerson.getFirstName(), newPerson.getLastName()));

    }

    public void removePerson(Person personToDelete){
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personToDelete.getId())).findAny().orElse(null);
        persons.remove(foundPerson);
    }

    public void updatePerson(Person personToUpdate){
        Person foundPerson = persons.stream().filter(p->p.getId().equals(personToUpdate.getId())).findAny().orElse(null);

        Person updatePerson = new Person();
        updatePerson.setId(foundPerson.getId());
        updatePerson.setFirstName(personToUpdate.getFirstName());
        updatePerson.setLastName(personToUpdate.getLastName());
        persons.remove(foundPerson);
        persons.add(updatePerson);
    }
}
