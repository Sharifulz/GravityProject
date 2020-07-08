package com.exam.payload;

import java.util.Date;

public class AuthenticationResponse {
	
	public String token;
    public Date expireDate;
    
	public AuthenticationResponse(String token,Date date){
        this.token=token;
        this.expireDate=date;
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

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        expireDate = expireDate;
    }

    
}
