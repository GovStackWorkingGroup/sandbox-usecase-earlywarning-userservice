package global.govstack.user_service.models;

public enum PermissionEnum {

    BROADCAST(1, "Broadcast"),
    READ(2, "Read");

    private final int id;
    private final String name;

    PermissionEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
