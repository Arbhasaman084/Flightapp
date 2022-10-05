package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.sample.demo.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
	public Books findByBookId(int id);
	
	public Books findTopByOrderByBookIdDesc();
	
	public List<Books> findByAvailability(boolean avail);
	
	@Modifying
	@Query(value = "update books set availability = :avail where bookid = :id", nativeQuery=true)
	public void updateBookAvailability(@Param ("id") int id, @Param("avail") boolean avail);
}
