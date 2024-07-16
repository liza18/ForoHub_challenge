package forohub.forohub.utilidades;

import forohub.forohub.http.request.TopicRequest;
import forohub.forohub.http.response.TopicResponse;
import forohub.forohub.models.Topic;
import forohub.forohub.models.User;
import forohub.forohub.excepciones.UserException;
import forohub.forohub.repositorios.UserRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicUtils {

    @Autowired
    private static UserRepository userRepository;

    public static TopicResponse toTopicResponse(Topic topic){
        return TopicResponse.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .body(topic.getBody())
                .authorName(topic.getAuthor().getUsername())
                .build();
    }

    public static Topic toTopic(TopicRequest topicRequest) throws UserException {
        User user = userRepository.findById(topicRequest.getAuthorId())
                .orElseThrow( () -> new UserException("User not found"));
        return Topic.builder()
                .title(topicRequest.getTitle())
                .body(topicRequest.getBody())
                .author(user)
                .build();
    }

}