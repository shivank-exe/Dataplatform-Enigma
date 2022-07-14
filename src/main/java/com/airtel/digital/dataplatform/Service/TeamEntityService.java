package com.airtel.digital.dataplatform.Service;

import com.airtel.digital.dataplatform.Entity.TeamEntity;
import com.airtel.digital.dataplatform.Repository.TeamEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TeamEntityService {

    @Autowired
    private TeamEntityRepository teamEntityRepository;

    public TeamEntity addTeam(TeamEntity team) {
        teamEntityRepository.save(team);
        return team;
    }

    public List<TeamEntity> fetchAllTeams() {
        return teamEntityRepository.findAll();
    }

    public TeamEntity fetchTeamById(Long teamId) {
        return  teamEntityRepository.findById(teamId).get();
    }


    public TeamEntity updateTeamDetails(Long teamId,TeamEntity team) {
        TeamEntity present= teamEntityRepository.findById(teamId).get();
         if(team.getTeamName()!=null){
             present.setTeamName(team.getTeamName());
         }

         if(team.getTeamDescription()!=null){
             present.setTeamDescription(team.getTeamDescription());
         }
         teamEntityRepository.save(present);
         return present;
    }

    public void deleteTeam(Long teamId) {
        teamEntityRepository.deleteById(teamId);
    }
}
