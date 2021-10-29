package com.marketplace_ecommerce.app.dao;

import com.marketplace_ecommerce.app.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author j0975
 */
@Repository
@CrossOrigin("http://localhost:4200")
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String theEmail);
}
