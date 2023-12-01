package ma.ehtp.project.repository;

import ma.ehtp.project.entities.ObjectData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<ObjectData, Long> {
}