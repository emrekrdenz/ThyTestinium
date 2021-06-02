package com.thy;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class StepImpl extends HookImpl{


    @Step({"<seconds> saniye bekle"})
    public void waitBySecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step({"Al butonuna tikla"})
    public void existClickByKey() {
        MobileElement bookAFlight = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/acMain_btnBooking");
        bookAFlight.click();
    }
    @Step({"Tek Yön Uçuş seç"})
    public void oneWay(){
        MobileElement oneWay = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_tvOneWay");
        oneWay.click();
    }
    @Step({"Kalkış yeri seç"})
    public void selectDeparture(){
        MobileElement departure_place = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_tvFromCode");
        departure_place.click();
    }

    @Step({"Kalkış yerini <key> olarak seç"})
    public void sendKey(String key){
        MobileElement departure_place_key = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        departure_place_key.sendKeys(key);

        MobileElement departure_place_key1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]");
        departure_place_key1.click();

    }

    @Step({"Varış yerini <key> olarak seç"})
    public void sendArrival(String key){
        MobileElement el1 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_llTo");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        el2.sendKeys("ESB");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]");
        el3.click();
    }
    @Step({"Tarih seç"})
    public void selectDate(){
        MobileElement dateClick = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_rlDeparture");
        dateClick.click();
        List<MobileElement> dateSelected = (List<MobileElement>) driver.findElementsByXPath("//*[@class=\"android.view.ViewGroup\"]/android.view.ViewGroup/android.widget.FrameLayout");
        dateSelected.get(0).isSelected();
        int index = 0;
        for (MobileElement element: dateSelected) {
            if (element.isSelected()){
                index = dateSelected.indexOf(element) + 2;
            }
        }
        dateSelected.get(index).click();

    }

    @Step("Tamam butonuna tıkla")
    public void pressOk(){
        MobileElement pressOk = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_btnDone");
        pressOk.click();
    }

    @Step({"Kişi sayısını <key> artır"})
    public void numberOfPassengers(int key){
        MobileElement passengersNum = (MobileElement)driver.findElementByXPath("//*[@class='android.widget.TextView' and @bounds='[925,1040][1079,1194]']");

        for (int i = 0; i < key; i++){
            passengersNum.click();
        }

    }
    @Step({"Uçuş ara"})
    public void searchFlight(){
        MobileElement searchFly = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_btnSearch");
        searchFly.click();
    }
    @Step({"Uçuş liste kontrol"})
    public void listControl(){
        MobileElement flyListControl = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frFlightSearch_rvFlight");
        Assert.assertTrue(flyListControl.isDisplayed());
    }
    @Step({"Ekonomik uçuş seç"})
    public void selectEcoFly() throws InterruptedException {
        List<MobileElement> ecoFlyCard = (List<MobileElement>) driver.findElementsByXPath("//*[@class=\"androidx.recyclerview.widget.RecyclerView\"]/android.view.ViewGroup/android.widget.FrameLayout");
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(ecoFlyCard.size());
        ecoFlyCard.get(randomNumber).click();
        Thread.sleep(2000);
        WebElement ecoFlyClick= driver.findElement(By.xpath("//*[contains(@text,'EcoFly')]"));
        ecoFlyClick.click();
    }


    @Step({"Devam Butonuna tıklanır"})
    public void pressContinue(){
        MobileElement pressContinue = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frFlightSearch_btnContinue");
        pressContinue.click();
    }






}
