package com.smart.facebookhijack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacebookRepo extends JpaRepository<FacebookUser, Long> {
    // write any query like below
    @Query("select u from FacebookUser u where u.username=?1 and u.password=?2")
    public FacebookUser login(String username, String password);
}
