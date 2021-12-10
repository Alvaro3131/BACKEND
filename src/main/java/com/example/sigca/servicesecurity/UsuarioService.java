package com.example.sigca.servicesecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Rol;
import com.example.sigca.entity.Usuario;
import com.example.sigca.repository.RolRepository;
import com.example.sigca.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuariorepository;
	@Autowired
	private RolRepository repository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuariorepository.findByUsername(username);
        List<Rol> roles= repository.listarRoles(usuario.getId());
		
		
      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();		
		for (int i=0;i<roles.size(); i++) {
			System.out.println();
			authorities.add(new SimpleGrantedAuthority(roles.get(i).nombrerol));
			
		}		
		return new User(usuario.getUsername() ,usuario.getPassword(), usuario.getEstado(), true, 
				true, true, authorities);
	}	
	}
	



