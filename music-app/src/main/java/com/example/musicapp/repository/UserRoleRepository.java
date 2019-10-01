package com.example.musicapp.repository;
import com.example.musicapp.models.UserRole;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    @Query("FROM UserRole r WHERE r.name = ?1") //
    public UserRole findByName(String name);
}
