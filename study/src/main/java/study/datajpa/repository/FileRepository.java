package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.FfFile;

public interface FileRepository extends JpaRepository<FfFile, Long> {

    @Query("select ff from FfFile ff " +
            "left join fetch ff.fileInfo " +
            "where ff.id = :id")
    FfFile findFileInternal(@Param("id") Long id);
}
