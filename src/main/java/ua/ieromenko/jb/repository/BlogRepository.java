package ua.ieromenko.jb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.ieromenko.jb.entity.Blog;
import ua.ieromenko.jb.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	List<Blog> findByUser(User user);

}
