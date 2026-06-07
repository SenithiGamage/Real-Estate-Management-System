package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.InquiryDTO;
import edu.icet.ecom.entity.Inquiry;
import edu.icet.ecom.entity.Property;
import edu.icet.ecom.repository.InquiryRepository;
import edu.icet.ecom.repository.PropertyRepository;
import edu.icet.ecom.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository inquiryRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public InquiryDTO saveInquiry(InquiryDTO dto) {
        Property property = propertyRepository.findById(dto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found: " + dto.getPropertyId()));

        Inquiry inquiry = new Inquiry();
        inquiry.setProperty(property);
        inquiry.setCustomerName(dto.getCustomerName());
        inquiry.setCustomerEmail(dto.getCustomerEmail());
        inquiry.setMessage(dto.getMessage());
        inquiry.setStatus(dto.getStatus() != null ?
                edu.icet.ecom.entity.InquiryStatus.valueOf(dto.getStatus()) :
                edu.icet.ecom.entity.InquiryStatus.PENDING);

        Inquiry saved = inquiryRepository.save(inquiry);
        return convertToDTO(saved);
    }

    @Override
    public List<InquiryDTO> getAllInquiries() {
        return inquiryRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InquiryDTO> getInquiriesByProperty(Long propertyId) {
        return inquiryRepository.findByPropertyId(propertyId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InquiryDTO updateInquiryStatus(Long id, String status) {
        Inquiry inquiry = inquiryRepository.findById(id).orElse(null);
        if (inquiry == null) return null;

        inquiry.setStatus(edu.icet.ecom.entity.InquiryStatus.valueOf(status));
        return convertToDTO(inquiryRepository.save(inquiry));
    }

    @Override
    public boolean deleteInquiry(Long id) {
        inquiryRepository.deleteById(id);
        return true;
    }

    private InquiryDTO convertToDTO(Inquiry inquiry) {
        InquiryDTO dto = new InquiryDTO();
        dto.setId(inquiry.getId());
        dto.setPropertyId(inquiry.getProperty().getId());
        dto.setCustomerName(inquiry.getCustomerName());
        dto.setCustomerEmail(inquiry.getCustomerEmail());
        dto.setMessage(inquiry.getMessage());
        dto.setStatus(inquiry.getStatus().name());
        dto.setCreatedAt(inquiry.getCreatedAt());
        return dto;
    }

    @Override
    public List<InquiryDTO> getInquiriesByCustomerEmail(String email) {
        return List.of();
    }
}