package Chapter1_Stack_and_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanmuXu
 * @date 2019/8/7 23:12
 */
public class cat_dog_queue {
    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }
        public String getPetType(){
            return this.type;
        }
    }

    public static class Dog extends Pet{
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }

    /**
     * 定义一个PetEnterQueue类，保存pet类型和进入队列时间
     */
    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return this.pet;
        }

        public long getCount(){
            return this.count;
        }

        public String getEnterPetType(){
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue{
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public DogCatQueue(){
            this.dogQ = new LinkedList<PetEnterQueue>();
            this.catQ = new LinkedList<PetEnterQueue>();
            this.count = 0;
        }

        public void add(Pet pet){
            if (pet.getPetType().equals("dog")){
                this.dogQ.add(new PetEnterQueue(pet, this.count++));
            }else if (pet.getPetType().equals("cat")){
                this.catQ.add(new PetEnterQueue(pet, this.count++));
            }else {
                throw new RuntimeException("err, not dog or cat");
            }
        }

        public Pet pollAll(){
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                    return this.dogQ.poll().getPet();
                }else {
                    return this.catQ.poll().getPet();
                }
            }else if (!this.dogQ.isEmpty()){
                return this.dogQ.poll().getPet();
            }else if (!this.catQ.isEmpty()){
                return this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("err, queue is empty");
            }
        }

        public Dog pollDog(){
            if (!this.isDogQueueEmpty()){
                return (Dog)this.dogQ.poll().getPet();
            }else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        public Cat pollCat(){
            if (!this.isCatQueueEmpty()){
                return (Cat)this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("Cat queue is empty!");
            }
        }

        public boolean isEmpty(){
            return this.catQ.isEmpty() && this.dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty(){
            return this.catQ.isEmpty();
        }

        public boolean isDogQueueEmpty(){
            return this.dogQ.isEmpty();
        }
    }

    public static void main(String[] args){
        DogCatQueue dogCatQueue = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        dogCatQueue.add(dog1);
        dogCatQueue.add(dog2);
        dogCatQueue.add(cat1);
        dogCatQueue.add(dog3);
        dogCatQueue.add(cat2);
        dogCatQueue.add(cat3);

        while (!dogCatQueue.isCatQueueEmpty()){
            System.out.println(dogCatQueue.pollCat().getPetType());
        }

        System.out.println("--------");

        dogCatQueue.add(dog1);
        dogCatQueue.add(dog2);
        dogCatQueue.add(cat1);
        dogCatQueue.add(dog3);
        dogCatQueue.add(cat2);
        dogCatQueue.add(cat3);

        while (!dogCatQueue.isDogQueueEmpty()){
            System.out.println(dogCatQueue.pollDog().getPetType());
        }

        System.out.println("--------");

        dogCatQueue.add(dog1);
        dogCatQueue.add(dog2);
        dogCatQueue.add(cat1);
        dogCatQueue.add(dog3);
        dogCatQueue.add(cat2);
        dogCatQueue.add(cat3);

        while (!dogCatQueue.isEmpty()){
            System.out.println(dogCatQueue.pollAll().getPetType());
        }
    }
}
