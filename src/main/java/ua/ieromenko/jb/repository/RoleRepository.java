package ua.ieromenko.jb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.ieromenko.jb.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
