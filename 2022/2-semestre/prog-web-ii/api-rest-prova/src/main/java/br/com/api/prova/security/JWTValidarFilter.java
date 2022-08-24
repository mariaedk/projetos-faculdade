package br.com.api.prova.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTValidarFilter extends BasicAuthenticationFilter
{
	
	public static final String HEADER_ATRIBUTO = "Authorization";
	public static final String PREFIXO_ATRIBUTO = "Bearer ";

	public JWTValidarFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	// interceptar o cabeçalho da requisição
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// pegar atributo da pagina
		String atributo = request.getHeader(HEADER_ATRIBUTO);
		// verificar se n é nulo
		if (atributo == null)
		{
			chain.doFilter(request, response);
			return;
		}
		if (!atributo.startsWith(PREFIXO_ATRIBUTO))
		{
			chain.doFilter(request, response);
			return;
		}
		
		String token = atributo.replace(PREFIXO_ATRIBUTO, "");
		
		UsernamePasswordAuthenticationToken authToken = getAuthenticationToken(token);
		
		SecurityContextHolder.getContext().setAuthentication(authToken);
		
		chain.doFilter(request, response);
		
	}
	
	// vai ler o token e retornar os dados do usuario para garantir que é valido
	private UsernamePasswordAuthenticationToken getAuthenticationToken(String token)
	{
		// nome do usuario esta no subject
		// usar o algoritmo HMAC512 para desincriptar a senha e pegar o nome do usuario
		String usuario = JWT.require(Algorithm.HMAC512(JWTAutenticarFilter.TOKEN_SENHA)).build().verify(token).getSubject();
		
		if (usuario == null)
		{
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
	}
	

	

}
