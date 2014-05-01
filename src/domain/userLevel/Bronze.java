/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.userLevel;

/**
 *
 * @author emilfrisk
 */
public class Bronze implements UserLevel {

    private double conversionRate = 1;
    private int limit = 0;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public double getConversionRate() {
        return this.conversionRate;
    }

}
