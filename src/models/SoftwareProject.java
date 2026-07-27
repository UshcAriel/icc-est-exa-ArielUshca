package models;

public class SoftwareProject {

  private String projectCode;
  private String projectName;
  private ProjectMetrics metrics;
  private int priority;

  public SoftwareProject(String projectCode, String projectName, ProjectMetrics metrics, int priority) {
    this.projectCode = projectCode;
    this.projectName = projectName;
    this.metrics = metrics;
    this.priority = priority;
  }

  public String getProjectCode() {
    return projectCode;
  }

  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public ProjectMetrics getMetrics() {
    return metrics;
  }

  public void setMetrics(ProjectMetrics metrics) {
    this.metrics = metrics;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public double getWorkload() {
    return metrics.getEstimatedHours() * metrics.getTeamSize();
  }

  public int getPendingTasksMethod() {
    return metrics.getPendingTasks();
  }

}
