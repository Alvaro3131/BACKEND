package com.example.sigca.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.example.sigca.entity.Persona;
import com.example.sigca.entity.Usuario;
import com.example.sigca.repository.PersonaRepository;
import com.example.sigca.repository.UsuarioRepository;



@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuariorepository.findByUsername(authentication.getName());
		Persona persona= personaRepository.findById(usuario.getId()).get();
		Map<String, Object> info = new HashMap<>();		
		info.put("id", usuario.getId());
		
		info.put("nombre", persona.getNombre()+" "+persona.getPaterno());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);		
		return accessToken;
	}

}
