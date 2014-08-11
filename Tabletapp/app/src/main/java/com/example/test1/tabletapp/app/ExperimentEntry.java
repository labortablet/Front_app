package com.example.test1.tabletapp.app;

import java.util.List;

/**
 * Created by Grit on 24.07.2014.
 */
public class ExperimentEntry {
    private Experiment experiments;
    private List<Entry> entriesList;
    public ExperimentEntry(Experiment experiment, List<Entry> entries)

    {
        experiments = experiment;
        entriesList = entries;
    }

    public Experiment getExperiments() {
        return experiments;
    }

    public List<Entry> getEntriesList() {
        return entriesList;
    }

}
