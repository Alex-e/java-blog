package ua.ieromenko.jb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.ieromenko.jb.entity.Blog;
import ua.ieromenko.jb.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByBlog(Blog blog);
}
