package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ItemRepository {

    // 현재는 싱글톤으로 쓰임 : concurrentHashmap으로 쓰기
    private static final Map<Long, Item> store= new HashMap<>();
    private static long sequence = 0L;
    // automic Long타입??

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;

    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    // update에서 dto를 사용하는게 좋음
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());

    }

    public void clearStore(){
        store.clear();
    }
}
