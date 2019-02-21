package com.hackerrank.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.github.model.Repo;

public interface RepoRepository extends JpaRepository<Repo, Long> {
}
