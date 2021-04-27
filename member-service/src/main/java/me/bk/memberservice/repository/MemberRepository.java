package me.bk.memberservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.bk.memberservice.domain.Member;

/**
 * @author : byungkyu
 * @date : 2021/04/12
 * @description :
 **/
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByEmail(String email);
}
