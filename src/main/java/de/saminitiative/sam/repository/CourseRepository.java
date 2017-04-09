package de.saminitiative.sam.repository;

import de.saminitiative.sam.domain.Course;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Course entity.
 */
@SuppressWarnings("unused")
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("select distinct course from Course course left join fetch course.impliedSkills left join fetch course.acquirableSkills")
    List<Course> findAllWithEagerRelationships();

    @Query("select course from Course course left join fetch course.impliedSkills left join fetch course.acquirableSkills where course.id =:id")
    Course findOneWithEagerRelationships(@Param("id") Long id);

}
