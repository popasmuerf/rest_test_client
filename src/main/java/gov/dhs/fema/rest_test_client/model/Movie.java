package gov.dhs.fema.rest_test_client.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movie", propOrder = { "imdbId", "title" })
public class Movie {
 
    protected String imdbId;
    protected String title;
 
    // getters and setters
}