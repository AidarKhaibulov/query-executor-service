package ru.dbp.queryexecutorservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dbp.queryexecutorservice.models.Band;
import ru.dbp.queryexecutorservice.models.Song;
import ru.dbp.queryexecutorservice.repositories.BandRepository;
import ru.dbp.queryexecutorservice.repositories.SongRepository;

import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final BandRepository bandRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getAllSongsByBandId(Long bandId) {
        return songRepository.findByBandId(bandId);
    }

    public List<Song> getAllSongsByName(String songName) {
        return songRepository.findByTitle(songName);
    }

    public List<Song> findByDurationInSecondsGreaterThan(int duration) {
        return songRepository.findByDurationInSecondsGreaterThan(duration);
    }


    @Transactional()
    public void addRandomSongsTransactional(int numberOfSongs) {
        List<Band> bands = bandRepository.findAll();

        Random random = new Random();

        for (int i = 0; i < numberOfSongs; i++) {
            int randomBandIndex = random.nextInt(bands.size());
            Band randomBand = bands.get(randomBandIndex);

            int randomDurationInSeconds = random.nextInt(600) + 180; // Random duration between 180 and 780 seconds

            Song randomSong = Song.builder()
                    .title("Random Song " + (i + 1))
                    .durationInSeconds(randomDurationInSeconds)
                    .lyrics("Random Lyrics for Song " + (i + 1))
                    .band(randomBand)
                    .build();

            songRepository.save(randomSong);
        }
    }

}
