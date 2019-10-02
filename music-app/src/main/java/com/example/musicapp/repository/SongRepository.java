package com.example.musicapp.repository;

import com.example.musicapp.models.Song;
import org.springframework.data.repository.CrudRepository;
public interface SongRepository extends CrudRepository<Song, Integer> {
}
