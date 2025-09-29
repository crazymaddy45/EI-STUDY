package exercise1.structural.decorator;

interface App {
    void open();
}
class GalleryApp implements App {
    @Override
    public void open() {
        System.out.println("Opening Gallery... Viewing Photos");
    }
}

class NotesApp implements App {
    @Override
    public void open() {
        System.out.println("Opening Notes... Reading Notes");
    }
}

abstract class AppDecorator implements App {
    protected App app;
    public AppDecorator(App app) {
        this.app = app;
    }
    @Override
    public void open() {
        app.open();
    }
}

class AppLocker extends AppDecorator {
    private final String password = "1234"; // made final

    public AppLocker(App app) {
        super(app);
    }

    @Override
    public void open() {
        if (authenticate()) {
            super.open();
        } else {
            System.out.println("Access Denied! Wrong Password ❌");
        }
    }

    private boolean authenticate() {
        String entered = "1234"; 
        return entered.equals(password);
    }
}
public class Decorator {
    public static void main(String[] args) {
        App gallery = new GalleryApp();
        App lockedGallery = new AppLocker(gallery);

        lockedGallery.open();

        App notes = new NotesApp();
        App lockedNotes = new AppLocker(notes);
        lockedNotes.open();
    }
}
