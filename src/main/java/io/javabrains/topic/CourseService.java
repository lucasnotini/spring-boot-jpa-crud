package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired // uso annotation @Autowired para injetar dependências da interface TopicRepository no objeto automaticamente
    private CourseRepository courseRepository;


//LÊ TODOS - READ - usando método da interface TopicRepository que extende a interface CrudRepository
    public List<Course> getAllCourses(String topicId){

        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

//LÊ INDIVIDUAL
    public Course getCourse(String id){

        return courseRepository.findById(id).orElse(null);

    }

//ADICIONA - CREATE
    public void addCourse(Course course) {

        courseRepository.save(course);
    }

//ATUALIZA - UPDATE
    public void updateCourse(Course course) { //método para substituir conteúdo de topic pelo id passado. Usa loop for

        courseRepository.save(course); //uso mesmo método do addTopic (.save), já que já tenho id no objeto/instancia
    }

// DELETA - DELETE
    public void deleteCourse(String id) { //método para deletar tópico com base no id recebido

        courseRepository.deleteById(id);
    }
}
