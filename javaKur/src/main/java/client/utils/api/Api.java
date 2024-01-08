package client.utils.api;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс Api - нужен для связи с сервером по HTTP протоколу
 */
public class Api {
    private final String HOST = "http://localhost:8080";

    /**
     * Метод добавления облигации
     */
    public Boolean addBond(String bondName, String bondId, String nominalCost,
                           String couponFrequency, String repaymentPeriod,
                           String couponRate, String yieldToMaturity, String ownerId,
                           String ownerName) {
        Map<String, String> map = new HashMap<>();
        map.put("bondName", bondName);
        map.put("bondId", bondId);
        map.put("nominalCost", nominalCost);
        map.put("couponFrequency", couponFrequency);
        map.put("repaymentPeriod", repaymentPeriod);
        map.put("ownerId", ownerId);
        map.put("couponRate", couponRate);
        map.put("yieldToMaturity", yieldToMaturity);
        map.put("ownerName", ownerName);
        return true;
    }
    }

//    /**
//     * Метод обновление информации о пользователе
//     *
//     * @param firstName   имя
//     * @param lastName    фамилия
//     * @param login       логин
//     * @param email       почта
//     * @param phoneNumber номер телефона
//     * @param birthDate   дата рождения
//     * @param password    пароль
//     * @return true если создали пользователя в БД
//     */
//    public Boolean updateUser(String firstName, String lastName, String login,
//                              String email, String phoneNumber, LocalDate birthDate, String password) {
//        String URL = String.format("%s/users/update", HOST);
//        Map<String, String> user = new HashMap<>();
//        user.put("login", login);
//        user.put("firstName", firstName);
//        user.put("lastName", lastName);
//        user.put("email", email);
//        if (birthDate != null) {
//            user.put("birthDate", String.valueOf(birthDate));
//        }
//        user.put("phoneNumber", phoneNumber);
//        user.put("password", password);
//
//        Gson gson = new Gson();
//        String json = gson.toJson(user);
//        String response = HttpRequest.sendPut(URL, json);
//        if (response != null) {
//            JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();
//            if (jsonResult.get("success").getAsBoolean()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Метод удаления пользователя по почте
//     *
//     * @param email    почта
//     * @param password пароль
//     * @return true если удалили пользователя из БД
//     */
//    public boolean deleteUser(String email, String password) {
//        password = URLEncoder.encode(password, StandardCharsets.UTF_8);
//
//        String URL = String.format("%s/users/delete?email=%s&password=%s", HOST, email, password);
//        String response = HttpRequest.sendGet(URL);
//        if (response != null) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }
//
//    /**
//     * Получаем всю информацию авиакомпаний
//     *
//     * @param filter вид сортировки
//     * @return список авиакомпаний
//     */
//    public List<Bond> getAllBonds(Boolean filter) {
//        String URL = String.format("%s/bonds/all?filter=%s", HOST, filter);
//        List<Bond> result = new ArrayList<>();
//        String response = HttpRequest.sendGet(URL);
//
//        if (response != null) {
//            JsonArray jsonBondArray = JsonParser.parseString(response).getAsJsonArray();
//            for (int i = 0; i < jsonBondArray.size(); i++) {
//                JsonObject bondJson = jsonBondArray.get(i).getAsJsonObject();
//
//                Bond bond = new Bond();
//                bond.setId(bondJson.get("bond_id").getAsLong());
//                bond.setBond_name(bondJson.get("bondName").getAsString());
//                bond.setMaturity(bondJson.get("maturity").getAsInt());
//                bond.setNominal(bondJson.get("nominal").getAsInt());
//                bond.setCoupon_size(bondJson.get("coupon_size").getAsInt());
//                bond.setNumber_of_coupon_periods(bondJson.get("number_of_coupon_periods").getAsInt());
//                bond.setBond_duration(bondJson.get("bond_duration").getAsInt());
//
//                result.add(bond);
//            }
//        }
//
//        return result;
//    }
//
//    /**
//     * Получаем всю информацию авиакомпаний по подстроке
//     *
//     * @param subString подстрока названия авиакомпании
//     * @param filter    вид сортировки
//     * @return список авиакомпаний
//     */
//    public List<Bond> getBondsBySubBondName(String subString, Boolean filter) {
//        subString = URLEncoder.encode(subString, StandardCharsets.UTF_8);
//
//
//        String URL = String.format("%s/bonds/like?name=%s&filter=%s", HOST, subString, filter);
//        List<Bond> result = new ArrayList<>();
//        String response = HttpRequest.sendGet(URL);
//
//        if (response != null) {
//            JsonArray jsonBondArray = JsonParser.parseString(response).getAsJsonArray();
//            for (int i = 0; i < jsonBondArray.size(); i++) {
//                JsonObject bondJson = jsonBondArray.get(i).getAsJsonObject();
//
//                Bond bond = new Bond();
//                bond.setId(bondJson.get("bond_id").getAsLong());
//                bond.setBond_name(bondJson.get("bondName").getAsString());
//                bond.setMaturity(bondJson.get("maturity").getAsInt());
//                bond.setNominal(bondJson.get("nominal").getAsInt());
//                bond.setCoupon_size(bondJson.get("coupon_size").getAsInt());
//                bond.setNumber_of_coupon_periods(bondJson.get("number_of_coupon_periods").getAsInt());
//                bond.setBond_duration(bondJson.get("bond_duration").getAsInt());
//
//                result.add(bond);
//            }
//        }
//        return result;
//    }
//    /**
//     * Получаем всю информацию авиакомпаний
//     *
//     * @param filter вид сортировки
//     * @return список авиакомпаний
//     */
//    public List<Composition> getAllCompositions(String login) {
//        String URL = String.format("%s/compositions/all?login=%s", HOST, login);
//        List<Composition> result = new ArrayList<>();
//        String response = HttpRequest.sendGet(URL);
//
//        if (response != null) {
//
//            JsonArray jsonArray = JsonParser.parseString(response).getAsJsonArray();
//
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JsonObject сompositionJson = jsonArray.get(i).getAsJsonObject();
//                JsonObject bondJson = сompositionJson.get("bond").getAsJsonObject();
//                JsonObject portfolioJson = сompositionJson.get("portfolio").getAsJsonObject();
//
//                Composition сomposition = new Composition();
//                сomposition.setId(сompositionJson.get("composition_id").getAsLong());
//                //Имена в "" из сервера(Entity)
//                сomposition.setBond_name(bondJson.get("bondName").getAsString());
//                сomposition.setPortfolio_name(portfolioJson.get("portfolioName").getAsString());
//                сomposition.setBond_share(сompositionJson.get("bondShare").getAsDouble());
//
//
//                result.add(сomposition);
//            }
//        }
//
//        return result;
//    }
//
//    /**
//     * Получаем всю информацию авиакомпаний
//     *
//     * @param filter вид сортировки
//     * @return список авиакомпаний
//     */
//    public List<Composition> getCompositionsBySubName(String login, String name) {
//        name = URLEncoder.encode(name, StandardCharsets.UTF_8);
//
//        String URL = String.format("%s/compositions/like?login=%s&name=%s", HOST, login, name);
//        List<Composition> result = new ArrayList<>();
//        String response = HttpRequest.sendGet(URL);
//
//        if (response != null) {
//
//            JsonArray jsonArray = JsonParser.parseString(response).getAsJsonArray();
//
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JsonObject сompositionJson = jsonArray.get(i).getAsJsonObject();
//                JsonObject bondJson = сompositionJson.get("bond").getAsJsonObject();
//                JsonObject portfolioJson = сompositionJson.get("portfolio").getAsJsonObject();
//
//                Composition сomposition = new Composition();
//                сomposition.setId(сompositionJson.get("composition_id").getAsLong());
//                //Имена в "" из сервера(Entity)
//                сomposition.setBond_name(bondJson.get("bondName").getAsString());
//                сomposition.setPortfolio_name(portfolioJson.get("portfolioName").getAsString());
//                сomposition.setBond_share(сompositionJson.get("bondShare").getAsDouble());
//
//
//                result.add(сomposition);
//            }
//        }
//
//        return result;
//    }
//    public double getDurationBySubName(String login, String name) {
//        name = URLEncoder.encode(name, StandardCharsets.UTF_8);
//
//        String URL = String.format("%s/compositions/like?login=%s&name=%s", HOST, login, name);
//        double duration_result = 0;
//        String response = HttpRequest.sendGet(URL);
//
//        if (response != null) {
//
//            JsonArray jsonArray = JsonParser.parseString(response).getAsJsonArray();
//
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JsonObject сompositionJson = jsonArray.get(i).getAsJsonObject();
//                JsonObject bondJson = сompositionJson.get("bond").getAsJsonObject();
//                JsonObject portfolioJson = сompositionJson.get("portfolio").getAsJsonObject();
//
//                duration_result += (bondJson.get("bond_duration").getAsInt()*(сompositionJson.get("bondShare").getAsDouble())/100);
//
//            }
//        }
//        return duration_result;
//    }
//
//    /**
//     * Метод регистрации пользователя
//     *
//     * @param firstName имя
//     * @param lastName  фамилия
//     * @param login     логин
//     * @param email     почта
//     * @param password  пароль
//     * @return true  если добавлен в БД
//     */
//    public Boolean addBond(String bond_name,
//                           Integer maturity,
//                           Integer nominal,
//                           Integer coupon_size,
//                           Integer number_of_coupon_periods,
//                           Integer bond_duration) {
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("bondName", bond_name);
//        map.put("maturity", maturity);
//        map.put("nominal", nominal);
//        map.put("coupon_size", coupon_size);
//        map.put("number_of_coupon_periods", number_of_coupon_periods);
//        map.put("bond_duration", bond_duration);
//
//        Gson gson = new Gson();
//        String json = gson.toJson(map);
//
//        String URL = String.format("%s/bonds/add", HOST);
//        String response = HttpRequest.sendPost(URL, json);
//        if (response != null) {
//            JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();
//            if (jsonResult.get("success").getAsBoolean()) {
//                return true;
//            }
//        }
//        return false;
//    }
//    /**
//     * Метод удаления пользователя по почте
//     *
//     * @return true если удалили пользователя из БД
//     */
//    public boolean deleteBond(String name) {
//
//        String URL = String.format("%s/bonds/delete?name=%s", HOST, name);
//        String response = HttpRequest.sendGet(URL);
//        if (response != null) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }
//    public List<Portfolio> getPortfolioBySubName(String login, String name) {
//        name = URLEncoder.encode(name, StandardCharsets.UTF_8);
//
//
//        String URL = String.format("%s/portfolios/like?login=%s&name=%s", HOST, login, name);
//        List<Portfolio> result = new ArrayList<>();
//        String response = HttpRequest.sendGet(URL);
//
//        if (response != null) {
//            JsonArray jsonArray = JsonParser.parseString(response).getAsJsonArray();
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JsonObject portfolioJson = jsonArray.get(i).getAsJsonObject();
//
//
//                Portfolio portfolio = new Portfolio();
//                portfolio.setId(portfolioJson.get("portfolio_id").getAsLong());
//                portfolio.setPortfolio_name(portfolioJson.get("portfolioName").getAsString());
//
//
//
//                result.add(portfolio);
//            }
//        }
//        return result;
//    }
//
//    /**
//     * Метод регистрации пользователя
//     *
//     * @param firstName имя
//     * @param lastName  фамилия
//     * @param login     логин
//     * @param email     почта
//     * @param password  пароль
//     * @return true  если добавлен в БД
//     */
//    public Boolean addToPortfolio(Double bond_share,
//                           String bondName,
//                           String portfolioName) {
//
//        Gson gson = new Gson();
//
//        List<Bond> bonds = getBondsBySubBondName(bondName, false);
//        List<Portfolio> portfolios = getPortfolioBySubName(currentLoginPerson.getLogin(), portfolioName);
//        Long portfolioLongId = null;
//        if (portfolios.size() != 0) {
//            Portfolio portfolio = portfolios.get(0);
//            portfolioLongId = portfolio.getId().longValue();
//        }
//        Bond bond = bonds.get(0);
//        Long bondLongId = bond.getId().longValue();
//
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("bondShare", bond_share);
//        map.put("bond_id", bondLongId);
//        map.put("portfolio_id", portfolioLongId);
//        map.put("portfolioName", portfolioName);
//        map.put("login", currentLoginPerson.getLogin());
//
//        String json = gson.toJson(map);
//
//        String URL = String.format("%s/compositions/add", HOST);
//        String response = HttpRequest.sendPost(URL, json);
//        if (response != null) {
//            JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();
//            if (jsonResult.get("success").getAsBoolean()) {
//                return true;
//            }
//        }
//        return false;
//    }
//    /**
//     * Метод удаления пользователя по почте
//     *
//     * @return true если удалили пользователя из БД
//     */
//    public boolean deleteComposition(String login, String name) {
//
//        String URL = String.format("%s/compositions/delete?login=%s&name=%s", HOST, login, name);
//        String response = HttpRequest.sendGet(URL);
//        if (response != null) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }


