package projectFiles;

public class Horse {

    private String name;
    private int age;
    private int speed;
    private int weight;
    private int height;
    private String mood;

    public Horse(String name, int age, int speed, int weight, int height, String mood) {
        this.name = name;
        this.age = age;
        this.speed = speed;
        this.weight = weight;
        this.height = height;
        this.mood = mood;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMood() {
        return this.mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String toString() {
        return "Horse{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ", speed=" + this.speed +
                ", weight=" + this.weight +
                ", height=" + this.height +
                ", mood='" + this.mood + '\'' +
                '}';
    }

    
    public void feed(String food) {
    
        if (!this.mood.equals("hungry")) {
            System.out.println("The horse is not hungry");
            return;
        }
        if (food.equals("hay") || food.equals("grass")) {
            System.out.println("The horse eats " + food);
        } else {
            System.out.println("The horse does not eat " + food);
        }
    }

    public void sleep() {
        if (this.mood.equals("sleepy")) {
            System.out.println("The horse sleeps");
        } else {
            System.out.println("The horse is not sleepy");
        }
    }

    public void play() {
        if (this.mood.equals("bored")) {
            System.out.println("The horse plays");
        } else {
            System.out.println("The horse is not bored");
        }
    }

    // the horse bites human if it is angry
    public void bite(Human human) {
        if (this.mood.equals("angry")) {
            System.out.println("The horse bites " + human.getName());
            // 
            human.setHealth(human.getHealth() - 10);

        } else {
            System.out.println("The horse is not angry");
        }
    }



    



    
    
}
