package edu.tienda.core.persistance.respositories;

import edu.tienda.core.persistance.entities.ClienteEntity;
import edu.tienda.core.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<ClienteEntity, Integer> {

    List<ClienteEntity> findByUsernameLike(String username);
    List<ClienteEntity> findByNombreLike(String nombre);
}
