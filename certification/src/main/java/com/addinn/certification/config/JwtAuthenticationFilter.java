package com.addinn.certification.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.addinn.certification.entities.Users;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Value("${jwt.signing-key}")
	private String key;
	@Value("${jwt.prefix-token}")
	private String prefix;
	@Value("${jwt.header}")
	private String header;
	@Value("${jwt.exp-time}")
	private long expirationTime;

	@Override
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {

		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		ObjectMapper mapper = new ObjectMapper();
		Users user = new Users();
		try {
			user = mapper.readValue(request.getInputStream(), Users.class);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		
		Collection<String> authorities = new ArrayList<>();
		authResult.getAuthorities().forEach(role ->

		{

			authorities.add(role.getAuthority());
		});
		String token = Jwts.builder().
				setSubject(authResult.getName()).
				claim("roles", authorities)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // in milliseconds
				.signWith(SignatureAlgorithm.HS512, key.getBytes()).compact();

		response.addHeader(header, prefix + token);

	}
}
