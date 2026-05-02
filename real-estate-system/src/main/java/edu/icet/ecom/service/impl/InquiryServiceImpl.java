package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.InquiryDTO;
import edu.icet.ecom.entity.Inquiry;
import edu.icet.ecom.repository.InquiryRepository;
import edu.icet.ecom.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository inquiryRepository;

    @Override
    public InquiryDTO saveInquiry(InquiryDTO dto) {
        Inquiry inquiry = new Inquiry();
        inquiry.setCustomerName(dto.getCustomerName());
        inquiry.setCustomerEmail(dto.getCustomerEmail());
        inquiry.setMessage(dto.getMessage());
        if (dto.getVisitDate() != null) {
            // Handle visit date if needed
        }
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
    public List<InquiryDTO> getInquiriesByCustomerEmail(String email) {
        return inquiryRepository.findByCustomerEmail(email).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InquiryDTO updateInquiryStatus(Long id, String status) {
        Inquiry inquiry = inquiryRepository.findById(id).orElse(null);
        if (inquiry == null) return null;

        inquiry.setStatus(edu.icet.ecom.entity.InquiryStatus.valueOf(status));
        Inquiry updated = inquiryRepository.save(inquiry);
        return convertToDTO(updated);
    }

    @Override
    public boolean deleteInquiry(Long id) {
        inquiryRepository.deleteById(id);
        return true;
    }

    private InquiryDTO convertToDTO(Inquiry inquiry) {
        InquiryDTO dto = new InquiryDTO();
        dto.setId(inquiry.getId());
        dto.setCustomerName(inquiry.getCustomerName());
        dto.setCustomerEmail(inquiry.getCustomerEmail());
        dto.setMessage(inquiry.getMessage());
        dto.setStatus(inquiry.getStatus().name());
        dto.setCreatedAt(inquiry.getCreatedAt());
        if (inquiry.getProperty() != null) {
            dto.setPropertyId(inquiry.getProperty().getId());
        }
        return dto;
    }
}

