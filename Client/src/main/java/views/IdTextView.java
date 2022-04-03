package views;

import models.Id;

public class IdTextView {
    private final Id id;

    public IdTextView(Id idToDisplay) {
        this.id = idToDisplay;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}