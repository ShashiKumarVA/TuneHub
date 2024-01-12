package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repo.PlaylistRepo;

@Service
public class PlaylistServiceImp implements PlaylistService{
	@Autowired
	PlaylistRepo Repo;
	
	public PlaylistServiceImp(PlaylistRepo repo) {
		super();
		Repo = repo;
	}
	@Override
	public void addPlaylist(Playlist playlist) {
		Repo.save(playlist);
	}
	@Override
	public List<Playlist> fetchAllPlaylist() {
		
		return Repo.findAll();
	}

}
