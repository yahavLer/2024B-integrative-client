package com.example.a2024b_integrative_client.model.object;


import com.example.a2024b_integrative_client.model.miniappCommand.ObjectId;

import java.util.Date;
import java.util.Map;

public class ObjectBoundary {
    private ObjectId objectId;
    private String type;
    private String alias;
    private Boolean active;
    private Date creationTimestamp;
    private LocationBoundary location;
    private CreatedBy createdBy;
    private Map<String,Object> objectDetails;

    public ObjectBoundary() {}

    public ObjectBoundary(ObjectId objectId, String type, String alias, Boolean active, Date creationTimestamp,
                          LocationBoundary location, CreatedBy createdBy, Map<String, Object> objectDetails) {
        // 1 2
        this.objectId = objectId;
        this.type = type;
        this.alias = alias;
        this.active = active;
        this.creationTimestamp = creationTimestamp;
        // 2- 6
        this.location = location;
        // 7 -8
        this.createdBy = createdBy;
        // 9 -10
        this.objectDetails = objectDetails;

    }


    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public LocationBoundary getLocation() {
        return location;
    }

    public void setLocation(LocationBoundary location) {
        this.location = location;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public Map<String, Object> getObjectDetails() {
        return objectDetails;
    }

    public void setObjectDetails(Map<String, Object> objectDetails) {
        this.objectDetails = objectDetails;
    }

    @Override
    public String toString() {
        return "ObjectBoundary [objectId=" + objectId + ", type=" + type + ", alias=" + alias + ", active=" + active
                + ", creationTimestamp=" + creationTimestamp + ", location=" + location + ", createdBy=" + createdBy
                + ", objectDetails=" + objectDetails + "]";
    }


}
