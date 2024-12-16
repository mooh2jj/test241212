package com.dsg.test241212.repository;

import com.dsg.test241212.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
