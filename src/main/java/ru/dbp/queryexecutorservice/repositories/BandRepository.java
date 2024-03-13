package ru.dbp.queryexecutorservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbp.queryexecutorservice.models.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

}
