package com.gutotech.eara.config;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gutotech.eara.model.Project;
import com.gutotech.eara.model.StudySession;
import com.gutotech.eara.model.Subject;
import com.gutotech.eara.model.Topic;
import com.gutotech.eara.model.User;
import com.gutotech.eara.service.ProjectService;
import com.gutotech.eara.service.SubjectService;
import com.gutotech.eara.service.TopicService;
import com.gutotech.eara.service.UserService;

@Profile("dev")
@Configuration
public class LoadDatabase implements CommandLineRunner {

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Gustavo Alves", "gustavoalvesb.dealmeida@gmail.com", "123456");
		userService.register(user);

		User user2 = new User("Teste", "test@gmail.com", "123456");
		userService.register(user2);

		Project project = new Project("ENEM");
		project.setUser(user);
		projectService.save(project);

		Project project2 = new Project("Faculdade");
		project2.setUser(user2);
		projectService.save(project2);

		Subject subject1 = new Subject("Matematica", project);
		Subject subject2 = new Subject("Fisica", project);
		Subject subject3 = new Subject("Biologia", project2);
		Subject subject4 = new Subject("Historia", project2);

		subjectService.saveAll(List.of(subject1, subject2, subject3, subject4));

		Topic t1 = new Topic("Adição", subject1);
		Topic t2 = new Topic("Subtração", subject1);
		Topic t3 = new Topic("Multiplicação", subject3);
		subject1.getTopics().addAll(List.of(t1, t2, t3));

		StudySession session1 = new StudySession(null, new Date(), "00:30", 10, 2, null, t1);
		StudySession session2 = new StudySession(null, new Date(), "01:00", 5, 0, null, t1);

		t1.getSessions().addAll(List.of(session1, session2));
		topicService.save(t1);
	}

}
