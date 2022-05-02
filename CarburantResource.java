import java.util.Arrays;
import java.util.LinkedList;

public class CarburantResource extends Resource implements IsCarburant, CategoryExceptionInterface
{
    private CategoryCarburant category;
    private int value;

    public CarburantResource (String id, String name, String category, int value)
    {
        super(id, name);
        this.value = value;

        try
        {
            categoryException(category);
            if (category.equals("chemical"))
            {
                this.category = CategoryCarburant.CHEMICAL;
            }
            else if (category.equals("nuclear"))
            {
                this.category = CategoryCarburant.NUCLEAR;
            }
            else
            {
                this.category = CategoryCarburant.ANTIMATTER;
            }
            carburant_list.add(this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CarburantResource{" +
                "id=" + id +
                ", name=" + name +
                ", minedby=" + minedby +
                ", category=" + category +
                ", value=" + value +
                '}';
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public CategoryCarburant getCategory()
    {
        return category;
    }

    @Override
    public void categoryException(String category) throws Exception
    {
        String[] categories = {"chemical","nuclear","antimatter"};
        boolean contains = Arrays.stream(categories).anyMatch(category :: equals);

        if (!contains)
        {
            throw new Exception("The category does not exist");
        }
    }
}
