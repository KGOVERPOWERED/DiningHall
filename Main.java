import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Main {
    public static void main(String[] args) {

        try{
            String url = "https://menuportal23.dining.rutgers.edu/foodpronet/pickmenu.aspx?locationNum=03&locationName=Livingston+Dining+Commons&dtdate=09/16/2024&activeMeal=Lunch&sName=Rutgers+University+Dining";
            Document doc = Jsoup.connect(url).get();

            Elements fieldsets = doc.select("fieldset");
            for(Element fieldset : fieldsets){
                Element label = fieldset.selectFirst("label");
                if(label!=null){
                    String food = label.text();
                    System.out.println(food);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }



    }
}