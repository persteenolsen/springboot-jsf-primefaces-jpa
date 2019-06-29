package com.persteenolsen.springbootjsfprimefacesjpa.dao;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.persteenolsen.springbootjsfprimefacesjpa.model.PersonEntity;

// This Repository point/mapps the values of the PersonEntity (Model) to the matching 
// columns in Table of the Database 
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
 
}