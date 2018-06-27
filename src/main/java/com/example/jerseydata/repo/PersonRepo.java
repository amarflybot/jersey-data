package com.example.jerseydata.repo;

import com.example.jerseydata.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long>{
}
