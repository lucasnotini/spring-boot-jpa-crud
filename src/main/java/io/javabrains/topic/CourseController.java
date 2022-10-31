package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){ //GET ALL- puxa método getAllTopics da classe TopicController - GET

        return courseService.getAllCourses(id);

    }

    @RequestMapping("/topics/{topicId}/courses/{id}") //GET - uso token {id} para dizer ao spring que o que entrar ali varia
    public Course getCourse(@PathVariable String id){ // puxa método getTopic da classe TopicController - GET

        return courseService.getCourse(id);

    }

    @RequestMapping(method= RequestMethod.POST, value = "/topics/{topicId}/courses") //POST na @RequestMapping
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){ // @RequestBody diz ao MVC que corpo JSON deve ser encapsulado em objeto Topic

        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course); // chama método addTopic criado na classe TopicService

    }

    @RequestMapping(method= RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}") //PUT na @RequestMapping
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId ,@PathVariable String id){ //
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course); // chama método addTopic criado na classe TopicService

    }

    @RequestMapping(method= RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}") //DELETE na @RequestMapping
    public void deleteCourse(@PathVariable String id){ // indico com @PathVariable o id para achar o objeto a ser deletado

        courseService.deleteCourse(id); //chamo método da TopicService para deletar topico passando o id
    }

}
