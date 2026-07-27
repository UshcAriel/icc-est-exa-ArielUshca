package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import models.SoftwareProject;

public class ProjectController {
  public Set<SoftwareProject> filterAndOrderProjects(List<SoftwareProject> projects, double minimunWorkload) {
    Comparator<SoftwareProject> comparator = new Comparator<SoftwareProject>() {

      @Override
      public int compare(SoftwareProject o1, SoftwareProject o2) {
        int workload = Double.compare(o1.getWorkload(), o2.getWorkload());
        if (workload != 0) {
          return workload;
        }

        return o2.getProjectCode().compareToIgnoreCase(o1.getProjectCode());
      }

    };

    Set<SoftwareProject> filter = new TreeSet<>(comparator);

    if (projects == null) {
      return filter;
    }

    for (SoftwareProject i : projects) {
      if (i.getWorkload() >= minimunWorkload) {
        filter.add(i);
      }

    }

    return filter;

  }

  public List<SoftwareProject> classifyAndExtractProjects(List<SoftwareProject> projects, String requestedCategory) {
    Comparator<SoftwareProject> comparator = new Comparator<SoftwareProject>() {

      @Override
      public int compare(SoftwareProject o1, SoftwareProject o2) {
        int priority = Integer.compare(o1.getPriority(), o2.getPriority());
        if (priority != 0) {
          return priority;
        }

        return o2.getProjectCode().compareToIgnoreCase(o1.getProjectCode());
      }

    };

    Map<String, List<String>> order = new HashMap<>();

    order.put("CRITICAL", new ArrayList<>());
    order.put("STANDARD", new ArrayList<>());
    order.put("SMALL", new ArrayList<>());

    for (SoftwareProject i : projects) {
      if (i.getWorkload() >= 900 || i.getPendingTasksMethod() >= 18) {
        order.get("CRITICAL").add(i.getProjectName());
      }
      if (i.getWorkload() >= 350 && order.get("STANDARD").equals(order.get("CRITICAL"))) {
        order.get("STANDARD").add(i.getProjectName());
      } else {
        order.get("SMALL").add(i.getProjectName());
      }

    }

    List<SoftwareProject> orders = new ArrayList(order.put("CRITICAL", new ArrayList<>()));
    return orders;

  }

}
