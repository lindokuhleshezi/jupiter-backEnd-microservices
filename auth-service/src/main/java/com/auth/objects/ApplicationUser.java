package com.auth.objects;

import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {	
        
	private UUID id;
    private String username;
    private String password;
	private String email;
	private Boolean enabled;	
    private Set<Role> roles;    
    
    public ApplicationUser(ApplicationUser user) {
        this.id = user.id;
        this.email = user.email;
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
        this.roles = user.roles;
    }
    
    
}
