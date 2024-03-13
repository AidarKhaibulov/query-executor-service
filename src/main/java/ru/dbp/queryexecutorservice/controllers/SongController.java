package ru.dbp.queryexecutorservice.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dbp.queryexecutorservice.models.Song;
import ru.dbp.queryexecutorservice.services.SongService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/longerThan")
    public ResponseEntity<List<Song>> getSongsLongerThan() {
        return ResponseEntity.ok(songService.findByDurationInSecondsGreaterThan(300));
    }

    @GetMapping()
    public ResponseEntity<List<Song>> getAll() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/getAllSongsByBandId/{bandId}")
    public ResponseEntity<List<Song>> getAllByBandId(@PathVariable Long bandId) {
        return ResponseEntity.ok(songService.getAllSongsByBandId(bandId));
    }

    @GetMapping("/getAllSongsByName/{songName}")
    public ResponseEntity<List<Song>> getAllSongByName(@PathVariable String songName) {
        return ResponseEntity.ok(songService.getAllSongsByName(songName));
    }


    @PostMapping("/addRandomSongsTransactional/{numberOfSongs}")
    public ResponseEntity<String> addRandomSongsTransactional(@PathVariable int numberOfSongs) {
        songService.addRandomSongsTransactional(numberOfSongs);
        return ResponseEntity.ok(numberOfSongs + " random songs added successfully.");
    }

}