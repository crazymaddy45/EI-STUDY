package exercise1.creational.factory;

interface Image {
    void display();
}

class CatImage implements Image {
    @Override
    public void display() {
        System.out.println("🐱 Showing cat image.");
    }
}

class DogImage implements Image {
    @Override
    public void display() {
        System.out.println("🐶 Showing dog image.");
    }
}

class CarImage implements Image {
    @Override
    public void display() {
        System.out.println("🚗 Showing car image.");
    }
}
class ImageFactory {
    public static Image getImage(String type) {
        if (type.equalsIgnoreCase("cat")) {
            return new CatImage();
        } else if (type.equalsIgnoreCase("dog")) {
            return new DogImage();
        } else if (type.equalsIgnoreCase("car")) {
            return new CarImage();
        }
        return null;
    }
}

public class Factory {
    public static void main(String[] args) {
        
        Image img1 = ImageFactory.getImage("cat");
        img1.display();

        Image img2 = ImageFactory.getImage("dog");
        img2.display();

        Image img3 = ImageFactory.getImage("car");
        img3.display();
    }
}
