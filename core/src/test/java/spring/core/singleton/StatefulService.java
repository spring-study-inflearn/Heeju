package spring.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드, 하지만 개념적으론 stateful하면 안됨
    public void order(String name, int price){
        System.out.println("name = " + name + " price = "+ price);
        this.price = price; // 여기가 문제일 것!, 저장하고 있다. 필드에
    }

    public int getPrice(){
        return price;
    }
}
