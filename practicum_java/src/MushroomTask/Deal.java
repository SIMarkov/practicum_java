package MushroomTask;

class Deal {
    private String dateTime;
    private int type;
    private int quantity;
    private int quality;
    private String picker;

    public Deal(String dateTime, int type, int quantity, int quality, String picker) {
        this.dateTime = dateTime;
        this.type = type;
        this.quantity = quantity;
        this.quality = quality;
        this.picker = picker;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getQuality() {
        return quality;
    }

    public String getPicker() {
        return picker;
    }
}

