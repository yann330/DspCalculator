package ClassesPackage;

import ClassesPackage.Central;

import java.util.LinkedList;

public class EnergyProductionCentral extends Central implements Extracts {
    private int value;
    private LinkedList<Resource> extractedResources;

    public EnergyProductionCentral(String id, String name, int value) {
        super(id, name, "electric-production");
        this.value = value;
        extractedResources = new LinkedList<Resource>();
    }

    @Override
    public String toString() {
        return "ClassesPackage.EnergyProductionCentral{" +
                "id=" + id +
                ", name=" + name +
                ", value=" + value +
                '}';
    }

    @Override
    public void addResource(Resource resource) {
        extractedResources.add(resource);
    }


    public LinkedList<Resource> getExtractedResources() {
        return (LinkedList<Resource>) extractedResources.clone();
    }
}

