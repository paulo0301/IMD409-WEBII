package com.jeanlima.springmvcdatajpaapp.repository;

import com.jeanlima.springmvcdatajpaapp.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Integer> {

}
