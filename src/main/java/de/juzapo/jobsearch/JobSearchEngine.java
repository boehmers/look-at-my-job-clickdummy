package de.juzapo.jobsearch;

import de.juzapo.MyUI;
import de.juzapo.model.Beruf;
import de.juzapo.model.FilterParams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Filter;

/**
 * Created by Manuel on 19.11.2015.
 */
public class JobSearchEngine {

    private static ArrayList<Beruf> availableJobs = new ArrayList<Beruf>() {{
        add(MyUI.testData.bauer);
        add(MyUI.testData.informatiker);
        add(MyUI.testData.juzPapa);
    }};

    private JobSearchEngine() {
        // Utility-Class
    }

    public static List<Beruf> getJobByFilterParams(FilterParams filter) {
        if(filter.isDoFilter()) {
            List<Beruf> matchingJobs = new ArrayList<>();
            for (Beruf b : availableJobs) {
                if (!Collections.disjoint(b.getBerufsTypen(), filter.getBerufsTypen()) &&
                        b.getVerdienst().equals(filter.getVerdienst()) &&
                        !Collections.disjoint(b.getLinkedInteressen(), filter.getLinkedInteressen()) &&
                        !Collections.disjoint(b.getLinkedSkills(), filter.getLinkedSkills()) &&
                        !Collections.disjoint(b.getLinkedQualis(), filter.getLinkedQualis())) {
                    matchingJobs.add(b);
                }
            }
            return matchingJobs;
        } else {
            return availableJobs;
        }
    }
}
