package sd.wekala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import sd.wekala.model.User;
import sd.wekala.repository.UserRepository;

import java.util.Optional;

public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<User> optional = userRepository.findByUsername(username);
		if (optional.isPresent()) {
			User user = optional.get();
			return new SecurityUserDetails(user.getId(), user.getUsername(), user.getPassword(), user.getRoles());
		}
		throw new UsernameNotFoundException(username);
	}
}
