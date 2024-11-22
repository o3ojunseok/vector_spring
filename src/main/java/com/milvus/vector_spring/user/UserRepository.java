package com.milvus.vector_spring.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "titles")
    User findWithTitlesById(Long id);

    // JPQL로 명시적 페치 조인
//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.titles WHERE u.id = :id")
//    User findUserWithTitles(@Param("id") Long id);
}