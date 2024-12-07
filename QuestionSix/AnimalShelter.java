package Queues;

/*
 * An Animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" bases.
 * People must adopt either the "oldest" (based on arrival time) of  all animals at the shelter, or they can select
 *  whether they would prefer a dog or cat (and will receive the oldest animal of that type).
 *  They cannot select which specific animal they would like.
 *  Create a data structure to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and DequeueCat.
 */

import java.util.Queue;
import java.util.LinkedList;

public class AnimalShelter {
    private static class Animal {
        String type;
        String name;
        int order;

        public Animal(String type, String name, int order) {
            this.type = type;
            this.name = name;
            this.order = order;
        }

        public String toString() {
            return type + ": " + name + " (Order: " + order + ")";
        }
    }

    private Queue<Animal> dogs;
    private Queue<Animal> cats;
    private int order;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    public void enqueue(String type, String name) {
        Animal animal = new Animal(type, name, order++);
        if (type.equalsIgnoreCase("dog")) {
            dogs.add(animal);
        } else if (type.equalsIgnoreCase("cat")){
            cats.add(animal);
        } else {
            System.out.println("Invalid animal type, only cats and dogs allowed!");
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            System.out.println("No animals available for adoption.");
            return null;
        } else if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
            return dogs.poll();
        } else {
            if (dogs.peek().order < cats.peek().order) {
                return dogs.poll();
            } else {
                return cats.poll();
            }
        }
    }

    public Animal dequeueDog() {
        if (dogs.isEmpty()) {
            System.out.println("No dogs available for adoption.");
            return null;
        }
        return dogs.poll();
    }

    public Animal dequeueCat() {
        if (cats.isEmpty()) {
            System.out.println("No cats available for adoption.");
            return null;
        }
        return cats.poll();
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue("dog", "Spot");
        shelter.enqueue("dog", "Fido");
        shelter.enqueue("dog", "Squire");
        shelter.enqueue("cat", "Demon");
        shelter.enqueue("cat", "Chaos");
        shelter.enqueue("cat", "Gandalf");

        System.out.println("Adopting oldest animal: " + shelter.dequeueAny());
        System.out.println("Adopting a cat: " + shelter.dequeueCat());
        System.out.println("Adopting a dog: " + shelter.dequeueDog());
        System.out.println("Adopting oldest animal: " + shelter.dequeueAny());
        System.out.println("Adopting a cat: " + shelter.dequeueCat());
    }
}

