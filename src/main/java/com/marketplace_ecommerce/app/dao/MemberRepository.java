package com.marketplace_ecommerce.app.dao;

import com.marketplace_ecommerce.app.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String theEmail);
}
