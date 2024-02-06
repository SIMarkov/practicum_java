package MushroomTask;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Company {
    private List<Deal> deals;

    public Company() {
        deals = new ArrayList<>();
    }

    public void addDeal(Deal deal) {
        deals.add(deal);
    }

    // Метод за извеждане на всички сделки
    public void printDeals() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        for (Deal deal : deals) {
            String type = getTypeString(deal.getType());
            double quantityKg = deal.getQuantity() / 1000.0;
            String quality = getQualityString(deal.getQuality());
            String dateTime = formatDateTime(deal.getDateTime(), dateFormat);

            System.out.printf("%s, %s, %.3f kg., %s, %s%n",
                    dateTime, type, quantityKg, quality, deal.getPicker());
        }
    }

    private String formatDateTime(String dateTime, SimpleDateFormat dateFormat) {
        try {
            Date date = new SimpleDateFormat("yyyyMMddHHmm").parse(dateTime);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getTypeString(int type) {
        switch (type) {
            case 1:
                return "porcini";
            case 2:
                return "field mushroom";
            case 3:
                return "mushroom well";
            case 4:
                return "chanterelle";
            case 5:
                return "roe mushroom";
            default:
                return "another type of mushroom";
        }
    }

    private String getQualityString(int quality) {
        switch (quality) {
            case 1:
                return "1st";
            case 2:
                return "2nd";
            case 3:
                return "3rd";
            default:
                return "";
        }
    }

    // Метод за извеждане на сортиран списък по качество и тегло
    public void printSortedDeals() {
        Collections.sort(deals, Comparator.comparingInt(Deal::getQuality)
                .thenComparingInt(Deal::getQuantity).reversed());
        printDeals();
    }
    
    // Метод за извеждане на списък с общото количество изкупени гъби по видове
    public void printTotalQuantity() {
        Map<Integer, Double> quantityByType = new HashMap<>();
        for (Deal deal : deals) {
            int type = deal.getType();
            int quantity = deal.getQuantity();
            double quantityKg = quantity / 1000.0;
            quantityByType.put(type, quantityByType.getOrDefault(type, 0.0) + quantityKg);
        }

        List<Map.Entry<Integer, Double>> sortedList = new ArrayList<>(quantityByType.entrySet());
        sortedList.sort(Map.Entry.<Integer, Double>comparingByValue().reversed());

        for (Map.Entry<Integer, Double> entry : sortedList) {
            int type = entry.getKey();
            double quantityKg = entry.getValue();
            String typeString = getTypeString(type);
            System.out.printf("%s: %.3f kg.%n", typeString, quantityKg);
        }
    }
}