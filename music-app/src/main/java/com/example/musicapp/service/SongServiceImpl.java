package com.example.musicapp.service;

import com.example.musicapp.models.Song;
import com.example.musicapp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public Song createSong(Song song){
        return songRepository.save(song);
    }

    @Override
    public Iterable<Song> listSongs(){
        return songRepository.findAll();
    }

}
