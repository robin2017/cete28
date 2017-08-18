package bean;

/**
 * Created by robin on 2017/8/17.
 */
public class Product {
    private String name;
    private String des;
    private int count;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product(String name, String des, int count) {
        this.name = name;
        this.des = des;
        this.count = count;
    }

    public Product(){}
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", count=" + count +
                '}';
    }
}
