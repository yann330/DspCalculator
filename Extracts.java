import java.util.LinkedList;

public interface Extracts
{
    public void addResource(Resource resource);
    public void getResources();

    // Afficher, pour un extracteur donné, toutes les ressources qu’il peut extraire (vous devez afficher les
    //informations complètes de chaque ressource).

    public static void getResources(String id)
    {
        try
        {
            Extracts e = (Extracts) Building.findBuilding(id);
            e.getResources();
        }
        catch (Exception ex)
        {
            System.out.println("The building is not found");
        }
    }
}
