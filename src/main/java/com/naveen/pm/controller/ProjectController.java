package com.naveen.pm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naveen.pm.model.Comment;
import com.naveen.pm.model.Project;
import com.naveen.pm.model.Task;
import com.naveen.pm.model.TimeLog;
import com.naveen.pm.service.CommentService;
import com.naveen.pm.service.ProjectService;
import com.naveen.pm.service.TaskService;
import com.naveen.pm.service.TimeLogService;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class ProjectController {

    @Resource
    ProjectService projectService;
    @Resource
    TaskService taskService;
    @Resource
    CommentService commentService;
    @Resource
    TimeLogService timeLogService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/project/list";
    }

    @RequestMapping("/project/list")
    public String list(Model model) {
        List<Project> projects=projectService.getProjectList();
        model.addAttribute("projects", projects);
        return "/project/list";
    }

    @RequestMapping("/project/toAdd")
    public String toAdd() {
        return "project/ProjectAdd";
    }

    @RequestMapping("/project/add")
    public String add(Project project) {
    	projectService.save(project);
    	return "redirect:/project/list";
    }

    @RequestMapping("/project/toEdit")
    public String toEdit(Model model,Long id) {
        Project project=projectService.findProjectById(id);
        model.addAttribute("project", project);
        return "project/projectEdit";
    }

    @RequestMapping("/project/edit")
    public String edit(Project project) {
    	projectService.edit(project);
    	return "redirect:/project/list";
    }
    
    @RequestMapping("/project/toAddTask/{id}")
    public String toAddTask(Model model,@PathVariable long id) {
        Project project=projectService.findProjectById(id);
        model.addAttribute("project", project);
        return "project/addTask";
    }
    
    @RequestMapping("/project/addTask")
    public String addTask(Task task,Model model) {
    	taskService.save(task);
    	model.addAttribute("project", task.getProject());
    	return "project/addTask";
    }
    
   
    @RequestMapping("/project/toAddComment")
    public String toAddComment(Model model,Long id) {
        Task task=taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "project/addComment";
    }

    @RequestMapping("/project/addComment")
    public String addComment(Comment comment,Model model) {
    	commentService.save(comment);
    	model.addAttribute("task", comment.getTask());
    	return "project/addComment";
    }
    
    @RequestMapping("/project/toAddTimeLog")
    public String toAddTimeLog(Model model,Long id) {
        Task task=taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "project/addComment";
    }

    @RequestMapping("/project/addTimeLog")
    public String addTimeLog(TimeLog timeLog,Model model) {
    	timeLogService.save(timeLog);
    	model.addAttribute("task", timeLog.getTask());
    	return "project/addComment";
    }
    
    @RequestMapping("/project/taskEdit")
    public String edit(Task task,Model model) {
    	taskService.edit(task);
    	model.addAttribute("task", task);
    	return "project/addComment";
    }
    
   

    

    @RequestMapping("/project/delete")
    public String delete(Long id) {
    	projectService.delete(id);
    	return "redirect:/project/list";
    }
}
