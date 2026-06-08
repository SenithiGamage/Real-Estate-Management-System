package edu.icet.ecom.repository;

import edu.icet.ecom.entity.Property;
import edu.icet.ecom.entity.PropertyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {
    List<Property> findByLocationContainingIgnoreCase(String location);

    List<Property> findByStatus(PropertyStatus status);

    @Query("SELECT p FROM Property p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Property> findByPriceRange(Double minPrice, Double maxPrice);
}
