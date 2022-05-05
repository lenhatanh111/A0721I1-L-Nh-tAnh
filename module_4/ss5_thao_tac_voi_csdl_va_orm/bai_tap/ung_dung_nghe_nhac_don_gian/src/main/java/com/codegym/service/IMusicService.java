package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    void create(Music music);
    void update(Music music);
    void delete(int id);
    List<Music> findAll();
    Music findById(int id);
}
