package com.example.ferhats.recyclecardandrefreshlayoutdenemesi.modal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ferhat's on 27.10.2016.
 */
public class City {
    private String image;
    private String name;
    private String country;
    private String population;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public static List<City> createCityList(){
        City yozgat = new City();
        yozgat.setName("Yozgat");
        yozgat.setCountry("Turkey");
        yozgat.setPopulation("79.611");
        yozgat.setImage("https://s-media-cache-ak0.pinimg.com/736x/47/8e/7b/478e7b01d89ea0060ce7571a932827f9.jpg");

        City istanbul = new City();
        istanbul.setName("İstanbul");
        istanbul.setCountry("Turkey");
        istanbul.setPopulation("14,03 million");
        istanbul.setImage("https://mediap.flypgs.com/awh/400/400//files/sehirlergorsel/istanbul.jpg");

        City sydney = new City();
        sydney.setName("Sydney");
        sydney.setCountry("Australia");
        sydney.setPopulation("4.293 million");
        sydney.setImage("http://i.milliyet.com.tr/GaleriHaber/2014/05/28/fft20_mf4417788.Jpeg");

        City newYorkCity = new City();
        newYorkCity.setName("New York City");
        newYorkCity.setCountry("USA");
        newYorkCity.setPopulation("8.406 million");
        newYorkCity.setImage("https://www.doortodoor.com/wp-content/uploads/2014/04/new-york-city-ny-400x400.jpg");

        City london  = new City();
        london.setName("London");
        london.setCountry("England");
        london.setPopulation("8.63 million");
        london.setImage("https://pbs.twimg.com/profile_images/459398673072267264/oiyrle6-_400x400.jpeg");

        City munich = new City();
        munich.setName("Munich");
        munich.setCountry("Germany");
        munich.setPopulation("1.5 million");
        munich.setImage("http://www.euro-poi.com.cloud.hr/ckfinder/userfiles/images/munich-marienplatz.jpg");

        City paris = new City();
        paris.setName("Paris");
        paris.setCountry("France");
        paris.setPopulation("2.244 million");
        paris.setImage("http://www.tatildeolmak.com/wp-content/uploads/Paris-Eiffel-400x400_c.jpg");

        City tokyo = new City();
        tokyo.setName("Tokyo");
        tokyo.setCountry("Japan");
        tokyo.setPopulation("35 million");
        tokyo.setImage("http://payload.cargocollective.com/1/2/79540/989948/geos%20tokyo%20dil%20okulu%203.jpg");

        List<City>cityList = new LinkedList<>();
        cityList.add(sydney);
        cityList.add(istanbul);
        cityList.add(newYorkCity);
        cityList.add(london);
        cityList.add(munich);
        cityList.add(paris);
        cityList.add(tokyo);
        return cityList;
    }
}
