package spring.core.singleton;

public class SingletonService {

    // 객체를 미리 만들어놔서 하는 안전한 방법으로? 로딩할때
    private static final SingletonService instance =
            new SingletonService();
    // 내부적으로 실행해 여기 인스턴스를 초기화하면서 참조를 넣어놓음
    public static SingletonService getInstance(){
        return instance; // instance 참조 가져올 수 있는 유일한 방법, 생성은 private이어서 못함 외부에서
        // 항상 같은 인스턴스를 반환, private!! 으로 막는것!!
    }

    private SingletonService(){
// public이면 외부에서 계속 생성이 됨. 자바 언어 기본이 매우 중요함
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");

    }
}
