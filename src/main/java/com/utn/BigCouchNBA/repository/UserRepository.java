package com.utn.BigCouchNBA.repository;


import com.utn.BigCouchNBA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.username = :username and u.password = :pwd")
    public User getByUsername(@Param("username") String username, @Param("pwd") String password);
}
