package by.VIWARR.TheFinalProject.repositories;

import by.VIWARR.TheFinalProject.models.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Integer> {
}
