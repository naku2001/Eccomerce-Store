package zw.co.afrosoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zw.co.afrosoft.model.File;


public interface FileRepository extends JpaRepository<File,Long>, JpaSpecificationExecutor<File> {
    Page<File> findAll(Pageable pageable);
    boolean existsFileByName(String name);
}
