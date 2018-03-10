package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.controller.TaskController;
import com.crud.tasks.domain.TrelloListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    private TaskController taskController;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url","https://rogal92.github.io/");
        context.setVariable("button","Visit website");
        context.setVariable("admin_name",adminConfig.getAdminName());
        context.setVariable("company_info",companyConfig.getCompanyInfo());
        context.setVariable("preview_message","CRUD app email service");
        context.setVariable("show_button",false);
        context.setVariable("is_friend",true);
        context.setVariable("admin_config",adminConfig);
        context.setVariable("application_functionality",functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTaskListSizeInfoEmail(String message) {

        Context context = new Context();
        context.setVariable("messageTwo",message);
        context.setVariable("tasksSize",taskController.getTasks().size());
        context.setVariable("tasks_url","https://rogal92.github.io/");
        context.setVariable("preview_messageTwo","Daily tasks amount informator");
        context.setVariable("buttonTwo","Visit website");
        context.setVariable("show_buttonTwo",false);
        context.setVariable("admin_nameTwo",adminConfig.getAdminName());
        context.setVariable("is_firendTwo",true);
        context.setVariable("goodBye","Best Regards, \n Staff");

        return templateEngine.process("mail/tasks-amount-mail",context);
    }
}
