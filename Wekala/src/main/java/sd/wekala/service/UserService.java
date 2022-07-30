package sd.wekala.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import sd.wekala.dto.UserRegistrationDto;
import sd.wekala.model.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}