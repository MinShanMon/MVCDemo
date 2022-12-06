package nus.edu.sa.iss.demoDay1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import nus.edu.sa.iss.demoDay1.model.Person;
import nus.edu.sa.iss.demoDay1.service.PersonService;

import java.util.*;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private List<Person> personList = new ArrayList<Person>();
    
    @Autowired
    PersonService personService;

    @Value("${welcome.message}")
    private String welComeMessage;

    // public PersonController(){
    //     personService = new PersonService();
    // }
    @GetMapping(value = {"/", "/home"})
    public String index(Model model){

        model.addAttribute("message", welComeMessage);

        return "home";
    }

    @GetMapping(value = "/testRetrieveAllPerson", produces = "application/json")
    public @ResponseBody List<Person> getAllPersons(){
        personList = personService.getPersons();

        return personList;
    }

    @GetMapping(value = "/list")
    public String personList(Model model){
        personList = personService.getPersons();
        model.addAttribute("persons", personList);
        model.addAttribute("listPerson", "${person.list.header}");
        return "personList";
    }

    @PostMapping(value = "/update")
    public String updatePerson(@ModelAttribute(value="per") Person p, Model model){
        model.addAttribute("per", p);
        return "personEdit";
    }

    @PostMapping(value = "/updatePerson")
    public String updatePersonRecord(@ModelAttribute(value="person") Person p){
        personService.updatePerson(p);
        return "redirect:/persons/list";
    }
}
