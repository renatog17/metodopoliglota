package com.renato.projects.metodopoliglota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.projects.metodopoliglota.domain.Deck;
import com.renato.projects.metodopoliglota.domain.User;

public interface DeckRepository extends JpaRepository<Deck, Long>{

	List<Deck> findDeckByUser(User user);
}
