package com.example.kosuriTask.repository;




import com.example.kosuriTask.entity.BusinessDetails;
import com.example.kosuriTask.entity.FinanceTenure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceTenureRepo extends JpaRepository<FinanceTenure, Long> {
    List<FinanceTenure> findByBusinessDetails(BusinessDetails businessDetails);

   // FinanceTenure findByBusinessDetailsContactEmail(String contactEmail);

    FinanceTenure findByBusinessDetailsContactEmailAndFinceTenureId(String contactEmail,Long finceTenureId);
}
