package com.utn.BigCoachNBA.repository;


import com.utn.BigCoachNBA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE dni = ? and pwd = ?", nativeQuery = true)
    User getByUsername(@Param("dni") String dni, @Param("pwd") String password);

    @Procedure(procedureName = "sp_delete_user")
    void deleteUser(@Param("pDni") String dni);

    @Procedure(procedureName = "sp_insert_user")
    void createUser(@Param("pFirstname") String firstName, @Param("pLastname") String lastName, @Param("pDni") String dni, @Param("pPwd") String pwd);

    @Procedure(procedureName = "sp_update_user")
    void updateUser(@Param("pFirstname") String firstName, @Param("pLastname") String lastName, @Param("pDni") String dni, @Param("pPwd") String pwd);
}
