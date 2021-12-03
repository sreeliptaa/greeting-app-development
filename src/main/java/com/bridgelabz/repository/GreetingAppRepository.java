package com.bridgelabz.repository;

import com.bridgelabz.entity.GreetingAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose : To implement the interface which extends database operations
 *
 * @author SREELIPTA
 * @since 02-12-2021
 */
public interface GreetingAppRepository extends JpaRepository<GreetingAppEntity, Integer> {
}
