package com.example.test1.tabletapp.app;

import java.util.List;

/**
 * Created by Grit on 24.07.2014.
 */
public class ProjectExperimentEntry {
    private List<ExperimentEntry> experimentEntry;
    private Project project;
    public ProjectExperimentEntry(Project project1,List<ExperimentEntry> experimentEntries)

    {
        experimentEntry = experimentEntries;
        project=project1;
    }

    public List<ExperimentEntry> getExperimentEntry() {
        return experimentEntry;
    }

    public Project getProject() {
        return project;
    }
}
