// Step 1: Define the Target Interface (Expected Language Output)
interface EnglishSpeaker {
    void speakEnglish(String message);
}

// Step 2: Implement the Adaptee (Speakers with Different Languages)

// French Speaker
class FrenchSpeaker {
    public void speakFrench(String message) {
        System.out.println("French Speaker: " + message);
    }
}

// Spanish Speaker
class SpanishSpeaker {
    public void speakSpanish(String message) {
        System.out.println("Spanish Speaker: " + message);
    }
}

// Step 3: Create the Adapter Classes (Translators)
// Adapter for French Speaker
class FrenchToEnglishAdapter implements EnglishSpeaker {
    private FrenchSpeaker frenchSpeaker;

    public FrenchToEnglishAdapter(FrenchSpeaker frenchSpeaker) {
        this.frenchSpeaker = frenchSpeaker;
    }

    @Override
    public void speakEnglish(String message) {
        // Translate from French to English
        String translatedMessage = translateFrenchToEnglish(message);
        System.out.println("Translator (French to English): " + translatedMessage);
    }

    private String translateFrenchToEnglish(String message) {
        if (message.equals("Bonjour tout le monde!")) {
            return "Hello everyone!";
        }
        return "[Translation not available for: " + message + "]";
    }
}

// Adapter for Spanish Speaker
class SpanishToEnglishAdapter implements EnglishSpeaker {
    private SpanishSpeaker spanishSpeaker;

    public SpanishToEnglishAdapter(SpanishSpeaker spanishSpeaker) {
        this.spanishSpeaker = spanishSpeaker;
    }

    @Override
    public void speakEnglish(String message) {
        // Translate from Spanish to English
        String translatedMessage = translateSpanishToEnglish(message);
        System.out.println("Translator (Spanish to English): " + translatedMessage);
    }

    private String translateSpanishToEnglish(String message) {
        if (message.equals("Hola a todos!")) {
            return "Hello everyone!";
        }
        return "[Translation not available for: " + message + "]";
    }
}

// Step 4: Client Class (Conference Application)
class ConferenceApp {
    private EnglishSpeaker speaker;

    public void setSpeaker(EnglishSpeaker speaker) {
        this.speaker = speaker;
    }

    public void displayMessage(String message) {
        if (speaker != null) {
            speaker.speakEnglish(message);
        } else {
            System.out.println("No speaker is available.");
        }
    }
}

// Step 5: Testing the Adapter Pattern
public class Adapter {
    public static void main(String[] args) {
        ConferenceApp conferenceApp = new ConferenceApp();

        // Using a French Speaker
        FrenchSpeaker frenchSpeaker = new FrenchSpeaker();
        EnglishSpeaker frenchAdapter = new FrenchToEnglishAdapter(frenchSpeaker);
        conferenceApp.setSpeaker(frenchAdapter);
        conferenceApp.displayMessage("Bonjour tout le monde!");

        // Using a Spanish Speaker
        SpanishSpeaker spanishSpeaker = new SpanishSpeaker();
        EnglishSpeaker spanishAdapter = new SpanishToEnglishAdapter(spanishSpeaker);
        conferenceApp.setSpeaker(spanishAdapter);
        conferenceApp.displayMessage("Hola a todos!");
    }
}
