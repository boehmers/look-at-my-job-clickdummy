package de.juzapo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Manuel on 19.11.2015.
 */
public class FilterParams {

    private boolean doFilter = false;
    private Beruf.Verdienst verdienst;
    private Set<Beruf.BerufsTyp> berufsTypen = new HashSet<>();
    private Set<Beruf.Interessen> linkedInteressen = new HashSet<>();
    private Set<Beruf.Fähigkeiten> linkedSkills = new HashSet<>();
    private Set<Beruf.Qualifikationen> linkedQualis = new HashSet<>();

    public boolean isDoFilter() {
        return doFilter;
    }

    public void setDoFilter(boolean doFilter) {
        this.doFilter = doFilter;
    }

    public Beruf.Verdienst getVerdienst() {
        return verdienst;
    }

    public void setVerdienst(Beruf.Verdienst verdienst) {
        this.verdienst = verdienst;
    }

    public Set<Beruf.BerufsTyp> getBerufsTypen() {
        return berufsTypen;
    }

    public void setBerufsTypen(Set<Beruf.BerufsTyp> berufsTypen) {
        this.berufsTypen = berufsTypen;
    }

    public Set<Beruf.Interessen> getLinkedInteressen() {
        return linkedInteressen;
    }

    public void setLinkedInteressen(Set<Beruf.Interessen> linkedInteressen) {
        this.linkedInteressen = linkedInteressen;
    }

    public Set<Beruf.Fähigkeiten> getLinkedSkills() {
        return linkedSkills;
    }

    public void setLinkedSkills(Set<Beruf.Fähigkeiten> linkedSkills) {
        this.linkedSkills = linkedSkills;
    }

    public Set<Beruf.Qualifikationen> getLinkedQualis() {
        return linkedQualis;
    }

    public void setLinkedQualis(Set<Beruf.Qualifikationen> linkedQualis) {
        this.linkedQualis = linkedQualis;
    }
}
