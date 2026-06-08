package edu.icet.ecom.service;

import edu.icet.ecom.dto.PropertyDTO;
import edu.icet.ecom.entity.PropertyStatus;
import edu.icet.ecom.entity.PropertyType;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    PropertyDTO getPropertyById(Long id);
    List<PropertyDTO> getAllProperties();
    List<PropertyDTO> getPropertiesByLocation(String location);
    List<PropertyDTO> getPropertiesByStatus(PropertyStatus status);
    List<PropertyDTO> getPropertiesByPriceRange(Double minPrice, Double maxPrice);
    List<PropertyDTO> getPropertiesByType(PropertyType type);
    boolean deleteProperty(Long id);
    PropertyDTO updateProperty(Long id, PropertyDTO propertyDTO);
}
