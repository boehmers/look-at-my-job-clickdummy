package de.juzapo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel on 19.11.2015.
 */
public class Beruf {

    private String bezeichnung;
    private Verdienst verdienst;
    private List<BerufsTyp> berufsTypen = new ArrayList<>();
    private List<Interessen> linkedInteressen = new ArrayList<>();
    private List<Fähigkeiten> linkedSkills = new ArrayList<>();
    private List<Qualifikationen> linkedQualis = new ArrayList<>();

    public Beruf(String bezeichnung, Verdienst verdienst, List<BerufsTyp> berufsTypen,
                 List<Interessen> linkedInteressen, List<Fähigkeiten> linkedSkills, List<Qualifikationen> linkedQualis) {
        this.bezeichnung = bezeichnung;
        this.verdienst = verdienst;
        this.berufsTypen = berufsTypen;
        this.linkedInteressen = linkedInteressen;
        this.linkedSkills = linkedSkills;
        this.linkedQualis = linkedQualis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public Verdienst getVerdienst() {
        return verdienst;
    }

    public List<BerufsTyp> getBerufsTypen() {
        return berufsTypen;
    }

    public List<Interessen> getLinkedInteressen() {
        return linkedInteressen;
    }

    public List<Fähigkeiten> getLinkedSkills() {
        return linkedSkills;
    }

    public List<Qualifikationen> getLinkedQualis() {
        return linkedQualis;
    }

    @Override
    public String toString() {
        return bezeichnung;
    }

    public enum Verdienst {
        SEHR_GUT {
            @Override
            public String toString() {
                return "Sehr gut";
            }
        }, GUT {
            @Override
            public String toString() {
                return "Gut";
            }
        }, BEFRIEDIGEND {
            @Override
            public String toString() {
                return "Befriedigend";
            }
        }
    }

    public enum BerufsTyp {
        BÜRO {
            @Override
            public String toString() {
                return "Büro";
            }
        }, HANDWERK {
            @Override
            public String toString() {
                return "Handwerk";
            }
        }, LIEFERANT {
            @Override
            public String toString() {
                return "Lieferant";
            }
        }, SOZIALES_UMFELD {
            @Override
            public String toString() {
                return "Soziales";
            }
        }, LEHRER {
            @Override
            public String toString() {
                return "Lehrer";
            }
        }, STUDIUM {
            @Override
            public String toString() {
                return "Studium";
            }
        }, DUALES_STUDIUM {
            @Override
            public String toString() {
                return "Dualstudium";
            }
        }, GASTRONOMIE {
            @Override
            public String toString() {
                return "Gastronomie";
            }
        }
    }

    public enum Interessen {
        KUNDENKONTAKT {
            @Override
            public String toString() {
                return "Kundenkontakt";
            }
        }, FLEXIBLE_ZEITEN {
            @Override
            public String toString() {
                return "Zeitenflexibilität";
            }
        }, TECHNIK {
            @Override
            public String toString() {
                return "Technik";
            }
        }, IT {
            @Override
            public String toString() {
                return "IT";
            }
        }, KREATIVES_GESTALTEN {
            @Override
            public String toString() {
                return "Kreatives";
            }
        }
    }

    public enum Fähigkeiten {
        KREATIVITÄT {
            @Override
            public String toString() {
                return "Kreativität";
            }
        }, FLEXIBILITÄT {
            @Override
            public String toString() {
                return "Flexibilität";
            }
        }, BELASTBARKEIT_GEISTIG {
            @Override
            public String toString() {
                return "Stressresistenz";
            }
        }, BELASTBARKEIT_KÖRPER {
            @Override
            public String toString() {
                return "Belastbarkeit";
            }
        }, KOMMUNIKATIV {
            @Override
            public String toString() {
                return "Kommunikationsfähigkeiten";
            }
        }, EINFÜHLUNGSVERMÖGEN {
            @Override
            public String toString() {
                return "Einfühlungsvermögen";
            }
        },
    }

    public enum Qualifikationen {
        ABITUR {
            @Override
            public String toString() {
                return "Abitur";
            }
        }, MITTLERER_SCHULABSCHLUSS {
            @Override
            public String toString() {
                return "Realschulabschluss";
            }
        }, HAUPTSCHULABSCHLUSS {
            @Override
            public String toString() {
                return "Hauptschulabschluss";
            }
        }, ABGESCHLOSSENES_STUDIUM {
            @Override
            public String toString() {
                return "Studium (abgeschlossen)";
            }
        }, ABGESCHLOSSENE_AUSBILDUNG {
            @Override
            public String toString() {
                return "Ausbildung (abgeschlossen)";
            }
        },
    }
}
