package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){ //GET - puxa método getAllTopics da classe TopicController - GET

        return topicService.getAllTopics();

    }

    @RequestMapping("/topics/{id}") //GET - uso token {id} para dizer ao spring que o que entrar ali varia
    public Topic getTopic(@PathVariable String id){ // puxa método getTopic da classe TopicController - GET

        return topicService.getTopic(id);

    }

    @RequestMapping(method= RequestMethod.POST, value = "/topics") //POST na @RequestMapping
    public void addTopic(@RequestBody Topic topic){ // @RequestBody diz ao MVC que corpo JSON deve ser encapsulado em objeto Topic

        topicService.addTopic(topic); // chama método addTopic criado na classe TopicService

    }

    @RequestMapping(method= RequestMethod.PUT, value = "/topics/{id}") //PUT na @RequestMapping
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){ //

        topicService.updateTopic(id, topic); // chama método addTopic criado na classe TopicService

    }

    @RequestMapping(method= RequestMethod.DELETE, value = "/topics/{id}") //DELETE na @RequestMapping
    public void deleteTopic(@PathVariable String id){ // indico com @PathVariable o id para achar o objeto a ser deletado

        topicService.deleteTopic(id); //chamo método da TopicService para deletar topico passando o id
    }

}
