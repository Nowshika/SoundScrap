package com.soundscrap.soundscrap.service;

import com.soundscrap.soundscrap.model.Song;
import com.soundscrap.soundscrap.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id).orElseThrow();
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Song updateSong(Long id, Song updated) {
        Song existing = songRepository.findById(id).orElseThrow();
        existing.setTitle(updated.getTitle());
        existing.setArtist(updated.getArtist());
        existing.setAlbum(updated.getAlbum());
        existing.setGenre(updated.getGenre());
        existing.setMood(updated.getMood());
        existing.setCoverColor(updated.getCoverColor());
        existing.setDurationSeconds(updated.getDurationSeconds());
        existing.setImageUrl(updated.getImageUrl());
        existing.setAudioUrl(updated.getAudioUrl());
        return songRepository.save(existing);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    public List<Song> getSongsByMood(String mood) {
        return songRepository.findByMoodIgnoreCase(mood);
    }
}