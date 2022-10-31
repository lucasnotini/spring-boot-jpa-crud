package io.javabrains.topic;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,String> { //crio interface que extende a classe CrudRepository e que
                                                                        //criará os 4 métodos CRUD padrão

    //estrutura de métodos necessários em um crud
    //getAllTopics()
    //getTopicGiven(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)

    List<Course> findByTopicId(String topicId); //crio método para pegar Id da classe Topic e por isso passo o nome da Classe e também do atributo Id

}
