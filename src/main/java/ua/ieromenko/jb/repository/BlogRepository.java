package ua.ieromenko.jb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.ieromenko.jb.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
