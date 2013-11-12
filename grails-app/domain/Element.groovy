/** The element type */
public enum Element {
    WIND(0),
    SOLAR(1),
    FIRE(2),
    EARTH(3),
    STORM(4),
    SHADOW(5),
    FROST(6),
    WATER(7)

    Element(int value) { this.value = value }
    private final int value
    public int value() { return value }
}
