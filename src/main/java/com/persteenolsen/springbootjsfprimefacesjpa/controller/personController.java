package com.persteenolsen.springbootjsfprimefacesjpa.controller;

import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
//import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import javax.annotation.PostConstruct;
//import javax.faces.view.ViewScoped;

import com.persteenolsen.springbootjsfprimefacesjpa.model.PersonEntity;

//import com.persteenolsen.springbootjsfprimefacesjpa.dao.PersonRepository;
import com.persteenolsen.springbootjsfprimefacesjpa.service.PersonService;

//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;

@Named(value = "personController")
@SessionScoped
//@ViewScoped
public class personController implements Serializable {

    
  private static final long serialVersionUID = 1L;

    
  //@Inject
  //private PersonRepository personRepository;

  @Inject
  private PersonService personRService;

  // Not used
  private List<PersonEntity> persons;


    private PersonEntity selectedPerson;

    private PersonEntity person = new PersonEntity();
    
    private String name;
    private String email;
    private Integer age;

    public personController() {
    }

    public String getJVMHeap(){
        
        int mb = 1024*1024;
        
	    Runtime runtime = Runtime.getRuntime();
	
	    long usedmemory = (runtime.totalMemory() - runtime.freeMemory()) / mb;

	    long freememory = runtime.freeMemory() / mb;

	    long totalmemory = runtime.totalMemory() / mb;
	
	    long maxmemory = runtime.maxMemory() / mb;
	
	    String memoryheapS = "JVM Memory info in MB - Used: " + usedmemory + " Free: " + freememory + " Total: " + totalmemory + " Max: " + maxmemory;

        return memoryheapS;
    }


    public PersonEntity getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(PersonEntity selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


// Not used 
  @PostConstruct
  public void init() {
    persons = personRService.getAll();

   // persons = personRepository.findAll();
  }

  // Not used
  public List<PersonEntity> getPersons() {
    return persons;

    //return persons;
  }

   // This method is used
    public List<PersonEntity> getAllPersons() {

        return personRService.getAll();

        // return personRepository.findAll();
    }


    public String createPerson() {

        this.person.setName(this.name);
        this.person.setEmail(this.email);
        this.person.setAge(this.age);
       
        personRService.saveOrUpdate(this.person);


        //personRepository.save(this.person);

       // return "persons.xhtml?faces-redirect=true";
       return "listpersons.xhtml?faces-redirect=true";

    }

    
    public String updatePerson() {
       
        personRService.saveOrUpdate(this.selectedPerson);
       // personRepository.save(this.selectedPerson);

       // return "persons.xhtml?faces-redirect=true";
       return "listpersons.xhtml?faces-redirect=true";
    }

    public String deletePerson(PersonEntity person) {

        long personid = person.getId();
        personRService.deletePerson(personid);

        //personRepository.delete(person);

       // return "persons.xhtml?faces-redirect=true";
        return "listpersons.xhtml?faces-redirect=true";

    }
}
