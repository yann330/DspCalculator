import java.util.Arrays;
import java.util.LinkedList;

public class BurnerCentral extends Central implements CategoryExceptionInterface {

    private CategoryCarburant category;
    private double speed;

    public BurnerCentral (String id, String name, String category, double speed)
    {
        super(id, name, "burner");
        this.speed = speed;

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
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "BurnerCentral{" +
                "id=" + id +
                ", name=" + name +
//                ", building_products=" + building_products +
//                ", building_resources=" + building_resources +
                ", category=" + category +
                '}';
    }

    public CategoryCarburant getCategory()
    {
        return category;
    }

    public LinkedList<IsCarburant> getCarburants()
    {
        return IsCarburant.getCarburantsByCategory(this.category);
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

    //Afficher, pour une centrale à carburant donnée, tous les carburants qu’elle peut prendre en entrée
    //(vous devez afficher les informations complètes de chaque carburant).

    public static void getCarburants(String id)
    {
        try
        {
            BurnerCentral b = (BurnerCentral) Building.findBuilding(id);
            b.getCarburants();
        }
        catch (Exception ex)
        {
            System.out.println("The building is not found");
        }
    }

}
