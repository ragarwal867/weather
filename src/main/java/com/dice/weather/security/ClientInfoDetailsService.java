package com.dice.weather.security;

import com.dice.weather.entity.ClientInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ClientInfoDetailsService implements UserDetailsService {

    public static Map<String, ClientInfo> clientMap = new HashMap<>();


    @PostConstruct
    public void loadClients() {
        ClientInfo client1 = new ClientInfo("rahul", "agarwal", "USER");
        ClientInfo client2 = new ClientInfo("vibhuti", "narayan", "USER");
        clientMap.put("rahul", client1);
        clientMap.put("vibhuti", client2);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ClientInfo> userInfo = Optional.ofNullable(clientMap.get(username));
        return userInfo.map(ClientInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
