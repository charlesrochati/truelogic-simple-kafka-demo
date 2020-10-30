package com.truelogic.kafkasample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truelogic.kafkasample.domain.Player;

@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long> {}
