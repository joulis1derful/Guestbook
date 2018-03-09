package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConnectionData {
    private String url;
    private String username;
    private String password;
    private String createDb;

    public ConnectionData() {
        super();
    }

    @XmlAttribute
    public String getUrl() {
        return url;
    }

    @XmlAttribute
    public String getUsername() {
        return username;
    }

    @XmlAttribute
    public String getPassword() {
        return password;
    }

    @XmlAttribute
    public String getCreateDb() {
        return createDb;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateDb(String createDb) {
        this.createDb = createDb;
    }
}
