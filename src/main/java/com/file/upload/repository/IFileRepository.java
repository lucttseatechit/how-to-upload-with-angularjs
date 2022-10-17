package com.file.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.upload.entity.File;
@Repository
public interface IFileRepository extends JpaRepository<File, Integer>{

}
