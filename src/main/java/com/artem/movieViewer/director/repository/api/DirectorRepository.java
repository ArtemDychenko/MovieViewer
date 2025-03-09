package com.artem.movieViewer.director.repository.api;

import com.artem.movieViewer.director.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    List<Director> findByName(String name);

}
