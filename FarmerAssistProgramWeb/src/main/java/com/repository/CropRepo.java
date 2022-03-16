package com.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Crop;
 
 
@Repository
public interface CropRepo extends JpaRepository<Crop, Integer>
{
  // @Query("Select c from Crop where c.cropname=?1 order by c.cropname")
  // Crop FindByCropname(String cropname);

}