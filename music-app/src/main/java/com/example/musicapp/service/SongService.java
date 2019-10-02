package com.example.musicapp.service;

import com.example.musicapp.models.Song;

public interface SongService {
    public Song createSong(Song song);

    public Iterable<Song> listSongs();
}
