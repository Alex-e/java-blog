package ua.ieromenko.jb.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.ieromenko.jb.entity.Blog;
import ua.ieromenko.jb.entity.Item;
import ua.ieromenko.jb.entity.Role;
import ua.ieromenko.jb.entity.User;
import ua.ieromenko.jb.repository.BlogRepository;
import ua.ieromenko.jb.repository.ItemRepository;
import ua.ieromenko.jb.repository.RoleRepository;
import ua.ieromenko.jb.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	@Transactional
	public User findOneWithBlog(int id){
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> list = new ArrayList<>();
		list.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(list);
		
		userRepository.save(user);
	}

	public User findOneWithBlog(String name) {
		User user = userRepository.findByName(name);
		return findOneWithBlog(user.getId());
	}

	public void delete(int id) {
		userRepository.delete(id);
	}

	public User findOne(String username) {
		return userRepository.findByName(username);
	}

}
