package learn.api.com.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("Java", "Java Framework", "Learn Java Framework"),
					new Topic("Selenium", "Selenium Framework", "Learn Selenium Framework"),
					new Topic("SpringBoot", "Spring Boot Framework", "Learn Spring Boot Framework")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getID().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getID().equalsIgnoreCase(id)) {
				topics.set(i, topic);
			}

		}

	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getID().equals(id));
		
	}

}
