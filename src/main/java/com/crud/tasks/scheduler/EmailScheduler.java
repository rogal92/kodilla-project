package com.crud.tasks.scheduler;

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

    @Scheduled(cron = "0 0 10 * * *")
    public void oneTaskMail() {

        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you've got 1 task",
                "email"
        ));
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        if (size == 1) {
            oneTaskMail();
        } else {
            simpleEmailService.send(new Mail(
                    adminConfig.getAdminMail(),
                    SUBJECT,
                    "Currently in database you've got " + size + " tasks",
                    "email"
            ));
        }
        @Scheduled(fixedDelay = "10000");
    }
}