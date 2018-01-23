package com.crud.tasks.com.crud.tasks.scheduler;

import com.crud.tasks.com.crud.tasks.config.AdminConfig;
import com.crud.tasks.com.crud.tasks.domain.Mail;
import com.crud.tasks.com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    public static final String SUBJECT = "Tasks: Once a day email";

    @Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        StringBuilder sb = new StringBuilder();
        char s = 's';
        if (size > 1) {
            sb.append(s);
        } else {
            sb.deleteCharAt(0);
        }
            simpleEmailService.send(new Mail(
                    adminConfig.getAdminMail(),
                    SUBJECT,
                    "Currently in database you've got " + size + " task" + sb ,
                    "email"
            ));
        }
    }
