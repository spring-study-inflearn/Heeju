package spring.core.singleton;

public class StatefulService {
    // 상태를 유지하는 필드, 하지만 개념적으론 stateful하면 안됨
    // private int price; : 해결 위해 변수 제거
    public int order(String name, int price){
        System.out.println("name = " + name + " price = "+ price);
        // [삭제] this.price = price; // 여기가 문제일 것!, 저장하고 있다. 필드에
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
