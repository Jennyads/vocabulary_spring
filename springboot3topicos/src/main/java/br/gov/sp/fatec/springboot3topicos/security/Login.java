package br.gov.sp.fatec.springboot3topicos.security;

import java.util.List;

public class Login {
    
    private String username;

    private String password;

    private List<String> authorities;
    
    private String token;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<String> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    
}
