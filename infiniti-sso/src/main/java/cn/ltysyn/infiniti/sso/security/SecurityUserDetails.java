package cn.ltysyn.infiniti.sso.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.ltysyn.infiniti.sso.entity.User;

public class SecurityUserDetails extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3885666548386780221L;
	
	public SecurityUserDetails(User user) {
		// TODO Auto-generated constructor stub
		if (user != null) {
			this.setUsername(user.getUsername());
			this.setPassword(user.getPassword());
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
