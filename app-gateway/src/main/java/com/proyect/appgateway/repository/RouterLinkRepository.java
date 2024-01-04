package com.proyect.appgateway.repository;
import com.proyect.appgateway.models.RouterLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouterLinkRepository extends JpaRepository<RouterLink, Long> {
    @Query("select rl from RouterLink rl where rl.id in (1,4,5)")
    List<RouterLink> getRouterLinkListUser();
}
