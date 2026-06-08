package edu.icet.ecom.service;

import edu.icet.ecom.dto.InquiryDTO;

import java.util.List;

public interface InquiryService {
    InquiryDTO saveInquiry(InquiryDTO inquiryDTO);
    List<InquiryDTO> getAllInquiries();
    List<InquiryDTO> getInquiriesByProperty(Long propertyId);
    List<InquiryDTO> getInquiriesByCustomerEmail(String email);
    InquiryDTO updateInquiryStatus(Long id, String status);
    boolean deleteInquiry(Long id);
}
