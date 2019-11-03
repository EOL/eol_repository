package collections;

import java.util.List;


public class Node {

    private String nodeId;
    private int resourceId;
    private String modifiedAt;
    private int parentGNId;
    private boolean preferred;
    private int pageId;
    private String acceptedNameUsageId;
    private String rank;
    private int generatedNodeId;
    private String canonicalName;
    private String scientificName;
    private String italicizedScientificName;
    private String taxonomicStatus;
    private int landMark;
    private String[] referenceIds;
    private String[] identifiers;
    private boolean inUnMappedArea;
    private boolean hasBreadCrumb;
    private String sourceUrl;
    private String[] attributesFromGnParser;
    private String remarks;
    private String attributions;
    private List<Vernacular> vernaculars;


    public String getNodeId() {

        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public int getParentGNId() {
        return parentGNId;
    }

    public void setParentGNId(int parentGNId) {
        this.parentGNId = parentGNId;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getAcceptedNameUsageId() {
        return acceptedNameUsageId;
    }

    public void setAcceptedNameUsageId(String acceptedNameUsageId) {
        this.acceptedNameUsageId = acceptedNameUsageId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getGeneratedNodeId() {
        return generatedNodeId;
    }

    public void setGeneratedNodeId(int generatedNodeId) {
        this.generatedNodeId = generatedNodeId;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getItalicizedScientificName() {
        return italicizedScientificName;
    }

    public void setItalicizedScientificName(String italicizedScientificName) {
        this.italicizedScientificName = italicizedScientificName;
    }

    public String getTaxonomicStatus() {
        return taxonomicStatus;
    }

    public void setTaxonomicStatus(String taxonomicStatus) {
        this.taxonomicStatus = taxonomicStatus;
    }

    public int getLandMark() {
        return landMark;
    }

    public void setLandMark(int landMark) {
        this.landMark = landMark;
    }

    public String[] getReferenceIds() {
        return referenceIds;
    }

    public void setReferenceIds(String[] referenceIds) {
        this.referenceIds = referenceIds;
    }

    public String[] getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(String[] identifiers) {
        this.identifiers = identifiers;
    }

    public boolean isInUnMappedArea() {
        return inUnMappedArea;
    }

    public void setInUnMappedArea(boolean inUnMappedArea) {
        this.inUnMappedArea = inUnMappedArea;
    }

    public boolean isHasBreadCrumb() {
        return hasBreadCrumb;
    }

    public void setHasBreadCrumb(boolean hasBreadCrumb) {
        this.hasBreadCrumb = hasBreadCrumb;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String[] getAttributesFromGnParser() {
        return attributesFromGnParser;
    }

    public void setAttributesFromGnParser(String[] attributesFromGnParser) {
        this.attributesFromGnParser = attributesFromGnParser;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAttributions() {
        return attributions;
    }

    public void setAttributions(String attributions) {
        this.attributions = attributions;
    }

    public List<Vernacular> getVernaculars() {
        return vernaculars;
    }

    public void setVernaculars(List<Vernacular> vernaculars) {
        this.vernaculars = vernaculars;
    }
}
