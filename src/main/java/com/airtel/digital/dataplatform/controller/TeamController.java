package com.airtel.digital.dataplatform.controller;

import com.airtel.digital.dataplatform.Entity.TeamEntity;
import com.airtel.digital.dataplatform.Service.TeamEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamEntityService teamEntityService;

    @PostMapping
    public TeamEntity addTeam(@RequestBody TeamEntity team){
        return teamEntityService.addTeam(team);
    }
    @GetMapping
    public List<TeamEntity> fetchAllTeams(){
        return teamEntityService.fetchAllTeams();
    }
    @GetMapping(path = "/{id}")
    public  TeamEntity fetchTeamById(@PathVariable("id") Long teamId){
        return teamEntityService.fetchTeamById(teamId);
    }
    @PutMapping("/{id}")
    public TeamEntity updateTeamDetails(@PathVariable("id") Long teamId,@RequestBody TeamEntity team){
       return teamEntityService.updateTeamDetails(teamId,team);
    }
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable("id") Long teamId){
         teamEntityService.deleteTeam(teamId);
         return;
    }
}
