package com.myPro_Bo.demo.mvc.Repository;


import com.myPro_Bo.demo.mvc.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
