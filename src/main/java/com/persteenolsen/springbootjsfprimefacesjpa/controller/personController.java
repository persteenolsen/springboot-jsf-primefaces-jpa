package com.persteenolsen.springbootjsfprimefacesjpa.controller;

import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
//import javax.faces.flow.FlowScoped;
//import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import javax.annotation.PostConstruct;

import com.persteenolsen.springbootjsfprimefacesjpa.model.PersonEntity;

import com.persteenolsen.springbootjsfprimefacesjpa.service.PersonService;

//import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "personController")
@SessionScoped
//@ViewScoped
//@FlowScoped(value = "personController")
public class personController implements Serializable {

    
  private static final long serialVersionUID = 1L;

    // An instance of the Service Layer
    @Inject
    private PersonService personRService;

    // Not used
     private List<PersonEntity> persons;

    //  An instance of the Model Entity used by updating a Person
    private PersonEntity selectedPerson;

    // An instance of the Model Entity
    private PersonEntity person = new PersonEntity();
    

    // Class members
    private String name;
    private String email;
    private Integer age;

    // Just a constructor
    public personController() {
    }


    // Get the memory info for the Java Virtuel Machine
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

   // The method is used by updating a Person
    public PersonEntity getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(PersonEntity selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
    
    // Get and Set methods goes here
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


   // Not used, but fine for initializing data
   @PostConstruct
   public void init() {
      persons = personRService.getAll();

   }

    // Not used
    public List<PersonEntity> getPersons() {
      return persons;
    }

   // This method is used for listing the persons
    public List<PersonEntity> getAllPersons() {

        return personRService.getAll();

    }

    // Creating a Person
    // ViewScoped will do here but SessionScoped is used because of Update!
    public String createPerson() {

        this.person.setName(this.name);
        this.person.setEmail(this.email);
        this.person.setAge(this.age);
       
        personRService.saveOrUpdate(this.person);
        
        // Note: Here the current session is killed and the form will be clear if the user
        // will create more than 1 person in row 
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "listpersons.xhtml?faces-redirect=true";
     }

    // Updating the selected person
    // FlowScoped or SessionScoped will do here!
    public String updatePerson() {
       
       personRService.saveOrUpdate(this.selectedPerson);
       
       return "listpersons.xhtml?faces-redirect=true";
    }

    // Deleting the selected person
    // ViewScoped will do here here!
    public String deletePerson(PersonEntity person) {

        long personid = person.getId();
        personRService.deletePerson(personid);

        return "listpersons.xhtml?faces-redirect=true";

    }
}
