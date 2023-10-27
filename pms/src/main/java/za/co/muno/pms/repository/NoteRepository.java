package za.co.muno.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.muno.pms.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
