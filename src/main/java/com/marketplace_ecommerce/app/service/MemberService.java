package com.marketplace_ecommerce.app.service;

import com.marketplace_ecommerce.app.entity.Member;

/**
 * @author j0975
 */
public interface MemberService {
    Member findByEmail(String theEmail);

    void save(Member member);
}
