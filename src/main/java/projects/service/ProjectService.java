package projects.service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {
private ProjectDao projectDao = new ProjectDao();
private Object projectId; 
	
	
public Project addProject(Project project) {
	return projectDao.insertProject(project); 
	
}



public List<Project> fetchAllProjects() {
	return projectDao.fetchAllProjects(); 
	
	
}

	public Project fetchProjectById(Integer projectId) {
	return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
			"Project with project ID=" + projectId + " does not exist.")); 
}



	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID=" 
					+ project.getProjectId() + " does not exist."); 
		}
		
	}



	public void deleteProject(Integer projectId) throws SQLException {
		if(!projectDao.deleteProject(projectId)) { 
			throw new DbException("Project with ID =" + projectId + " does not exist.");
		}
		
	} 
}






