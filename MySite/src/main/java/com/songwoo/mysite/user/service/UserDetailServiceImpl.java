package com.songwoo.mysite.user.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//org.springframework.security.authentication.ProviderManager

import com.skt.o2oband.provider.dao.ProviderMapper;


public class UserDetailServiceImpl implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

	@Autowired
	private ProviderMapper providerMapper;

    private boolean enableAuthorities = true;
//    private boolean enableGroups;

	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {


		ProviderVO providerVO = new ProviderVO(); 
		providerVO.setUserId(userId);
		Account account = providerMapper.loginProvider(providerVO);



		if (account == null) {
			throw new UsernameNotFoundException("UserId["+userId+"] not found");
		}

		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
        if (enableAuthorities) {
            dbAuthsSet.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        account.setAuthorities(dbAuthsSet);
		return account;
	}
}
