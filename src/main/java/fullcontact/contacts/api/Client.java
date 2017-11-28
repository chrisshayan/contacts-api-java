package fullcontact.contacts.api;

import java.util.HashMap;

public class Client {
    private HashMap<String, Object> config;
    private Contacts _contacts;
    private OAuth _oauth;
    private Tags _tags;
    private Teams _teams;
    private Webhooks _webhooks;

    public void Client(String clientId, String clientSecret) {
        Client(clientId, clientSecret, null);
    }

    public void Client(String clientId, String clientSecret, HashMap<String, Object> options) {
        this.config = options == null ? new HashMap<>() : options;

        this.config.put("clientId", clientId);
        this.config.put("clientSecret", clientSecret);

        if(!this.config.containsKey("apiUrl")) {
            this.config.put("apiUrl", "https://app.fullcontact.com");
        }

        if(!this.config.containsKey("userAgent")) {
            this.config.put("userAgent", "contacts-api-java");
        }

        this._contacts = new Contacts(this.config);
        this._oauth = new OAuth(this.config);
        this._tags = new Tags(this.config);
        this._teams = new Teams(this.config);
        this._webhooks = new Webhooks(this.config);
    }

    public Contacts getContacts() {
        return this._contacts;
    }

    public OAuth getOAuth() {
        return this._oauth;
    }

    public Tags getTags() {
        return this._tags;
    }

    public Teams getTeams() {
        return this._teams;
    }

    public Webhooks getWebhooks() {
        return this._webhooks;
    }
}