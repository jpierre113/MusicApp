package com.example.musicapp.service;

import com.example.musicapp.models.Song;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public interface SongService {
    public Song createSong(Song song);

    public Iterable<Song> listSongs();

    public HttpStatus deleteById(int songId);
}
