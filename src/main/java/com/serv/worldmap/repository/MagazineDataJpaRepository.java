package com.serv.worldmap.repository;

import com.serv.worldmap.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface MagazineDataJpaRepository extends JpaRepository<Magazine, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Magazine m WHERE m.id=:id AND m.user.id=:userId")
    int delate(@Param("id") int id, @Param("userId") int userId);

    @Override
    @Transactional
    Magazine save(Magazine magazine);

    @Query("SELECT m FROM Magazine m WHERE m.user.id=:userId ORDER BY m.id DESC")
    List<Magazine> getAll(@Param("userId") int userId);
}
