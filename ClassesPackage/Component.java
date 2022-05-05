package ClassesPackage;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Component
{
    protected String id;
    protected String name;
    private static LinkedList <Component> allComponents = new LinkedList <Component>();

    public Component(String id, String name)
    {
        this.id = id;
        this.name = name;
        allComponents.add(this);
    }

    @Override
    public String toString() {
        return "ClassesPackage.Component{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public static Component findComponent(String id)
    {
        for (Component c : allComponents)
        {
            if (c.id.equals(id))
            {
                return c;
            }
        }
        return null;
    }

    // Custom comparator to compare by name
    public static class ComponentComparator implements Comparator<Component>
    {
        public int compare(Component c1, Component c2)
        {
            return c1.getName().compareTo(c2.getName());
        }
    }

    //Afficher la liste des composants non bâtiment par ordre alphabétique et permettre, pour un composant spécifique, d’obtenir toutes ses informations.

    public static LinkedList<Component> alphabeticComponets()
    {
        LinkedList <Component> notBuildings = new LinkedList <Component>();
        for (Component c : allComponents)
        {
            if (!(c instanceof Building))
            {
                notBuildings.add(c);
            }
        }

        Collections.sort(notBuildings, new ComponentComparator());
        return notBuildings;
    }
}

