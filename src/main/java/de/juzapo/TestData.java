package de.juzapo;

import de.juzapo.model.VideoInterview;
import de.juzapo.model.Beruf;
import de.juzapo.model.User;
import de.juzapo.model.TextInterview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Manuel on 18.11.2015.
 */
public class TestData {

    public User a = new User();
    public User b = new User();

    public TextInterview text1 = new TextInterview();
    public TextInterview text2 = new TextInterview();

    public VideoInterview video1 = new VideoInterview();
    public VideoInterview video2 = new VideoInterview();

    public Beruf bauer;
    public Beruf informatiker;
    public Beruf juzPapa;

    public TestData() {
        ArrayList<String> exampleComments = new ArrayList<>();
        exampleComments.add("Super sache!");
        exampleComments.add("Finde das Interview sehr gut");

        a.setUsername("Paddi");
        a.setEmail("paddi@example.com");
        a.setEvilUnencryptedPassword("paddi");

        b.setUsername("Carsten");
        b.setEmail("carsten@example.com");
        b.setEvilUnencryptedPassword("carsten");

        text1.setUser(a);
        text1.setTitle("Interview mit einem Fachinformatiker");
        text1.setComments(exampleComments);
        text1.setQ1("Ich bin 22 und mache ein duales Studium zum Fachinformatiker.");
        text1.setQ2("Seit 2011.");
        text1.setQ3("Ja sehr! Ich lerne so viele coole Sachen und kann das ganze gleich in der Praxis vertiefen.");
        text1.setQ4("Das Arbeiten in der IT ist sehr flexibel. Außerdem lernt man ständig neues dazu.");
        text1.setQ5("Während an den Hochschulen Semester ist bin ich dort wie jeder andere auch und habe zusätzlich " +
                "noch wöchentlich Anwesenheit in meinem Betrieb.");
        text1.setQ6("Meine Kollegen sind alle für mich da und unterstützen mich. Bei uns wird man auch als Azubi wie ein vollwertiger Mitarbeiter behandelt.");
        text1.setQ7("Durch die Gleitzeitregelung kann ich meine Arbeitszeiten flexibel gestalten. Wie erwähnt arbeite ich auch während des Semesters, aber" +
                "etwas weniger als in den Semesterferien, in welchen ich normale 38-Stunden-Wochen habe.");
        text1.setQ8("Spaß daran ;-)");
        text1.setQ9("Abitur und Interesse an technischen Dingen. Aber auch hier ist der Spaß am Wichtigsten.");

        video1.setUser(a);
        video1.setTitle("Videointerview mit Paddi");
        video1.setComments(exampleComments);
        video1.setVideoUrl("VIDEOOOO");

        text2.setUser(b);
        text2.setTitle("Interview mit einem Jugendzentrums-Papa");
        text2.setComments(exampleComments);
        text2.setQ1("Ich bin 22 und mache ein duales Studium zum Fachinformatiker.");
        text2.setQ2("Seit 2000.");
        text2.setQ3("Ja sehr! Ich lerne so viele coole Sachen und kann das ganze gleich in der Praxis vertiefen.");
        text2.setQ4("Das Arbeiten in der IT ist sehr flexibel. Außerdem lernt man ständig neues dazu.");
        text2.setQ5("Während an den Hochschulen Semester ist bin ich dort wie jeder andere auch und habe zusätzlich " +
                "noch wöchentlich Anwesenheit in meinem Betrieb.");
        text2.setQ6("Meine Kollegen sind alle für mich da und unterstützen mich. Bei uns wird man auch als Azubi wie ein vollwertiger Mitarbeiter behandelt.");
        text2.setQ7("Durch die Gleitzeitregelung kann ich meine Arbeitszeiten flexibel gestalten. Wie erwähnt arbeite ich auch während des Semesters, aber" +
                "etwas weniger als in den Semesterferien, in welchen ich normale 38-Stunden-Wochen habe.");
        text2.setQ8("Spaß daran ;-)");
        text2.setQ9("Abitur und Interesse an technischen Dingen. Aber auch hier ist der Spaß am Wichtigsten.");

        video2.setUser(b);
        video2.setTitle("Videointerview mit Carsten");
        video2.setComments(exampleComments);
        video2.setVideoUrl("VIDEOOOO");

        bauer = new Beruf(Constants.JOB_1, Beruf.Verdienst.GUT, Arrays.asList(Beruf.BerufsTyp.HANDWERK, Beruf.BerufsTyp.STUDIUM),
                Arrays.asList(Beruf.Interessen.TECHNIK), Arrays.asList(Beruf.Fähigkeiten.BELASTBARKEIT_GEISTIG, Beruf.Fähigkeiten.BELASTBARKEIT_KÖRPER,
                Beruf.Fähigkeiten.FLEXIBILITÄT), Arrays.asList(Beruf.Qualifikationen.MITTLERER_SCHULABSCHLUSS));
        informatiker = new Beruf(Constants.JOB_2, Beruf.Verdienst.SEHR_GUT, Arrays.asList(Beruf.BerufsTyp.STUDIUM, Beruf.BerufsTyp.DUALES_STUDIUM,
                Beruf.BerufsTyp.BÜRO), Arrays.asList(Beruf.Interessen.TECHNIK, Beruf.Interessen.IT, Beruf.Interessen.KREATIVES_GESTALTEN,
                Beruf.Interessen.KUNDENKONTAKT), Arrays.asList(Beruf.Fähigkeiten.BELASTBARKEIT_GEISTIG, Beruf.Fähigkeiten.FLEXIBILITÄT, Beruf.Fähigkeiten.KREATIVITÄT),
                Arrays.asList(Beruf.Qualifikationen.ABITUR, Beruf.Qualifikationen.ABGESCHLOSSENE_AUSBILDUNG, Beruf.Qualifikationen.ABGESCHLOSSENES_STUDIUM,
                        Beruf.Qualifikationen.MITTLERER_SCHULABSCHLUSS));
        juzPapa = new Beruf(Constants.JOB_3, Beruf.Verdienst.BEFRIEDIGEND, Arrays.asList(Beruf.BerufsTyp.BÜRO, Beruf.BerufsTyp.SOZIALES_UMFELD),
                Arrays.asList(Beruf.Interessen.KUNDENKONTAKT, Beruf.Interessen.KREATIVES_GESTALTEN), Arrays.asList(Beruf.Fähigkeiten.BELASTBARKEIT_GEISTIG,
                Beruf.Fähigkeiten.EINFÜHLUNGSVERMÖGEN, Beruf.Fähigkeiten.KOMMUNIKATIV), Arrays.asList(Beruf.Qualifikationen.MITTLERER_SCHULABSCHLUSS));
    }
}
