package client.api;

import client.models.Bond;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** Класс Api - связь с сервером по HTTP протоколу*/
/** Cвязь с сервером по HTTP*/
public class Api {
    private final String HOST = "http://localhost:8080";

    /** Метод добавления облигации */
    public Boolean addBond(String bondId, String bondName, String nominalCost,
                           String couponRate, String repaymentPeriod,
                           String couponFrequency, String yieldToMaturity, String ownerId,
                           String ownerName) {
        Map<String, String> map = new HashMap<>();
        map.put("bondname", bondName);
        map.put("bondid", bondId);
        map.put("nominalcost", nominalCost);
        map.put("couponfrequency", couponFrequency);
        map.put("repaymentperiod", repaymentPeriod);
        map.put("ownerid", ownerId);
        map.put("couponrate", couponRate);
        map.put("yieldtomaturity", yieldToMaturity);
        map.put("owner", ownerName);

        Gson gson = new Gson();
        String json = gson.toJson(map);
        String URL = String.format("%s/bonds/add", HOST);
        String response = HttpRequest.sendPost(URL, json);
        if (response != null) {
            JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();
            if (jsonResult.get("success").getAsBoolean()) {
                return true;
            }
        }
        return false;
    }

    /** Получаем всю информацию об облигациях */
    public List<Bond> getAllBonds() {
        String URL = HOST + "/bonds/all";
        List<Bond> result = new ArrayList<>();
        String response = HttpRequest.sendGet(URL);

        if (response != null) {
            JsonArray jsonBondArray = JsonParser.parseString(response).getAsJsonArray();
            for (int i = 0; i < jsonBondArray.size(); i++) {
                JsonObject bondJson = jsonBondArray.get(i).getAsJsonObject();
                Bond bond = new Bond(
                        bondJson.get("bondName").getAsString(),
                        bondJson.get("bondId").getAsInt(),
                        bondJson.get("nominalcost").getAsInt(),
                        bondJson.get("couponfrequency").getAsInt(),
                        bondJson.get("repaymentPeriod").getAsInt(),
                        bondJson.get("couponRate").getAsInt(),
                        bondJson.get("yieldToMaturity").getAsInt(),
                        bondJson.get("ownerId").getAsInt(),
                        bondJson.get("ownerName").getAsString()
                );
                result.add(bond);
            }
        }

        return result;
    }


    /** Получаем всю информацию об облигациях для определенного владельца*/
    public List<Bond> getBondsByOwnerId(String ownerId) {
        String URL = String.format("%s/bonds/ownerId?ownerId=%s", HOST, ownerId);
        List<Bond> result = new ArrayList<>();
        String response = HttpRequest.sendGet(URL);

        if (response != null) {
            JsonArray jsonBondArray = JsonParser.parseString(response).getAsJsonArray();
            for (int i = 0; i < jsonBondArray.size(); i++) {
                JsonObject bondJson = jsonBondArray.get(i).getAsJsonObject();
                Bond bond = new Bond(
                        bondJson.get("bondName").getAsString(),
                        bondJson.get("bondId").getAsInt(),
                        bondJson.get("nominalcost").getAsInt(),
                        bondJson.get("couponfrequency").getAsInt(),
                        bondJson.get("repaymentPeriod").getAsInt(),
                        bondJson.get("couponRate").getAsInt(),
                        bondJson.get("yieldToMaturity").getAsInt(),
                        bondJson.get("ownerId").getAsInt(),
                        bondJson.get("ownerName").getAsString()
                );
                result.add(bond);
            }
        }

        return result;
    }

    /** Удаляем облигацию у определенного владельца */
    public boolean deleteBond(String bondId, String ownerId) {
        String URL = String.format("%s/bonds/delete?bondId=%s&ownerId=%s", HOST, bondId, ownerId);
        String response = HttpRequest.sendDelete(URL);
        if (response != null) {
            return true;
        }
        return false;
    }

    public boolean editBond(String bondId, String bondName,
                            String ownerId, String ownerName, String nominalCost,
                            String couponRate, String repaymentPeriod,
                            String couponFrequency, String yieldToMaturity
                            ) {
        String URL = String.format("%s/bonds/edit", HOST);
        Map<String, String> map = new HashMap<>();
        map.put("bondname", bondName);
        map.put("bondid", bondId);
        map.put("nominalcost", nominalCost);
        map.put("couponfrequency", couponFrequency);
        map.put("repaymentperiod", repaymentPeriod);
        map.put("ownerid", ownerId);
        map.put("couponrate", couponRate);
        map.put("yieldtomaturity", yieldToMaturity);
        map.put("owner", ownerName);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        String response = HttpRequest.sendPut(URL, json);
        if (response != null) {
            return true;
        }
        return false;
    }

    public String calculatePortfolio(String ownerId) {
        String URL = String.format("%s/bonds/calculateDuration?ownerId=%s", HOST, ownerId);
        String response = HttpRequest.sendGet(URL);

        return response;
    }}