package com.ormva_tf.sec;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {

    public CustomUserDetails(String username, String password,
         Collection<? extends GrantedAuthority> authorities) {            
        super(username, password, authorities);
    }

    //for example lets add some person data        
    private String cin;

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	
    
}
