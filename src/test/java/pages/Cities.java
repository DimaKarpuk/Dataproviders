package pages;

public enum Cities {
    MINSK("г. Минск"), GRODNO("г. Гродно"), VITEBSK("г. Витебск"),
    GOMEL("г. Гомель"), BREST("г. Брест"), MOGILEV("г. Могилев");
    public final String description;

    Cities(String description) {
        this.description = description;
    }
}
