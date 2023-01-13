
package com.portfolio.gn.Repository;

import com.portfolio.gn.Entity.Hys;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHys extends JpaRepository<Hys, Integer> {
    Optional<Hys> findByNombreHys(String nombreHys);
    List<Hys> findAllByTipo(String tipo);
    public boolean existsByNombreHys(String nombreHys);
}
