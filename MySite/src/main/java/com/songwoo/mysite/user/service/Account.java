package com.songwoo.mysite.user.service;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Account implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805529614589956138L;

    private final String username;// userId임
    private final String password;
    private final String name;
    private final String providerId;
    private final String providerName;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private final boolean enabled;

    public Account(String userId, String password, String realUserName, String providerId, String providerName) {
    	this.username = userId;
    	this.password = password;
    	this.name = realUserName;
    	this.providerId = providerId;
    	this.providerName = providerName;
    	this.enabled = true;
    	this.accountNonExpired = true;
    	this.accountNonLocked = true;
    	this.credentialsNonExpired = true;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Deprecated
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getUserId() {
		return username;
	}

	public String getName() {
		return name;
	}

	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getProviderId() {
		return providerId;
	}
	
	public String getProviderName() {
		return providerName;
	}
}
