package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Party;

public interface IPartyService {
	
	public List<Party> getAllByGame(int idGame);
	
	public Party add(Party party);
	
	public Party getOne(int id);
}