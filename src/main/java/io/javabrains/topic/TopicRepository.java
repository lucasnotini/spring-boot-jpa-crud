package io.javabrains.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,String> { //crio interface que extende a classe CrudRepository e que
                                                                        //criará os 4 métodos CRUD padrão

    //estrutura de métodos necessários em um crud
    //getAllTopics()
    //getTopicGiven(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)



}
