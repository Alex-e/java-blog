package ua.ieromenko.jb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.ieromenko.jb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
