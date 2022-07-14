package com.airtel.digital.dataplatform.Repository;


import com.airtel.digital.dataplatform.Entity.User;
import com.google.gson.Gson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
