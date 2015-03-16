package ua.ieromenko.jb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.ieromenko.jb.entity.Blog;
import ua.ieromenko.jb.entity.User;
import ua.ieromenko.jb.repository.BlogRepository;
import ua.ieromenko.jb.repository.UserRepository;

@Service
@Transactional
public class BlogService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
	}

	public void delete(int id) {
		blogRepository.delete(id);
	}

}
