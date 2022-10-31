package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired // uso annotation @Autowired para injetar dependências da interface TopicRepository no objeto automaticamente
    private TopicRepository topicRepository;


//LÊ TODOS - READ - usando método da interface TopicRepository que extende a interface CrudRepository
    public List<Topic> getAllTopics(){

        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

//LÊ INDIVIDUAL
    public Topic getTopic(String id){

        return topicRepository.findById(id).orElse(null);
    }

//ADICIONA - CREATE
    public void addTopic(Topic topic) {

        topicRepository.save(topic);
    }

//ATUALIZA - UPDATE
    public void updateTopic(String id, Topic topic) { //método para substituir conteúdo de topic pelo id passado. Usa loop for

        topicRepository.save(topic); //uso mesmo método do addTopic (.save), já que já tenho id no objeto/instancia
    }

// DELETA - DELETE
    public void deleteTopic(String id) { //método para deletar tópico com base no id recebido

        topicRepository.deleteById(id);
    }
}
