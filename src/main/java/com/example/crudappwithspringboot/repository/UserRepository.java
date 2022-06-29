package com.example.crudappwithspringboot.repository;





import com.example.crudappwithspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public void deleteById(long id);

    public User findUserById(long id);
}