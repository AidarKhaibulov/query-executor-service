package ru.dbp.queryexecutorservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dbp.queryexecutorservice.models.Band;
import ru.dbp.queryexecutorservice.repositories.BandRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BandService {

    private final BandRepository bandRepository;

    public List<Band> getAllBands() {
        return bandRepository.findAll();
    }

    public Optional<Band> getBandById(Long id) {
        return bandRepository.findById(id);
    }

    public Band createBand(Band band) {
        return bandRepository.save(band);
    }

    public void deleteBand(Long id) {
        bandRepository.deleteById(id);
    }
}
