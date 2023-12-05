package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Message;

public interface IMessageDAO extends JpaRepository<Message, Integer>{
	
	List<Message> findByPartyId(int idParty);
}
