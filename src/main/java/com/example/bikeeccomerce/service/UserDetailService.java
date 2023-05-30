package com.example.bikeeccomerce.service;





import com.example.bikeeccomerce.model.UserRecord;
import com.example.bikeeccomerce.repository.UserRepository;
import com.example.bikeeccomerce.response.LoadUserResponse;
import com.example.bikeeccomerce.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailService( UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public String flag;

    public void setFlag(String flag){
        this.flag=flag;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws RuntimeException {
        LoadUserResponse loadUserResponse = new LoadUserResponse();
        try {
            Optional<UserRecord> clientRecord = userRepository.findByDocument(username);
            if(clientRecord.isPresent() && this.flag=="CLIENT"){
                loadUserResponse.setId(clientRecord.get().getId());
                loadUserResponse.setUsername(clientRecord.get().getDocument());
                loadUserResponse.setPassword(clientRecord.get().getPassword());
                loadUserResponse.setEnable(clientRecord.get().isStatus());
            }
        } catch (RuntimeException e){
            log.error("Authentication Failed. Username or Password not valid.");
        }
        return new UserResponse(loadUserResponse.getId(), loadUserResponse.getUsername(),  loadUserResponse.getPassword(),true, true, true, true, loadUserResponse.isEnable());
    }

}
