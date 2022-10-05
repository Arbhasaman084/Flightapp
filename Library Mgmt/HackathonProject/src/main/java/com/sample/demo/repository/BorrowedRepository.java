package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.demo.entity.Borrowed;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Integer> {
	public List<Borrowed> findAllBorrowedByDueDate(LocalDate due);
	
	@Query(value="select * from borrowed where memberid = :id", nativeQuery=true)
	public List<Borrowed> findAllBorrowedByMemberId(@Param("id") int id);
	
	public Borrowed findByMemberId(int id);
	
//	@Query(value = "delete from borrowed where id = :id", nativeQuery=true)
//	public int deleteById(@Param("id") int id);
}
