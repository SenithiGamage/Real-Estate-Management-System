package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.PropertyDTO;
import edu.icet.ecom.entity.Property;
import edu.icet.ecom.entity.PropertyStatus;
import edu.icet.ecom.entity.PropertyType;
import edu.icet.ecom.repository.PropertyRepository;
import edu.icet.ecom.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO dto) {
        Property property = new Property();
        property.setTitle(dto.getTitle());
        property.setLocation(dto.getLocation());
        property.setAddress(dto.getAddress());
        property.setPropertyType(dto.getPropertyType());
        property.setPrice(dto.getPrice());
        property.setSize(dto.getSize());
        property.setBedrooms(dto.getBedrooms());
        property.setBathrooms(dto.getBathrooms());
        property.setDescription(dto.getDescription());
        property.setStatus(dto.getStatus() != null ? dto.getStatus() : PropertyStatus.AVAILABLE);

        Property saved = propertyRepository.save(property);
        return convertToDTO(saved);
    }

    @Override
    public PropertyDTO getPropertyById(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        return property != null ? convertToDTO(property) : null;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        return propertyRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDTO> getPropertiesByLocation(String location) {
        return propertyRepository.findByLocationContainingIgnoreCase(location).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDTO> getPropertiesByStatus(PropertyStatus status) {
        return propertyRepository.findByStatus(status).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDTO> getPropertiesByPriceRange(Double minPrice, Double maxPrice) {
        return propertyRepository.findByPriceRange(minPrice, maxPrice).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDTO> getPropertiesByType(PropertyType type) {
        return propertyRepository.findAll().stream()
                .filter(p -> p.getPropertyType() == type)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteProperty(Long id) {
        propertyRepository.deleteById(id);
        return true;
    }

    @Override
    public PropertyDTO updateProperty(Long id, PropertyDTO dto) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) return null;

        property.setTitle(dto.getTitle());
        property.setLocation(dto.getLocation());
        property.setPrice(dto.getPrice());
        property.setStatus(dto.getStatus());

        Property updated = propertyRepository.save(property);
        return convertToDTO(updated);
    }

    private PropertyDTO convertToDTO(Property property) {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(property.getId());
        dto.setTitle(property.getTitle());
        dto.setLocation(property.getLocation());
        dto.setAddress(property.getAddress());
        dto.setPropertyType(property.getPropertyType());
        dto.setPrice(property.getPrice());
        dto.setSize(property.getSize());
        dto.setBedrooms(property.getBedrooms());
        dto.setBathrooms(property.getBathrooms());
        dto.setDescription(property.getDescription());
        dto.setStatus(property.getStatus());
        dto.setCreatedAt(property.getCreatedAt());
        if (property.getOwner() != null) dto.setOwnerId(property.getOwner().getId());
        if (property.getAgent() != null) dto.setAgentId(property.getAgent().getId());
        return dto;
    }
    
}
