package com.utn.BigCouchNBA.repository;


import com.utn.BigCouchNBA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE dni = ? and pwd = ?", nativeQuery = true)
    User getByUsername(@Param("dni") String dni, @Param("pwd") String password);
}
