import java.io.*;
import java.security.AlgorithmConstraints;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Main implements Serializable {

    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]);
            System.out.println("animalM1: "+animalM1[i]);
            //System.out.println(animalM1[i].toString());
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal [] animals;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream oos = new ObjectInputStream(bais);
            int u = oos.readInt();
            animals = new Animal[u];
            for (int i = 0; i < u; i++){
                animals[i] = (Animal) oos.readObject();
            }
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return animals;
    }


}
