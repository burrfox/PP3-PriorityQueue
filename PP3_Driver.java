import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PP3_Driver {

    


    public static void main(String[] args) throws UnderflowException {

        City[] cities = getCityData();

        long t1Start = System.nanoTime();
        PriorityQueue heap = new PriorityQueue(Arrays.asList(cities));
        long t1End = System.nanoTime();

        int t20 = (int) (cities.length * .2);
        int t10 = (int) (cities.length * .1);
        int i = 1;
        long t2Start = System.nanoTime();
        while (!heap.isEmpty() && i <= t20) {
            City current = (City) heap.poll();
            if (i >= t10)
                System.out.println(current.getName() + " " + current.getPopulation());
            i++;
        }
        long t2End = System.nanoTime();

        long t1Diff = t1End - t1Start;
        double t1Seconds = (t1Diff / 1000000.00) / 1000.00;
        long t2Diff = t2End - t2Start;
        double t2Seconds = (t2Diff / 1000000.00) / 1000.00;
        DecimalFormat f1 = new DecimalFormat("##.000");

        System.out.println("\nN = " + cities.length);
        System.out.println("T1 execution in seconds: " + f1.format(t1Seconds));
        System.out.println("T2 execution in seconds: " + f1.format(t2Seconds));

    }


    public static City[] getCityData() {
        try {
            URL url = new URL("https://parseapi.back4app.com/classes/City?count=1&limit=300000&keys=name,population");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestProperty("X-Parse-Application-Id", "mxsebv4KoWIGkRntXwyzg6c6DhKWQuit8Ry9sHja"); // This is the fake app's application id
            urlConnection.setRequestProperty("X-Parse-Master-Key", "TpO0j3lG2PmEVMXlKYQACoOXKQrL3lwM0HwR9dbH"); // This is the fake app's readonly master key
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                JSONObject data = new JSONObject(stringBuilder.toString()); // Here you have the data that you need
                JSONArray array = data.getJSONArray("results");
                City[] cityArray = new City[array.length()];
                int i = 0;
                for (Object obj : array) {
                    JSONObject jsonObject = (JSONObject) obj;
                    String name = jsonObject.getString("name");
                    int pop = jsonObject.getInt("population");
                    City city = new City(pop, name);
                    cityArray[i] = city;
                    i++;
                }
                return cityArray;
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return null;
    }


}
