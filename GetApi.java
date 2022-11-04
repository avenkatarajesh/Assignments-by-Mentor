import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

public class GetApi {
    
    public static  void main(String args[]) throws Exception
    {
        String url = " https://reqres.in/api/unknown";
        System.out.println("Firing the Url " +url);
       
        URL obj = new URL(url);
        HttpURLConnection obj1 = (HttpURLConnection) obj.openConnection();
        obj1.setRequestMethod("GET");
        int responseCode = obj1.getResponseCode();
        
        System.out.println("Response Code :" +responseCode);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(obj1.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        //print result
        System.out.println(response.toString());
        
    }
    
}