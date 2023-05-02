package com.aljimez.T27C4.service;



import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aljimez.T27C4.dao.IUsuarioDAO;
import com.aljimez.T27C4.dto.Usuario;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	private IUsuarioDAO iUsuarioDAO;

	public UsuarioDetailsServiceImpl(IUsuarioDAO iUsuarioDAO) {
		this.iUsuarioDAO = iUsuarioDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}
	
	private Collection<GrantedAuthority> mapRolesToAuthorities(String rol){
		ArrayList<String> rols = new ArrayList<String>();
		rols.add(rol);
		return rols.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()); 
		
	}
	
}
