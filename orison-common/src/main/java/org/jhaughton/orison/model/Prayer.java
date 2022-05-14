package org.jhaughton.orison.model;

import java.util.UUID;

public class Prayer {
    private String id;
    private String content;
    private Organisation organisation;

    public Prayer(String content, Organisation organisation) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.organisation = organisation;
    }

    public Prayer(String id, String content, Organisation organisation) {
        this.id = id;
        this.content = content;
        this.organisation = organisation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
}
