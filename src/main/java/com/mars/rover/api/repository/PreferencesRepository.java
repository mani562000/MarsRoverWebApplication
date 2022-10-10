package com.mars.rover.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mars.rover.api.dto.HomeDto;

public interface PreferencesRepository extends JpaRepository<HomeDto, Long> {

  
  HomeDto findByUserId(Long userId);

}