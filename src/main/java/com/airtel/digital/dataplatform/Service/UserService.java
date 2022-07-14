package com.airtel.digital.dataplatform.Service;

import com.airtel.digital.dataplatform.Entity.TeamEntity;
import com.airtel.digital.dataplatform.Entity.User;
import com.airtel.digital.dataplatform.Repository.TeamEntityRepository;
import com.airtel.digital.dataplatform.Repository.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamEntityRepository teamEntityRepository;


    public User addUser(Long teamId,User user){
        TeamEntity team= teamEntityRepository.findById(teamId).get();
         user.setTeamEntity(team);
         userRepository.save(user);
        return user;
    }

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }


    public User fetchUserById(Long userId) {
         return userRepository.findById(userId).get();
    }

    public User updateUserDetails(Long userId, User user, Long teamId) {
        User present = userRepository.findById(userId).get();
        if(teamId!=null){
            TeamEntity team= teamEntityRepository.findById(teamId).get();
            present.setTeamEntity(team);
        }
        if(user.getUserEmail()!=null){
            present.setUserEmail(user.getUserEmail());
        }
        if(user.getVisibleOnDatahub()!=null){
            present.setVisibleOnDatahub(user.getVisibleOnDatahub());
        }
        if(user.getUserRole()!=null){
            present.setUserRole(user.getUserRole());
        }
        if (user.getUserAccessDocs()!=null){
            present.setUserAccessDocs(user.getUserAccessDocs());
        }
        userRepository.save(present);
        return present;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
