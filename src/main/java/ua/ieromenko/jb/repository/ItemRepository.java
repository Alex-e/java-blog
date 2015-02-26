package ua.ieromenko.jb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.ieromenko.jb.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
