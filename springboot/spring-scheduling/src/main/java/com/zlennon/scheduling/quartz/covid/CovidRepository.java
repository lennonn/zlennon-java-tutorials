package com.zlennon.scheduling.quartz.covid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CovidRepository extends JpaRepository<Covid, String> {

}