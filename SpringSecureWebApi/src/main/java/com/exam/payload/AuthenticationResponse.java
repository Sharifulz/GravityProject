package com.exam.payload;

import java.util.Date;

public class AuthenticationResponse {
	
	public String token;
	
	public AuthenticationResponse(String token,Date date){
        this.token=token;
    }
    public AuthenticationResponse(String token){
        this.token=token;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    
}
