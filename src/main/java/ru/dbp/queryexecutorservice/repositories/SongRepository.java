package ru.dbp.queryexecutorservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbp.queryexecutorservice.models.Song;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByDurationInSecondsGreaterThan(int duration);

    List<Song> findByBandId(Long bandId);

    List<Song> findByTitle(String title);

}