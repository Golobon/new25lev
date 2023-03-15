package Lev_30_lec_10_1;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;
    static class Goods {
        public List<String> names;
    }
    @Override
    public String toString() {
        return goods.names + " " + count +  " " + profit +  " " + secretData;
    }
}
