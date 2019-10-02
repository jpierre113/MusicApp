package com.example.musicapp.service;

import com.example.musicapp.models.Song;
import com.example.musicapp.repository.SongRepository;
import com.example.musicapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

@Component
public class SongServiceImpl implements SongService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    SongRepository songRepository;

    @Autowired
    SongService songService;

    @Override
    public Song createSong(Song song){
        return songRepository.save(song);
    }

    @Override
    public Iterable<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public HttpStatus deleteById(int songId) {
        songRepository.deleteById(songId);
        return HttpStatus.OK;
    }

}
