package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.demo.entity.Members;

@Repository
public interface MemberRepository extends JpaRepository<Members, Integer> {
	public Members findByMemberId(int id);
}
