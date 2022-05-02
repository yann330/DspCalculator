import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

//Merci a ce site pour l'aide : https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
//ainsi qu'a stackoverflow evidemment, comme toujours... !

public class MainTest
{

    private static final String FILENAME = "data.xml";

    public static void main(String[] args)
    {
        test2();
        //Recipe.getRecipeResources("photo-shifter-lv2");
        //BurnerCentral.getCarburants("fuel-plant");
        //Component.alphabeticComponets();
        //Building.alphabeticBuildings();
        //Extracts.getResources("oil-extractor");
        //Recipe.alphabeticRecipies();
        //Building.getRecipies("energy-exchanger");
    }



    //Test un peu plus avance, on parcourt les composants et on affiche, pour ceux qui sont de type ressource, le ou les extracteur permettant de les recuperer
    public static void test2()
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try
        {
            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File("data.xml"));

            //On parcourt tous les composants du fichier
            NodeList list = doc.getElementsByTagName("items");

            //Pour chaque composant...
            for (int temp = 0; temp < list.getLength(); temp++)
            {
                Node node = list.item(temp);

                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    //On regarde le nom et la categorie du composant
                    Element element = (Element) node;

                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String id = element.getElementsByTagName("id").item(0).getTextContent();

                    // items
                    String category = element.getElementsByTagName("category").item(0).getTextContent();

                    // category components -> Component
                    switch (category)
                    {
                        case "components" -> {
                            NodeList fuel = element.getElementsByTagName("fuel");

                            // there is a tag <fuel> inside the tag <item>
                            if (fuel.getLength() == 1)
                            {
                                // fuel -> Carburant

                                // tag <category> and <value> inside the tag <fuel>
                                String category_fuel = ((Element) fuel.item(0)).getElementsByTagName("category").item(0).getTextContent();
                                String value = ((Element) fuel.item(0)).getElementsByTagName("value").item(0).getTextContent();

                                Carburant carburant = new Carburant(id, name, category_fuel, Integer.parseInt(value));
                            }
                            else
                            {
                                Component component = new Component(id, name);
                            }
                        }

                        // category resource -> Resource
                        case "resource" -> {
                            NodeList mined = element.getElementsByTagName("minedby");

                            // minedby -> add Extractor
                            if (mined.getLength() > 0)
                            {
                                NodeList fuel = element.getElementsByTagName("fuel");

                                // fuel - Carburant Resource
                                if (fuel.getLength() == 1)
                                {
                                    // tag <category> and <value> inside the tag <fuel>
                                    String category_fuel = ((Element) fuel.item(0)).getElementsByTagName("category").item(0).getTextContent();
                                    String value = ((Element) fuel.item(0)).getElementsByTagName("value").item(0).getTextContent();

                                    CarburantResource carburantResource = new CarburantResource(id, name, category_fuel, Integer.parseInt(value));

                                    // add all the exctactors
                                    for (int m = 0; m < mined.getLength(); m++)
                                    {
                                        carburantResource.addExtractor(mined.item(m).getTextContent());
                                    }
                                }
                                else
                                {
                                    Resource resource = new Resource(id, name);

                                    // add all the exctactors
                                    for (int m = 0; m < mined.getLength(); m++)
                                    {
                                        resource.addExtractor(mined.item(m).getTextContent());
                                    }
                                }
                            }
                            else
                            {
                                Resource resource = new Resource(id, name);
                            }
                        }

                        // category buildings -> Building
                        case "buildings" -> {
                            NodeList factory = element.getElementsByTagName("factory");
                            NodeList mining = element.getElementsByTagName("mining");
                            if (factory.getLength() == 1)
                            {
                                String type = element.getElementsByTagName("type").item(0).getTextContent();
                                String usage, speed, drain;
                                if (element.getElementsByTagName("usage").getLength() > 0)
                                {
                                    usage = element.getElementsByTagName("usage").item(0).getTextContent();
                                }
                                else
                                {
                                    usage = "0";
                                }

                                if ((element.getElementsByTagName("drain").getLength() > 0))
                                {
                                    drain = element.getElementsByTagName("drain").item(0).getTextContent();
                                    if (usage.equals("0"))
                                    {
                                        usage = drain;
                                    }
                                }
                                else
                                {
                                    drain = usage;
                                }

                                if (element.getElementsByTagName("speed").getLength() > 0)
                                {
                                    speed = element.getElementsByTagName("speed").item(0).getTextContent();
                                }
                                else
                                {
                                    speed = "0.0";
                                }

                                if (type.equals("electric"))
                                {
                                    // factory (electric) & mining -> Extractor
                                    NodeList mined = element.getElementsByTagName("mining");
                                    if (mined.getLength() > 0)
                                    {
                                        // <speed> inside <mining>
                                        String m_speed = ((Element) mined.item(0)).getElementsByTagName("speed").item(0).getTextContent();

                                        Extractor extractor = new Extractor(id, name, Integer.parseInt(usage),  Double.parseDouble(drain), Double.parseDouble(m_speed));
                                    }

                                    // factory (electric) -> Factory
                                    else
                                    {
                                        Factory factory_el = new Factory(id, name, "electric", Double.parseDouble(speed), Integer.parseInt(usage),  Double.parseDouble(drain));
                                    }
                                }

                                // factory (burner) -> BurnerCentral
                                else if (type.equals("burner"))
                                {
                                    String category_fuel = ((Element) factory.item(0)).getElementsByTagName("category").item(0).getTextContent();
                                    BurnerCentral burnerCentral = new BurnerCentral(id, name, category_fuel, Double.parseDouble(speed));
                                }

                                // factory (electric-production) -> EnergyProductionCentral
                                else if (type.equals("electric-production"))
                                {
                                    String value = ((Element) factory.item(0)).getElementsByTagName("value").item(0).getTextContent();
                                    EnergyProductionCentral energyProductionCentral = new EnergyProductionCentral(id, name, Integer.parseInt(value));
                                }
                            }

                            // mining -> ExtractorNonElectic
                            else if (mining.getLength() > 0)
                            {
                                String speed = ((Element) mining.item(0)).getElementsByTagName("speed").item(0).getTextContent();
                                ExtractorNonElectric extractorNonElectric = new ExtractorNonElectric(id, name, Double.parseDouble(speed));
                            }
                            else
                            {
                                Building building = new Building(id, name);
                            }
                        }
                    }
                }
            }


            NodeList recipes1 = doc.getElementsByTagName("recipes");

            for (int i = 0; i < recipes1.getLength(); i++)
            {
                Node node = recipes1.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;

                    // get id, name, time
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String id = element.getElementsByTagName("id").item(0).getTextContent();

                    String time;
                    if (element.getElementsByTagName("time").getLength() > 0)
                    {
                        time = element.getElementsByTagName("time").item(0).getTextContent();
                    }
                    else
                    {
                        time = "0.0";
                    }

                    NodeList in = element.getElementsByTagName("in");
                    NodeList out = element.getElementsByTagName("out");
                    NodeList producers = element.getElementsByTagName("producers");

                    Recipe recipe = new Recipe(id, name, Double.parseDouble(time));

                    // id of the "in" element is the name of the tad inside <in>
                    if (in.getLength() > 0)
                    {
                        NodeList childList_in = in.item(0).getChildNodes(); // list of tags inside <in>
                        for (int j = 1; j < childList_in.getLength(); j++) // start with 1 because 0 element is just text
                        {
                            Component c = Component.findComponent(childList_in.item(j).getNodeName());
                            if (c != null)
                            {
                                recipe.addIn(c);
                            }
                        }
                    }

                    // id of the "out" element is the name of the tad inside <out>
                    if (out.getLength() > 0)
                    {
                        NodeList childList_out = out.item(0).getChildNodes(); // list of tags inside <out>
                        for (int k = 1; k < childList_out.getLength(); k++) // start with 1 because 0 element is just text
                        {
                            Component c = Component.findComponent(childList_out.item(k).getNodeName());
                            if (c != null)
                            {
                                recipe.addOut(c);
                            }
                        }
                    }

                    for (int e = 0; e < producers.getLength(); e++) // start with 1 because 0 element is just text
                    {
                        Building b = Building.findBuilding(producers.item(e).getTextContent());
                        if (b != null)
                        {
                            recipe.addProducer(b);
                        }
                    }
                }
            }

            Resource.fillExtractors();

        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }

    }
}
