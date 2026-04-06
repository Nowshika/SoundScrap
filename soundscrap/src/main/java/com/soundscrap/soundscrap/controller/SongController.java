package com.soundscrap.soundscrap.controller;

import com.soundscrap.soundscrap.model.Song;
import com.soundscrap.soundscrap.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getSong(@PathVariable Long id) {
        return songService.getSongById(id);
    }

    @GetMapping("/mood/{mood}")
    public List<Song> getByMood(@PathVariable String mood) {
        return songService.getSongsByMood(mood);
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
    }
    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Long id, @RequestBody Song song) {
        return songService.updateSong(id, song);
    }
}