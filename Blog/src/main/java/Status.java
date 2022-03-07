public enum Status {
    HIDDEN("hidden"),PUBLIC("public"),DRAFT("draft");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
