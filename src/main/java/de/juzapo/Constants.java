package de.juzapo;

import de.juzapo.model.ApiInfo;
import org.scribe.builder.api.FacebookApi;

import java.util.ArrayList;

/**
 * Created by Manuel on 18.11.2015.
 */
public final class Constants {

    public static final String QUESTION_1 = "Wie alt bist du und was ist dein Beruf, oder bist du noch in der Ausbildung?";
    public static final String QUESTION_2 = "Wie lange schon?";
    public static final String QUESTION_3 = "Macht dir dein Job Spaß?";
    public static final String QUESTION_4 = "Was macht dir besonders Spaß? Warum?";
    public static final String QUESTION_5 = "Kannst du deine Arbeit kurz beschreiben?";
    public static final String QUESTION_6 = "Wie ist dein Arbeitsumfeld?";
    public static final String QUESTION_7 = "Wie sieht ein typischer Arbeitstag bei dir aus?";
    public static final String QUESTION_8 = "Welche Fähigkeiten sollte man für deinen Job mitbringen?";
    public static final String QUESTION_9 = "Welche Qualifikation braucht man für deinen Job? Und kannst du uns noch einen Tipp mit auf den Weg geben?";

    public static final String JOB_NO_IDEA = "Keine Ahnung!";
    public static final String JOB_ALL = "Alle!";
    public static final String JOB_1 = "Landwirt/in";
    public static final String JOB_2 = "Informatiker/in";
    public static final String JOB_3 = "Jugendzentrums-Papa/-Mama";

    public static final ApiInfo FACEBOOK_API = new ApiInfo("Facebook",
            FacebookApi.class,
            "943236472433636",
            "//TODO SECRET KEY",
            "https://graph.facebook.com/me");

    public static final ArrayList<String> jobList = new ArrayList<String>() {{
            add(JOB_NO_IDEA); add(JOB_ALL); add(JOB_1); add(JOB_2); add(JOB_3);
    }};


}
