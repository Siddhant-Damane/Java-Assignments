package com.webonise.service;

import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.webonise.models.UserRole;
import com.webonise.models.Users;

public interface LoginService {

	public User buildUserForAuthentication(Users user, List<GrantedAuthority> authorities);

	public List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) ;

	public void registerUser(Users user) ;
}
