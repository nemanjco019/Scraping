package scrap.websites;

import java.util.List;

public interface IProcessor {

    List<Product> process() throws InterruptedException;

}
