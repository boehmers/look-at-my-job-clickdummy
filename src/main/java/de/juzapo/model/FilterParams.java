package de.juzapo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel on 19.11.2015.
 */
public class FilterParams {

    private Beruf.Verdienst verdienst;
    private List<Beruf.BerufsTyp> berufsTypen = new ArrayList<>();
    private List<Beruf.Interessen> linkedInteressen = new ArrayList<>();
    private List<Beruf.Fähigkeiten> linkedSkills = new ArrayList<>();
    private List<Beruf.Qualifikationen> linkedQualis = new ArrayList<>();

    public Beruf.Verdienst getVerdienst() {
        return verdienst;
    }

    public List<Beruf.BerufsTyp> getBerufsTypen() {
        return berufsTypen;
    }

    public List<Beruf.Interessen> getLinkedInteressen() {
        return linkedInteressen;
    }

    public List<Beruf.Fähigkeiten> getLinkedSkills() {
        return linkedSkills;
    }

    public List<Beruf.Qualifikationen> getLinkedQualis() {
        return linkedQualis;
    }

    public void setVerdienst(Beruf.Verdienst verdienst) {
        this.verdienst = verdienst;
    }
}
